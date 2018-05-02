package com.zzy.servlet;

import com.zzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stt on 2018/4/30.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name==null || "".equals(name) || password==null || "".equals(password)){
            req.setAttribute("msg","注册失败，输入用户名或密码！");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }else{
            UserService userService = new UserService();
            if (userService.exits(name)){
                req.setAttribute("msg","账号已注册，请重新注册！");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }else{
                if (userService.register(name,password)){
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }else{
                    req.setAttribute("msg","注册失败，请联系管理员！");
                    req.getRequestDispatcher("/register.jsp").forward(req, resp);
                }
            }
        }


    }
}
