package src.web.servlet;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import src.domain.Account;
import src.domain.Cart;
import src.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddToCartServlet extends HttpServlet {
    public static Logger log = Logger.getLogger(SearchServlet.class);

    static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";
    private static final String CART_FORM_SERVLET = "cartForm";
    private static final String SIGN_ON_FORM= "/WEB-INF/jsp/account/signonForm.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account)session.getAttribute("loginAccount");
        String itemId = req.getParameter("itemIdToAdd");
        if (account != null) {
            if (itemId != null && (!itemId.equals(""))) {
                CartService cartService = new CartService();
                cartService.addOneItemToCart(account, itemId);
//                req.getRequestDispatcher(CART_FORM).forward(req, resp);
            }
            resp.sendRedirect(CART_FORM_SERVLET);
            String username=(String) session.getAttribute("username");
            if(username==null)
            {username="未登录用户";}
            NDC.push(username);
            String mm="添加"+itemId+"到购物车";
            log.error(mm);
            NDC.remove();

        } else {
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
