package com.wenjie.adc.servlet;

import com.wenjie.adc.pojo.User;
import com.wenjie.adc.service.UserService;
import com.wenjie.adc.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserListServlet extends BaseServlet {

    private UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();

        // 加载Spring配置文件, 得到Spring容器对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        // 从容器中获取需要的对象
        this.userService = context.getBean("userService", UserService.class);

    }




    public void userList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String  username =req.getParameter("username");
        String  age =req.getParameter("age");


        List<User> users =  userService.userList(username,age);
        //结果保存作用域
        req.setAttribute("users",users);
        req.setAttribute("username",username);
        req.setAttribute("age",age);
        //页面跳转
        req.getRequestDispatcher("/userList.jsp").forward(req,resp);

    }
    /**
     * 登录
     * @param req
     * @param resp
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  username =req.getParameter("username");
        String  password =req.getParameter("password");

        //调用service
        try{
            User user = userService.login(username, password);
            if(user!=null){
                //调用service
                List<User> users =  userService.userList("","");
                //结果保存作用域
                req.setAttribute("users",users);
                //页面跳转
                req.getRequestDispatcher("/userList.jsp").forward(req,resp);
                return;
            }


        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("msg","注册失败："+e.getMessage());
            req.getRequestDispatcher("/register.jsp").forward(req,resp);

        }


    }

    /**
     * 注册
     * @param req
     * @param resp
     */
    public void register(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        //接收参数
        User user=new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setRealname(req.getParameter("realname"));
        user.setAge(req.getParameter("age"));
        user.setBirthday(req.getParameter("birthday"));

        //调用service
        try{
            userService.register(user);
            //页面跳转：login.jsp
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("msg","注册失败："+e.getMessage());
            req.getRequestDispatcher("/register.jsp").forward(req,resp);

        }


    }

//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        //super.service(req, res);
//
//        //调用service
//        List<User> users =  userService.userList();
//        //结果保存作用域
//        req.setAttribute("users",users);
//        //页面跳转
//        req.getRequestDispatcher("/userList.jsp").forward(req,res);
//    }

}
