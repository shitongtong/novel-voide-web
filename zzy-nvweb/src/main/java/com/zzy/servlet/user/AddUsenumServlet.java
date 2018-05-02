package com.zzy.servlet.user;

import com.zzy.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stt on 2018/4/29.
 */
@WebServlet("/user/addUsenum")
public class AddUsenumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment = req.getParameter("commentUuid");
        CommentService commentService = new CommentService();

//        req.getRequestDispatcher("/comment?novelUuid=" + novelUuid + "&userUuid=" + userUuid).forward(req, resp);
    }
}
