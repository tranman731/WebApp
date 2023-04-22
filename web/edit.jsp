<%-- 
    Document   : edit
    Created on : Apr 8, 2023, 10:41:05 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="man.dev.data.model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <% User user = (User) request.getAttribute("user"); %>
        <div class="container">
            <div class="row">
                <form action="EditServlet" method="post">
                    <input type="hidden" name="user_id" value="<%= user.getId() %>">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input name="email" value="<%= user.getEmail() %>" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input name="password" value="<%= user.getPassword() %>" type="text" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Role</label>
                        <input name="role" value="<%= user.getRole() %>" type="text" class="form-control" id="exampleInputPassword1" placeholder="Role">
                    </div>
                    <button type="submit"  name="update" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
