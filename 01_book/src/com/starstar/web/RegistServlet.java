package com.starstar.web;

import com.starstar.pojo.User;
import com.starstar.service.UserService;
import com.starstar.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2、检查验证码是否正确
        if ("bnbnp".equalsIgnoreCase(code)){
            //3、检查用户名是否可用
            if (userService.exitsUser(username)) {
                //回显信息
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("email",email);
                req.setAttribute("code",code);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                //调用registUser保存注册用户
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        } else {
            //回显信息
            req.setAttribute("msg","用户名已存在");
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.setAttribute("email",email);
            req.setAttribute("code",code);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }
}
