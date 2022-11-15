package src.persistence;

import src.domain.Cart;
import src.domain.Order;

import java.util.List;

public interface OrderDao {

    //返回指定用户的所有订单
    List<Order> getOrders(String userId);

    //将订单加入数据库(订单中已有用户名等信息)
    void addOrder(Order order);

    //(以购物车的形式)返回指定订单中的商品信息
    Cart getOrderCart(int orderId);

    //返回1个数据库中不存在的合法的订单id(创建新订单时调用)
    int createValidOrderId();

}
