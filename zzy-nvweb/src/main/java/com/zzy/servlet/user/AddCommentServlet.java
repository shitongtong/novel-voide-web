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
@WebServlet("/user/addComment")
public class AddCommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userUuid = req.getParameter("userUuid");
        String novelUuid = req.getParameter("novelUuid");
        String comment = req.getParameter("comment");

        //评论
        CommentService commentService = new CommentService();
        commentService.save(comment, novelUuid, userUuid);

        req.getRequestDispatcher("/comment?novelUuid=" + novelUuid + "&userUuid=" + userUuid).forward(req, resp);
    }
}
