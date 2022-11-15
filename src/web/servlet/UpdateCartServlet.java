package src.web.servlet;

import src.domain.Account;
import src.domain.Cart;
import src.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateCartServlet extends HttpServlet {

    private static final String CART_FORM_SERVLET = "cartForm";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account)session.getAttribute("loginAccount");
        if (account != null) {
            Cart cart = (Cart)session.getAttribute("cart");
            if (cart != null) {
                for (int i = 0; i < cart.getItemList().size(); i++) {
                    String itemId = cart.getItemList().get(i).getItemId();
                    int quantity;
                    try {
                        quantity = Integer.parseInt(req.getParameter(itemId));
                    } catch (NumberFormatException ex) {
                        System.out.println("[UpdateCartServlet] 格式转换错误: 商品数量含有非法字符");
                        continue;
                    }
                    cart.setQuantity(itemId,quantity);
                }
                CartService cartService = new CartService();
                cartService.updateCart(account,cart);
            }
        }
        resp.sendRedirect(CART_FORM_SERVLET);
    }
}
