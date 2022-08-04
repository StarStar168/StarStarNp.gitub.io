package com.starstar.web;

import com.starstar.pojo.User;
import com.starstar.service.UserService;
import com.starstar.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2、调用login方法验证登录
        User loginUser = userService.login(new User(null,username,password,null));
        if (loginUser == null){
            //把错误信息，和回显的表单信息，保存到request域中
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            req.setAttribute("password",password);

            //跳回登陆页面

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            //登录成功,跳转到登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
}


