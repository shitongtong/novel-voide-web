package com.zzy.servlet;

import com.zzy.dto.MovieCommentDto;
import com.zzy.po.Movie;
import com.zzy.po.User;
import com.zzy.service.MovieCommentService;
import com.zzy.service.MovieService;
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
@WebServlet("/movieComment")
public class MovieCommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //用户
        String userUuid = req.getParameter("userUuid");
        UserService userService = new UserService();
        User user = userService.findByUserUuid(userUuid);
        req.setAttribute("user", user);

        //电影
        String movieUuid = req.getParameter("movieUuid");
        MovieService movieService = new MovieService();
        Movie movie = movieService.findByMovieUuid(movieUuid);
        req.setAttribute("movie", movie);

        //评论
        MovieCommentService movieCommentService = new MovieCommentService();
        List<MovieCommentDto> movieCommentDtoList = movieCommentService.findByMovieUuid(movieUuid);
        req.setAttribute("dtoList",movieCommentDtoList);
        req.getRequestDispatcher("/user/movieComment.jsp").forward(req, resp);
    }
}
