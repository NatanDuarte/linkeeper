<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="linkeeper/" var="path" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Linkeeper: list your useful links</title>
        <link rel="stylesheet" href="./src/css/materialize.min.css">
        <link rel="stylesheet" href="./src/css/custom.css">
    </head>
    <body class="grey lighten-3">
        <nav>
            <div class="nav-wrapper grey darken-2">
                <a href="#" class="brand-logo center">LinKeeper</a>
            </div>
        </nav>
        
        
        <div class="section row grey lighten-2">
            <div class="col m8 s12">
                <div class="center row">
                    <h4>User: ${loggedUser.login}</h4>
                    <a class="wave btn wave-light" href="app?action=Logout">Logout</a>
                </div>
            </div>
            <div class="col m4 s12">
                <div class="row">
                    <a class="wave btn wave-light" href="app?action=AddNew">Add new</a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col m12 s12">
                <div class="center">
                    <div class="container">
                        <div class="row">
                            <c:forEach items="${links}" var="link">
                                <div class="col s12 m4">
                                    <div class="card">
                                        <div class="row">
                                            <div class="col">
                                                <a target="_blank" class="card-title col m12"
                                               href="${link.url}">${link.name}</a>
                                            </div>
                                        </div>
                                        <div class="card-action">
                                            <a href="app?action=Edit&id=${link.id}"
                                                class="btn-small waves-effect waves-teal">
                                                edit
                                            </a>
                                            <a href="app?action=Delete&id=${link.id}"
                                                class="btn-small waves-effect waves-teal">
                                                delete
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="./src/js/materialize.min.js"></script>
        <script src="./src/js/init.js"></script>
    </body>
</html>
