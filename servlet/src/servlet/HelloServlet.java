package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());

        //获取初始化参数init-param;init-param可以设置多个，是键值对，通过key获取值
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));

        //获取servletContext对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service方法用于处理请求和响应的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //向下转型，getMethod（）方法只有servletRequest才可以用
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    public void doGet() {
        System.out.println("这里是get请求方式");
    }

    public void doPost() {
        System.out.println("这里是post请求方式");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("这里销毁程序啦！");
    }
}
