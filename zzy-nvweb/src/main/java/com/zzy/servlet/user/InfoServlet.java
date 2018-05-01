package com.zzy.servlet.user;

import com.zzy.po.Novel;
import com.zzy.po.User;
import com.zzy.service.NovelService;
import com.zzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by stt on 2018/4/29.
 */
@WebServlet("/user/info")
public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userUuid = req.getParameter("userUuid");
        UserService userService = new UserService();
        User user = userService.findByUserUuid(userUuid);
        req.setAttribute("user", user);
        NovelService novelService = new NovelService();
        List<Novel> novelList = novelService.findByUserUuid(userUuid);
        req.setAttribute("novelList", novelList);
        req.getRequestDispatcher("/user/info.jsp").forward(req, resp);
    }
}
