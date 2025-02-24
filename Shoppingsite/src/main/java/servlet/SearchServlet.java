package servlet;

import java.io.IOException;
import java.util.List;

import dao.ProductDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.model.Product;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        System.out.println("ロミオとジュリエット: " + request.getParameter("query"));

        List<Product> products = ProductDao.searchProducts(query);
        
        
        request.setAttribute("products", products);
        System.out.println(request.getAttribute("products"));
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchResults.jsp");
        dispatcher.forward(request, response);
    }
}


