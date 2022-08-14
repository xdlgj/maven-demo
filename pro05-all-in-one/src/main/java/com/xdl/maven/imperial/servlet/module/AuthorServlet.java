package com.xdl.maven.imperial.servlet.module;

import com.xdl.maven.imperial.entity.Emp;
import com.xdl.maven.imperial.exception.LoginFailedException;
import com.xdl.maven.imperial.service.api.EmpService;
import com.xdl.maven.imperial.service.impl.EmpServiceImpl;
import com.xdl.maven.imperial.servlet.base.ModelBaseServlet;
import com.xdl.maven.imperial.util.ImperialCourtConst;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorServlet extends ModelBaseServlet {

    private EmpService empService = new EmpServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           //1、获取登录的请求参数
           String loginAccount = request.getParameter("loginAccount");
           String loginPassword = request.getParameter("loginPassword");
           //2、调用empService 方法执行登录逻辑
           Emp emp = empService.getEmpByLoginAccount(loginAccount, loginPassword);
           //3、通过request获取HttpSession对象
           HttpSession session = request.getSession();
           //4、将查询到的emp信息保存到session域中
           session.setAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME, emp);
           //5、前往指定页面视图
           String templateName = "temp";
           processTemplate(templateName, request, response);
       } catch (Exception e) {
           e.printStackTrace();
           //6、判断此处捕获的异常是否是登录失败异常
           if (e instanceof LoginFailedException) {
               //7、如果是登录失败异常则跳转回登录页面
               request.setAttribute("message", e.getMessage());
               processTemplate("index", request, response);
           } else {
               //8、如果不是登录异常则封装为运行时异常继续抛出
               throw new RuntimeException(e);
           }
       }
    }
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、通过 request 对象获取 HttpSession 对象
        HttpSession session = request.getSession();
        // 2、将 HttpSession 对象强制失效
        session.invalidate();
        // 3、回到首页
        String templateName = "index";
        processTemplate(templateName, request, response);
    }
}
