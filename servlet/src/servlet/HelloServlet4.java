package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取servletContext去<context-param>配置文件里获取内容
        ServletContext servletContext = getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        System.out.println(username);
        System.out.println(servletContext.getInitParameter("password"));

        //2、获取当前工程路径
        System.out.println("当前工程路径是：" + servletContext.getContextPath());

        //3、获取工程部署后在服务器硬盘上的绝对路径
        /// 斜杠被服务器解析地址为 :http://ip:port/工程名/ 映射到 IDEA 代码的的 web 目录
        System.out.println("工程部署的路径是:" + servletContext.getRealPath("/"));
    }
}
