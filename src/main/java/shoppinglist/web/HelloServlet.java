package shoppinglist.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //http://localhost:8080/java2/hello?p1=test1&p2=test2&p3=printproducts
        String parameter1 = req.getParameter("p1");
        String parameter2 = req.getParameter("p2");
        String parameter3 = req.getParameter("p3");
        // Set response content type
        resp.setContentType("text/html");
        // Prepare output html
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "Hello world from Java!" + "</h1>");
        out.println("<h1>" + "PARAMETER " + parameter1 + "</h1>");
        out.println("<h1>" + "PARAMETER " + parameter2 + "</h1>");

    }

}