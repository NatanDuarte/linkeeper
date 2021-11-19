<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="app" var="entryServlet" />
<!DOCTYPE html>
<html>
    <head>
        <title>LinKeeper: Log in to continue</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./src/css/materialize.min.css">
        <link rel="stylesheet" href="./src/css/custom.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col m12">
                    <form action="${entryServlet}" method="POST">
                        <label for="login">login</label>
                        <input type="text" name="login" value="${user.login}" required/>

                        <label for="password">password</label>
                        <input type="password" name="password" value="${user.password}" required/>

                        <input type="hidden" name="action" value="Login"/>

                        <input class="wave btn" type="submit" value="login">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
