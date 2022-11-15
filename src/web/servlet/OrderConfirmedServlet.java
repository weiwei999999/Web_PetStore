package src.web.servlet;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
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

public class OrderConfirmedServlet extends HttpServlet {
    public static Logger log = Logger.getLogger(OrderConfirmedServlet.class);

    static final String ORDER_SUBMITTED_FORM = "/WEB-INF/jsp/order/orderSubmitted.jsp";
    private static final String NEW_ORDER_FORM_SERVLET= "newOrderForm";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account loginAccount =(Account) session.getAttribute("loginAccount");
        if(loginAccount==null) {
            resp.sendRedirect("signonForm");
        }
        else {
            Order order = (Order)session.getAttribute("orderToConfirm");
            if (order == null) {
                resp.sendRedirect(NEW_ORDER_FORM_SERVLET);
            } else {
                session.setAttribute("orderToConfirm",null);
                session.setAttribute("orderSubmitted",order);
                OrderService orderService = new OrderService();
                orderService.submitOrder(order);
                req.getRequestDispatcher(ORDER_SUBMITTED_FORM).forward(req,resp);
                String username=(String) session.getAttribute("username");
                if(username==null)
                {username="未登录用户";}
                NDC.push(username);
                String oo="用户确认定单";
                log.error(oo);
                NDC.remove();
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
