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
}
