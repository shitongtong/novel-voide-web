package com.zzy.servlet.user.movie;

import com.zzy.service.MovieCommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stt on 2018/4/29.
 */
@WebServlet("/user/addMovieComment")
public class AddMovieCommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userUuid = req.getParameter("userUuid");
        String movieUuid = req.getParameter("movieUuid");
        String content = req.getParameter("content");

        //评论
        MovieCommentService movieCommentService = new MovieCommentService();
        movieCommentService.save(content, movieUuid, userUuid);

        req.getRequestDispatcher("/movieComment?movieUuid=" + movieUuid + "&userUuid=" + userUuid).forward(req, resp);
    }
}
