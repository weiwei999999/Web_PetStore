package src.web.servlet;

import src.domain.Account;
import src.domain.Product;
import src.service.CartService;
import src.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CartFormServlet extends HttpServlet {

    static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";
    private static final String SIGN_ON_FORM= "/WEB-INF/jsp/account/signonForm.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account loginAccount = (Account)session.getAttribute("loginAccount");
        if (loginAccount != null) {
            CartService cartService = new CartService();
            session.setAttribute("cart" , cartService.getCartByAccount(loginAccount));
            CatalogService catalogService = new CatalogService();
            List<Product> myList = catalogService.getProductListByCategory(loginAccount.getFavouriteCategoryId());
            session.setAttribute("myList" , myList);
            req.getRequestDispatcher(CART_FORM).forward(req,resp);
        }
        else {
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
