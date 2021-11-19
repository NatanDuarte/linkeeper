<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="linkeeper" var="path" />
<!DOCTYPE html>
<html>
    <head>
        <title>LinKeeper: Edit mode</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./src/css/materialize.min.css">
        <link rel="stylesheet" href="./src/css/custom.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col m12">
                    <form action="app" method="POST">
                        <label for="name">name:</label>
                        <input type="text" name="name" value="${link.name}" required/>
                        <label for="url">URL:</label>
                        <input type="text" name="url" value="${link.url}" required/>
                        <input type="hidden" name="id" value="${link.id}"/>
                        <input type="hidden" name="action" value="Update"/>

                        <input class="wave btn" type="submit" value="update">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
