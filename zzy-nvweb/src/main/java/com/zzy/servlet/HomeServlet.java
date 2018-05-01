package com.zzy.servlet;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stt on 2018/4/29.
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = (User) req.getAttribute("user");
        String userUuid = req.getParameter("userUuid");
        UserService userService = new UserService();
        User user = userService.findByUserUuid(userUuid);
        req.setAttribute("user",user);

        NovelService novelService = new NovelService();
        List<Novel> novelList = novelService.findAll();
        List<List<Novel>> novelListList = new ArrayList<>();
        if (novelList!=null && novelList.size()>0){
            int size = novelList.size();

            int i = size / 4;
            int j = size % 4;

            for (int k = 0; k < i; k++) {
                List<Novel>  novelListT = new ArrayList<>();
                for (int l = 0; l < 4; l++) {
                    novelListT.add(novelList.get(4*k+l));
                }
                novelListList.add(novelListT);
            }
            List<Novel> novelListT = new ArrayList<>();
            for (int k = 0; k < j; k++) {
                novelListT.add(novelList.get(4*i+k));
            }
            novelListList.add(novelListT);
        }

        req.setAttribute("novelListList",novelListList);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
