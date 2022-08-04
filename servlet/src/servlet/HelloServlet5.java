package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class HelloServlet5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求资源路径是:" + req.getRequestURI());
        System.out.println("请求绝对路径路径是:" + req.getRequestURL());
        System.out.println("客户端ip:" + req.getRemoteHost());
        System.out.println("请求头:" + req.getHeader("Host"));
        System.out.println("请参数:" + req.getParameter("username"));
        System.out.println("多请求参数:" + Arrays.asList(req.getParameterValues("hobby")));
    }
}
