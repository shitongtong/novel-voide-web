package com.zzy.servlet.user.movie;

import com.zzy.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stt on 2018/4/29.
 */
@WebServlet("/user/deleteMovie")
public class DeleteMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieUuid = req.getParameter("movieUuid");
        MovieService movieService = new MovieService();
        movieService.delete(movieUuid);

        String userUuid = req.getParameter("userUuid");
        req.getRequestDispatcher("/user/movieInfo?userUuid="+userUuid).forward(req, resp);
    }
}
