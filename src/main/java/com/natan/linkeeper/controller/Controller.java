
package com.natan.linkeeper.controller;

import com.natan.linkeeper.actions.Action;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res
            , FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String action = request.getParameter("action");
        String actionParameter = null;
        String className = "com.natan.linkeeper.actions."+action;

        // indirectly calls the action class from the
        // request by using the Reflection API
        try {
            Class generic = Class.forName(className);
            Action reflectedAction = (Action) generic.newInstance();
            actionParameter = reflectedAction.run(request, response);
        } catch (ClassNotFoundException | InstantiationException |  IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] typedAdress = actionParameter.split(":");
        boolean isRedirect = typedAdress[0].equalsIgnoreCase("redirect");

        if (isRedirect){
            String redirectParameters = "app?action="+typedAdress[1];
            response.sendRedirect(redirectParameters);
        } else {
            String viewPath = "WEB-INF/views/"+typedAdress[1];
            RequestDispatcher rd = request.getRequestDispatcher(viewPath);
            rd.forward(request, response);
        }
    }
}
