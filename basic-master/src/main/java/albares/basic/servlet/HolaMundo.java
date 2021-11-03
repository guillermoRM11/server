
package albares.basic.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hola")
public class HolaMundo extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           String edad = request.getParameter("edad");
           }
    }

 


       /* response.setContentType("text/html;charset=UTF-8");
        //try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*response.getOutputStream().println("<!DOCTYPE html>");
            response.getOutputStream().println("<html>");
            response.getOutputStream().println("<head>");
            response.getOutputStream().println("<title>Servlet HolaMundio</title>");            
            response.getOutputStream().println("</head>");
            response.getOutputStream().println("<body>");
            response.getOutputStream().println("<h1>Servlet HolaMundio at " + request.getContextPath() + "</h1>");
            response.getOutputStream().println("</body>");
            response.getOutputStream().println("</html>");*/