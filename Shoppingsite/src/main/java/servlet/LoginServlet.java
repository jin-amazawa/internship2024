package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    // サンプル用のハードコードされたユーザー情報
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ログインフォーム (login.jsp) を表示
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // フォームから送信されたユーザー名とパスワードを取得
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 簡易認証：ハードコードされた情報と照合
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // 認証成功：セッションにユーザー名を保存し、ホームへリダイレクト
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            // 認証失敗：エラーメッセージを設定して再度ログインフォームを表示
            request.setAttribute("errorMessage", "ユーザー名またはパスワードが正しくありません。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
