package src.service;

import src.domain.Account;
import src.domain.Cart;
import src.domain.Order;
import src.persistence.OrderDao;
import src.persistence.impl.OrderDaoImpl;

import java.util.List;


public class OrderService {
    Order order;
    OrderDao orderDAO;

    //根据用户信息自动创建1个默认订单
    public Order createDefaultOrder(Account account, Cart cart) {
        order = new Order();
        orderDAO = new OrderDaoImpl();
        order.setOrderId(orderDAO.createValidOrderId());
        order.setUserId(account.getUsername());
        java.util.Date date = new java.util.Date();
        java.sql.Date orderDate = new java.sql.Date(date.getTime());
        order.setOrderDate(orderDate);
        order.batchSetShipAddress(account.getAddress1(), account.getAddress2(), account.getCity(),
                account.getState(), account.getZip(), account.getCountry());
        order.batchSetBillAddress(account.getAddress1(), account.getAddress2(), account.getCity(),
                account.getState(), account.getZip(), account.getCountry());
        order.setCourier("UPS");
        order.batchSetOrderUsername(account.getFirstName(), account.getLastName());
        order.setCreditCard("999 9999 9999 9999");
        order.setExpressDate(createExpiryDate(orderDate));
        order.setCardType("Visa");
        order.setLocale("default");
        order.setCart(cart);
        return order;
    }

    //提交订单到数据库
    public void submitOrder(Order order) {
        orderDAO = new OrderDaoImpl();
        orderDAO.addOrder(order);
    }

    //(私有)根据订单创建时间计算其到期时间
    private static String createExpiryDate(java.sql.Date date) {
        String year_str = date.toString().substring(0,4);
        String month_str = date.toString().substring(5,7);
        int year_int = Integer.parseInt(year_str);
        int month_int = Integer.parseInt(month_str) + 1;
        if (month_int > 12) {
            year_int++;
            month_int = month_int - 12;
        }
        year_str = Integer.toString(year_int);
        month_str = Integer.toString(month_int);
        if (month_int < 10) {
            month_str = "0" + month_str;
        }
        return month_str + "/" +year_str  ;

    }

    //返回指定账户的所有订单
    public List<Order> getMyOrders(Account account) {
        orderDAO = new OrderDaoImpl();
        return orderDAO.getOrders(account.getUsername());
    }

    //返回指定账户的指定id的订单
    public Order getMyOrderByOrderId(Account account, int orderId) {
        orderDAO = new OrderDaoImpl();
        List<Order> myOrders = orderDAO.getOrders(account.getUsername());
        for (int i = 0; i < myOrders.size(); i++) {
            if (myOrders.get(i).getOrderId() == orderId) {
                return myOrders.get(i);
            }
        }
        return null;
    }

//    public static void main(String[] args) {
////        java.util.Date d = new java.util.Date();
////        java.sql.Date date = new java.sql.Date(d.getTime());
////        System.out.println(date);
////        AccountService accountService = new AccountService();
////        Account account =  accountService.getAccountbyUserID("ACID");
////        System.out.println(account.getCity());
////        System.out.println(createDefaultOrder(account,new Cart()));
//        java.util.Date date = new java.util.Date();
//        java.sql.Date orderDate = new java.sql.Date(date.getTime());
//        System.out.println(orderDate);
//        System.out.println(createExpiryDate(orderDate));
//    }

}