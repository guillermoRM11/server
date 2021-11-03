
package albares.basic.servlet;

import albares.basic.api.User;
import albares.utils.JWTUtils;
import albares.utils.Parameters;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addUser")
public class UserServilet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String name = request.getParameter("username");
           String pass = request.getParameter("password");
           int age = Integer.parseInt(request.getParameter("age"));
           
           User newUser = new User(name, pass, age);
           Parameters.users.put(Parameters.id.incrementAndGet(), newUser);
           PrintWriter out = response.getWriter();
           out.println(JWTUtils.generateToken(Parameters.id.get()));
    }

 

}
//"HolaMundio", urlPatterns = {"/HolaMundo"}