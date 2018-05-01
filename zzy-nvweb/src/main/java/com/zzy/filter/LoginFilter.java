package com.zzy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by stt on 2018/4/29.
 */
@WebFilter("/user/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将servletRequest转发为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String userUuid = request.getParameter("userUuid");
        if (userUuid == null || "".equals(userUuid)) {
            request.getRequestDispatcher("/login.jsp").forward(request,servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
