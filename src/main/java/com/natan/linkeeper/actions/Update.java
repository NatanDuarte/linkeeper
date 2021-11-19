
package com.natan.linkeeper.actions;

import com.natan.linkeeper.model.DataBase;
import com.natan.linkeeper.model.Link;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update implements Action {

    public String run(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        // get request parameters
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String url = request.getParameter("url");

        // get access to the simulated DataBase
        DataBase db = new DataBase();

        // search and update the element in the DataBase
        Link linkInDb = db.SELECT_WHERE_ID(id);
        linkInDb.setName(name);
        linkInDb.setUrl(url);

        // redirect to the list view so the user can see the changes
        return "redirect:LoadList";
    }
}
