package com.starstar.web;

import com.starstar.pojo.User;
import com.starstar.service.UserService;
import com.starstar.service.impl.UserServiceImpl;
import com.starstar.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 处理登录请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void loginServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
        //优化1、使用webutils工具类注入user对象，减少参数的获取流程
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //2、调用login方法验证登录
        User loginUser = userService.login(new User(null,user.getUsername(),user.getPassword(),null));
        if (loginUser == null){
            //把错误信息，和回显的表单信息，保存到request域中
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("password",user.getPassword());

            //跳回登陆页面

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            //登录成功,跳转到登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    /**
     * 处理注册请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void registServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //1、获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //优化1、使用webutils工具类注入user对象，减少参数的获取流程
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //2、检查验证码是否正确
        if ("bnbnp".equalsIgnoreCase(code)){
            //3、检查用户名是否可用
            if (userService.exitsUser(user.getUsername())) {
                //回显信息
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",user.getUsername());
                req.setAttribute("password",user.getPassword());
                req.setAttribute("email",user.getEmail());
                req.setAttribute("code",code);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                //调用registUser保存注册用户
                userService.registUser(new User(null,user.getUsername(),user.getPassword(),user.getEmail()));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        } else {
            //回显信息
            req.setAttribute("msg","用户名已存在");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("password",user.getPassword());
            req.setAttribute("email",user.getEmail());
            req.setAttribute("code",code);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

}
