

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
        <p><% out.print("Esta es el primer formulario hecho con JSP.") %></p><br>
        <form></form>
    </body>
</html>
<!--Hello World! by JSP-->