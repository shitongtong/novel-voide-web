package com.zzy.servlet.user.movie;

import com.zzy.po.MovieComment;
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
@WebServlet("/user/addMovieUsenum")
public class AddMovieUsenumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieCommentUuid = req.getParameter("movieCommentUuid");
        MovieCommentService movieCommentService = new MovieCommentService();
        movieCommentService.update(movieCommentUuid);

        MovieComment movieComment = movieCommentService.findByMovieCommentUuid(movieCommentUuid);
        String movieUuid = movieComment.getMovieUuid();
        String userUuid = movieComment.getCreateUid();
        req.getRequestDispatcher("/movieComment?movieUuid=" + movieUuid + "&userUuid=" + userUuid).forward(req, resp);
    }
}
