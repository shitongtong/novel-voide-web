package com.zzy.servlet.user.book;

import com.zzy.service.NovelService;
import com.zzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stt on 2018/4/29.
 */
@WebServlet("/user/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String novelUuid = req.getParameter("novelUuid");
        NovelService novelService = new NovelService();
        novelService.delete(novelUuid);

        String userUuid = req.getParameter("userUuid");
        req.getRequestDispatcher("/user/info?userUuid="+userUuid).forward(req, resp);
    }
}
