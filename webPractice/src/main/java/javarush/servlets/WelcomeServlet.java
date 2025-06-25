package javarush.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(false);

    if (session != null) {
        Object username = session.getAttribute("username");
        if (username != null) {
            response.getWriter().println("Welcome " + username);
        }
    } else {
        response.getWriter().println("Session expired. Log in again");
    }
}

}
