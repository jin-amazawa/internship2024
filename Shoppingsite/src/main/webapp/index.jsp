<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="servlet.model.Product" %>
<%@ page import="java.util.ArrayList" %>


<%
    List<Product> products = (List<Product>) application.getAttribute("products");

	if (products == null) {
	    products = new ArrayList<>();
	    // 必要に応じて、ダミーの商品の追加なども行う
	    application.setAttribute("products", products);
	}

    List<Product> cart = (List<Product>) session.getAttribute("cart");
    if(cart == null) {
        cart = new java.util.ArrayList<>();
    }
    String username = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ECサイト - 商品一覧</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/style.css?v=<%= System.currentTimeMillis() %>">
	
	

</head>
<body>
    <header>
        <h1>商品一覧</h1>
        <nav>
            <a href="cart">カート (<%= cart.size() %>)</a>
            
            <% if (username != null) { %>
	            <span>こんにちは、<%= username %> さん</span>
	            <a href="logout">ログアウト</a>
            <% } else { %>
                <a href="login">ログイン</a>
            <% } %>
        </nav>
    </header>
    <main>
	    <form action="search" method="GET" class="search_form">
		    <input type="text" name="query" placeholder="商品名で検索" class="search">
		    <button type="submit" class="search_submit">検索</button>
		</form>
        <ul class="product-list">
            <% for(Product product : products) { %>
            <li class="product-item">
                <img src="<%= product.getImage() %>" alt="<%= product.getName() %>">
                <h2><a href="product?id=<%= product.getId() %>"><%= product.getName() %></a></h2>
                <p>価格: ¥<%= product.getPrice() %></p>
                <p><%= product.getDescription() %></p>
                <a href="add-to-cart?id=<%= product.getId() %>" class="btn">カートに追加</a>
            </li>
            <% } %>
        </ul>
    </main>
    <footer>
        <p>&copy; ECサイト</p>
    </footer>
</body>
</html>
