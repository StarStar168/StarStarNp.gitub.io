package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在 HelloServlet7（柜台 2）中查看参数（材料）："+username);
            // 查看 柜台 1 是否有盖章
        Object key1 = req.getAttribute("key1");
        System.out.println("柜台 1 是否有章："+key1);
            // 处理自己的业务
        System.out.println("HelloServlet7 处理自己的业务 ");
    }


}

