package com.zzy.servlet;

import com.zzy.po.Movie;
import com.zzy.po.User;
import com.zzy.service.MovieService;
import com.zzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.zzy.constants.Constant.COLUMNSIZE;

/**
 * Created by stt on 2018/4/29.
 */
@WebServlet("/homeMovie")
public class HomeMovieServlet extends HttpServlet {

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

        MovieService movieService = new MovieService();
        List<Movie> movieList = movieService.findAll();
        List<List<Movie>> movieListList = new ArrayList<>();
        if (movieList != null && movieList.size() > 0) {
            int size = movieList.size();

            int i = size / COLUMNSIZE;
            int j = size % COLUMNSIZE;

            for (int k = 0; k < i; k++) {
                List<Movie> movieListT = new ArrayList<>();
                for (int l = 0; l < COLUMNSIZE; l++) {
                    movieListT.add(movieList.get(COLUMNSIZE * k + l));
                }
                movieListList.add(movieListT);
            }
            List<Movie> movieListT = new ArrayList<>();
            for (int k = 0; k < j; k++) {
                movieListT.add(movieList.get(COLUMNSIZE * i + k));
            }
            movieListList.add(movieListT);
        }

        req.setAttribute("movieListList", movieListList);
        req.getRequestDispatcher("/homeMovie.jsp").forward(req, resp);
    }
}
