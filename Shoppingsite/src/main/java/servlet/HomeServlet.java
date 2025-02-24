package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.model.Product;

@WebServlet(name="HomeServlet", urlPatterns={"/"})
public class HomeServlet extends HttpServlet {
    private List<Product> products;

    @Override
    public void init() throws ServletException {
        products = new ArrayList<>();
        String contextPath = "/ShoppingSite";
        products.add(new Product(1, "CRISIS", 1000, "これは商品Aの説明です。", contextPath + "/static/images/crisis.jpg"));
        products.add(new Product(2, "北平无战事", 2000, "これは商品Bの説明です。", contextPath + "/static/images/hokuhei1.jpg"));
        products.add(new Product(3, "ロミオとジュリエット", 3000, "これは商品Cの説明です。", contextPath + "/static/images/romiotojyurietto.jpg"));
        products.add(new Product(4, "のだめカンタービレ最終楽章", 2500, "これは商品Dの説明です。", contextPath + "/static/images/nodame.jpg"));
        products.add(new Product(5, "コンフィデンスマンJP", 3000, "これは商品Eの説明です。", contextPath + "/static/images/confidenceman.jpg"));
        products.add(new Product(6, "湯を沸かすほどの熱い愛", 3000, "これは商品の説明です。", contextPath + "/static/images/yuwowakasu.jpg"));
        products.add(new Product(7, "るろうに剣心 最終章 The Final/The Begnning", 3000, "これは商品の説明です。", contextPath + "/static/images/rurounikennshinn.jpg"));
        products.add(new Product(8, "レ・ミゼラブル(2012)", 3000, "これは商品の説明です。", contextPath + "/static/images/remizeraburu.jpg"));
        products.add(new Product(9, "HAMLET", 3000, "これは商品の説明です。", contextPath + "/static/images/hamulet.jpg"));
        // サーブレットコンテキストに商品リストを格納
        getServletContext().setAttribute("products", products);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
