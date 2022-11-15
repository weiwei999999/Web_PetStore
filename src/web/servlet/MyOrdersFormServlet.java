package src.web.servlet;

import src.domain.Account;
import src.domain.Order;
import src.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MyOrdersFormServlet extends HttpServlet {

    private static final String SIGN_ON_FORM = "/WEB-INF/jsp/account/signonForm.jsp";
    private static final String MY_ORDERS_FORM = "/WEB-INF/jsp/order/myOrders.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account)session.getAttribute("loginAccount");
        if (account == null) {
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
        }
        else {
            OrderService orderService = new OrderService();
            List<Order> myOrders = orderService.getMyOrders(account);
            session.setAttribute("myOrders",myOrders);
            Order orderToView = null;
            if (req.getParameter("orderIdToView") != null && !req.getParameter("orderIdToView").equals("")) {
                int viewOrderId = -1;
                try {
                    viewOrderId = Integer.parseInt(req.getParameter("orderIdToView"));
                } catch (Exception ex) {
                    viewOrderId = -1;
                }
                if (viewOrderId > 0) {
                    orderToView = orderService.getMyOrderByOrderId(account,viewOrderId);
                }
            }
            session.setAttribute("orderToView",orderToView);
            req.getRequestDispatcher(MY_ORDERS_FORM).forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
