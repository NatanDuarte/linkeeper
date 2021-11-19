
package com.natan.linkeeper.actions;

import com.natan.linkeeper.model.DataBase;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadList implements Action {

    public String run(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        // get access to the simulated database and hook up 
        // the list of items on the next request
        DataBase db = new DataBase();
        request.setAttribute("links", db.SELECT_ALL_LINKS());

        return "forward:list.jsp";
    }
}
