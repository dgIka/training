package javarush.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String a = request.getParameter("a");
        String b = request.getParameter("b");


            int sum = Integer.parseInt(a) + Integer.parseInt(b);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head> <title>Calculator</title> </head>");
            out.println("<body>");
            out.println("<h1> Sum == " + sum + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
