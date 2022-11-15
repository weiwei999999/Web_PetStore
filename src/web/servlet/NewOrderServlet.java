package src.web.servlet;

import src.domain.Account;
import src.domain.Cart;
import src.domain.Order;
import src.service.CartService;
import src.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewOrderServlet extends HttpServlet {
    private static final String NEW_ORDER_FORM= "/WEB-INF/jsp/order/newOrder.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Account loginAccount =(Account) session.getAttribute("loginAccount");
        if(loginAccount==null)
        {
            resp.sendRedirect("signonForm");
        }
        else{
            CartService cartService = new CartService();
            Cart orderCart = cartService.getCartByAccount(loginAccount);
            OrderService orderService = new OrderService();
            Order order = orderService.createDefaultOrder(loginAccount,orderCart);
            session.setAttribute("orderToConfirm",order);
            req.getRequestDispatcher(NEW_ORDER_FORM).forward(req,resp);
        }

    }
}
