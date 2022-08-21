package com.xdl.maven.imperial.servlet.module;


import com.xdl.maven.imperial.entity.Memorials;
import com.xdl.maven.imperial.service.api.MemorialsService;
import com.xdl.maven.imperial.service.impl.MemorialsServiceImpl;
import com.xdl.maven.imperial.servlet.base.ModelBaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WorkServlet extends ModelBaseServlet {
    private MemorialsService memorialsService = new MemorialsServiceImpl();

    protected void showMemorialsDigestList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1、调用Service方法查询数据
        List<Memorials> memorialsList = memorialsService.getAllMemorialsDigest();
        // 2、将查询到的数据存入请求域
        request.setAttribute("memorialsList", memorialsList);
        // 3、渲染视图
        String templateName = "memorials-list";
        processTemplate(templateName, request, response);
    }

    protected void showMemorialsDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1、从请求参数中读取memorialsId
        String memorialsId = request.getParameter("memorialsId");
        // 2、根据id从service中查询Memorials对象
        Memorials memorials = memorialsService.getMemorialsDetailById(memorialsId);
        // **********************补充功能**********************
        // 获取当前奏折对象的状态
        Integer memorialsStatus = memorials.getMemorialsStatus();

        // 判断奏折状态
        if (memorialsStatus == 0) {
            // 更新奏折状态：数据库修改
            memorialsService.updateMemorialsStatusToRead(memorialsId);

            // 更新奏折状态：当前对象修改
            memorials.setMemorialsStatus(1);
        }
        // **********************补充功能**********************


        // 3、 将Memorials对象存入请求域
        request.setAttribute("memorials", memorials);
        // 4、 解析渲染视图
        String templateName = "memorials-detail";
        processTemplate(templateName, request, response);
    }
}
