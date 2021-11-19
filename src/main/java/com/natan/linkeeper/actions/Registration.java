
package com.natan.linkeeper.actions;

import com.natan.linkeeper.model.DataBase;
import com.natan.linkeeper.model.Link;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements Action {

    public String run(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        // get request parameters
        String siteName = request.getParameter("name");
        String siteUrl = request.getParameter("url");

        // instantiate a new object with the request parameter
        Link newLink = new Link(siteName, siteUrl);

        // get access to the simulated DataBase
        DataBase db = new DataBase();

        // register the new site to the database
        db.INSERT(newLink);

        return "redirect:LoadList";
    }
}
