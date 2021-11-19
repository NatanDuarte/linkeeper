
package com.natan.linkeeper.actions;

import com.natan.linkeeper.model.DataBase;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete implements Action {

    public String run(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        int id = Integer.parseInt(request.getParameter("id"));

        // find and remove the element who the given id belongs
        DataBase db = new DataBase();
        db.DELETE_WHERE_ID(id);

        return "redirect:LoadList";
    }
}
