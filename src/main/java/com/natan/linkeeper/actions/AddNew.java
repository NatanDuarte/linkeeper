
package com.natan.linkeeper.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNew implements Action {

    public String run(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        return "forward:registration.jsp";
    }
}
