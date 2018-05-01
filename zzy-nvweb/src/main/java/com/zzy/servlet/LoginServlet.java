package com.zzy.servlet;

import com.zzy.po.User;
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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name == null || "".equals(name) || password == null || "".equals(password)) {
            req.setAttribute("msg", "登陆失败，输入用户名或密码！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            UserService userService = new UserService();
            User user = userService.findByName(name);
            if (user == null) {
                req.setAttribute("msg", "账号不存在！");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                if (!password.equals(user.getPassword())) {
                    req.setAttribute("msg", "密码不正确！");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                } else {
                    req.setAttribute("user", user);
                    req.getRequestDispatcher("/home?userUuid="+user.getUserUuid()).forward(req,resp);
                }
            }
        }
    }
}
