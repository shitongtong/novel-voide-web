package com.zzy.servlet;

import com.zzy.dto.CommentDto;
import com.zzy.po.Novel;
import com.zzy.po.User;
import com.zzy.service.CommentService;
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
@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

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

        //小说
        String novelUuid = req.getParameter("novelUuid");
        NovelService novelService = new NovelService();
        Novel novel = novelService.findByNovelUuid(novelUuid);
        req.setAttribute("novel", novel);

        //评论
        CommentService commentService = new CommentService();
        List<CommentDto> commentDtoList = commentService.findByNovelUuid(novelUuid);
        req.setAttribute("dtoList",commentDtoList);
        req.getRequestDispatcher("/user/comment.jsp").forward(req, resp);
    }
}
