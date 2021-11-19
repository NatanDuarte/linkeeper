
package com.natan.linkeeper.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "Authorization", urlPatterns = {"/app"})
public class Authorization implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        boolean userNotLoggedIn = session.getAttribute("loggedUser") == null;
        boolean isProtectedAction = !(action.equals("Login") || action.equals("LoginForm"));

        if (userNotLoggedIn && isProtectedAction)
            response.sendRedirect("app?action=LoginForm");

        chain.doFilter(request, response);
    }
}
