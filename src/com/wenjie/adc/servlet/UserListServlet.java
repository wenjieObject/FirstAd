package com.wenjie.adc.servlet;

import com.wenjie.adc.pojo.User;
import com.wenjie.adc.service.UserService;
import com.wenjie.adc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //super.service(req, res);

        //调用service
        List<User> users =  userService.userList();
        //结果保存作用域
        req.setAttribute("users",users);
        //页面跳转
        req.getRequestDispatcher("/userList.jsp").forward(req,res);
    }

}
