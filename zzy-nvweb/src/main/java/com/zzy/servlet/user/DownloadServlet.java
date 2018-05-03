package com.zzy.servlet.user;

import com.zzy.constants.Constant;
import com.zzy.util.DownloadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/5/3.
 */
@WebServlet("/user/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        String fileName = url.substring(url.lastIndexOf(Constant.FILESEPARATOR) + 1);
        DownloadUtil.download(resp, url, fileName);
    }
}
