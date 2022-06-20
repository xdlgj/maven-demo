package com.xdl.maven;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
// 测试compile依赖范围对main目录有效
import com.xdl.maven.Calculator;
// 测试test依赖范围对main目录无效
import org.junit.Test;

/**
 * 测试方式：
 * 通过import语句将要测试的类引入到当前类，引入后：
 * 编译通过：可以使用，这个范围的依赖对当前类有效
 * 编译失败：不能使用，这个范围的依赖对当前类无效
 * main 目录下的java类：HelloServlet
 * compile 范围引入的依赖：pro01-maven-java
 * pro01-maven-java中的类： Calculator
 * -------------------------------------
 * 测试test依赖范围
 */
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.getWriter().write("hello maven web");
    }
}