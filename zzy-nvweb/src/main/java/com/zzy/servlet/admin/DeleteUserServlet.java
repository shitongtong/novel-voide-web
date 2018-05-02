package com.zzy.servlet.admin;

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
@WebServlet("/user/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteUserUuid = req.getParameter("deleteUserUuid");
        UserService userService = new UserService();
        userService.delete(deleteUserUuid);

        String userUuid = req.getParameter("userUuid");
        req.getRequestDispatcher("/user/manager?userUuid="+userUuid).forward(req, resp);
    }
}
