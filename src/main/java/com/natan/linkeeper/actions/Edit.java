
package com.natan.linkeeper.actions;

import com.natan.linkeeper.model.DataBase;
import com.natan.linkeeper.model.Link;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Edit implements Action {

    public String run(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        // get the database id parameter from the request
        int id = Integer.parseInt(request.getParameter("id"));

        // get access to the simulated DataBase,
        // search for the element and hook up it to next request
        DataBase db = new DataBase();
        Link link = db.SELECT_WHERE_ID(id);

        request.setAttribute("link", link);

        return "forward:edit.jsp";
    }
}
