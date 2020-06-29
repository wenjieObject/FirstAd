package com.wenjie.adc.servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class BaseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, res);

        //接收请求参数
        String method = req.getParameter("method");

        if (method==null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        //通过反射获类--泛型是BaseServlet的子类
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            //拿到方法
            Method methodx = aClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            methodx.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();

            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }


    }
}
