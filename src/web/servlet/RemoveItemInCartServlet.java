package src.web.servlet;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import src.domain.Account;
import src.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveItemInCartServlet extends HttpServlet {
    public static Logger log = Logger.getLogger(RemoveItemInCartServlet.class);

    private static final String CART_FORM_SERVLET = "cartForm";
    private static final String SIGN_ON_FORM= "/WEB-INF/jsp/account/signonForm.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account)session.getAttribute("loginAccount");
        if (account != null) {
            String itemId = req.getParameter("removeItemId");
            CartService cartService = new CartService();
            cartService.removeItemsInCart(account,itemId);
            resp.sendRedirect(CART_FORM_SERVLET);
            String username=(String) session.getAttribute("username");
            if(username==null)
            {username="未登录用户";}
            NDC.push(username);
            String oo="用户将"+ itemId+"移出购物车";
            log.error(oo);
            NDC.remove();
        } else {
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
