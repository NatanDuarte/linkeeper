
package com.natan.linkeeper.actions;

import com.natan.linkeeper.model.DataBase;
import com.natan.linkeeper.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login implements Action {

    public String run(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // check if the credentials match in the DataBase
        DataBase db = new DataBase();
        User user = db.SELECT_USER(login, password);

        if (user == null)
            return "redirect:LoginForm";

        // hooks user information into the session request
        HttpSession session = request.getSession();
        session.setAttribute("loggedUser", user);

        return "redirect:LoadList";
    }
}
