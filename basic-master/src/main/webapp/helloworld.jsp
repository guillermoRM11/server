

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World!</title>
        <style>
            * {background-color: #55b58a;}
            p {color: white;}
        </style>
    </head>
    <body>
        <h1><% out.print("<a href='http://www.google.es'>Accede a Google</a>"); %></h1>
        <p><% out.print("Esta es el primer formulario hecho con JSP."); %></p><br>
        <form action="/basic/addUser" method="POST">
            <label for='name'><% out.print("Nombre"); %></label><br>
            <input type="text" id="name" name="name"><br>
            <label for='pass'><% out.print("Contraseña"); %></label><br>
            <input type="password" id="pass" name="pass"><br>
            <label for='age'><% out.print("Edad"); %></label><br>
            <input type="text" id="age" name="age"><br>
            <input type="submit" value="Enviar"><br>
        </form>
    </body>
</html>
<!--Hello World! by JSP-->