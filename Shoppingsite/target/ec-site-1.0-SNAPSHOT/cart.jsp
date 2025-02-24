<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="servlet.model.Product" %>
<%
    List<Product> cart = (List<Product>) session.getAttribute("cart");
    if(cart == null) {
        cart = new java.util.ArrayList<>();
    }
    int total = 0;
    for(Product p : cart) {
        total += p.getPrice();
    }
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>カート内容</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/css/style.css">
</head>
<body>
    <header>
        <h1>カート内容</h1>
        <nav>
            <a href="<%= request.getContextPath() %>/">商品一覧へ</a>
        </nav>
    </header>
    <main>
        <% if(cart.isEmpty()) { %>
            <p>カートは空です。</p>
        <% } else { %>
            <ul class="cart-list">
                <% for(Product item : cart) { %>
                    <li>
                        <img src="<%= item.getImage() %>" alt="<%= item.getName() %>" width="50">
                        <span><%= item.getName() %> - ¥<%= item.getPrice() %></span>
                    </li>
                <% } %>
            </ul>
            <p>合計金額: ¥<%= total %></p>
        <% } %>
    </main>
    <footer>
        <p>&copy; ECサイト</p>
    </footer>
</body>
</html>
