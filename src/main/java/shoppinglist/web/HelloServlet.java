package shoppinglist.web;

import org.springframework.beans.factory.annotation.Autowired;
import shoppinglist.domains.Product;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.get.GetAllProductsRequest;
import shoppinglist.services.products.get.GetAllProductsResponse;
import shoppinglist.services.products.get.GetAllProductsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

//        if (parameter3.equals("printproducts")) {
//            GetAllProductsService getAllProductsService = new GetAllProductsService();
//            GetAllProductsRequest getAllProductsRequest = new GetAllProductsRequest();
//            GetAllProductsResponse getAllProductsResponse = getAllProductsService.execute(getAllProductsRequest);
//
//            out.println("<h1>-------------------------</h1>");
//            out.println("This is Your shopping list:");
//            for (Product product : getAllProductsResponse.getProducts()) {
//                out.println(
//                        "<h1>" + "ID: " + product.getId() +
//                                "; Title: " + product.getTitle() +
//                                "; Description: " + product.getDescription() +
//                                "</h1>"
//                );
//            }
//            System.out.println("-------------------------");
//        }
    }

}