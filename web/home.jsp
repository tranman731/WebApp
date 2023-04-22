<%-- 
    Document   : home
    Created on : Apr 8, 2023, 10:28:02 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="man.dev.data.model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <% List<User> userList = (List<User>) request.getAttribute("userList"); %>
        <div class="container">
            <div clas="row">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Password</th>
                            <th scope="col">Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% int index = 0; %>
                        <% for(User user : userList) { %>
                        <tr>
                            <th scope="row"><%= ++index %></th>
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getPassword() %></td>
                            <td><%= user.getRole() %></td>
                            <td>
                                <form action="EditServlet" method="GET">
                                    <input type="hidden" id="id" name="user_id" value="<%= user.getId() %>">
                                    <input type="submit" value="Edit" />
                                </form>
                            </td>
                            <td>
                                <form action="DeleteServlet" method="POST">
                                    <input type="hidden" id="id" name="user_id" value="<%= user.getId() %>">
                                    <input type="submit" value="Delete" />
                                </form>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
