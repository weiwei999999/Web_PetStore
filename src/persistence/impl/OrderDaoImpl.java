package src.persistence.impl;

import src.domain.Cart;
import src.domain.Order;
import src.persistence.DBUtil;
import src.persistence.ItemDao;
import src.persistence.OrderDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> getOrders(String userId) {
        List<Order> orderList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT * FROM orders WHERE userid = '" + userId + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderid"));
                order.setUserId(resultSet.getString("userid"));
                order.setOrderDate(resultSet.getDate("orderdate"));
                order.setShipAddress1(resultSet.getString("shipaddr1"));
                order.setShipAddress2(resultSet.getString("shipaddr2"));
                order.setShipCity(resultSet.getString("shipcity"));
                order.setShipState(resultSet.getString("shipstate"));
                order.setShipZip(resultSet.getString("shipzip"));
                order.setShipCountry(resultSet.getString("shipcountry"));
                order.setBillAddress1(resultSet.getString("billaddr1"));
                order.setBillAddress2(resultSet.getString("billaddr2"));
                order.setBillCity(resultSet.getString("billcity"));
                order.setBillState(resultSet.getString("billstate"));
                order.setBillZip(resultSet.getString("billzip"));
                order.setBillCountry(resultSet.getString("billcountry"));
                order.setCourier(resultSet.getString("courier"));
                order.setTotalPrice(resultSet.getBigDecimal("totalprice"));
                order.setShipToFirstName(resultSet.getString("shiptofirstname"));
                order.setShipToLastName(resultSet.getString("shiptolastname"));
                order.setBillToFirstName(resultSet.getString("billtofirstname"));
                order.setBillToLastName(resultSet.getString("billtolastname"));
                order.setCreditCard(resultSet.getString("creditcard"));
                order.setExpressDate(resultSet.getString("exprdate"));
                order.setCardType(resultSet.getString("cardtype"));
                order.setLocale(resultSet.getString("locale"));
                order.setCart(getOrderCart(order.getOrderId()));
                orderList.add(order);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return orderList;
    }

    @Override
    public void addOrder(Order order) {
        Connection connection = DBUtil.getConnection();
        String sql1 = "INSERT INTO orders values " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO lineitem values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setInt(1,order.getOrderId());
            preparedStatement1.setString(2,order.getUserId());
            preparedStatement1.setDate(3, (Date) order.getOrderDate());
            preparedStatement1.setString(4,order.getShipAddress1());
            preparedStatement1.setString(5,order.getShipAddress2());
            preparedStatement1.setString(6,order.getShipCity());
            preparedStatement1.setString(7,order.getShipState());
            preparedStatement1.setString(8,order.getShipZip());
            preparedStatement1.setString(9,order.getShipCountry());
            preparedStatement1.setString(10,order.getBillAddress1());
            preparedStatement1.setString(11,order.getBillAddress2());
            preparedStatement1.setString(12,order.getBillCity());
            preparedStatement1.setString(13,order.getBillState());
            preparedStatement1.setString(14,order.getBillZip());
            preparedStatement1.setString(15,order.getBillCountry());
            preparedStatement1.setString(16,order.getCourier());
            preparedStatement1.setBigDecimal(17,order.getTotalPrice());
            preparedStatement1.setString(18,order.getBillToFirstName());
            preparedStatement1.setString(19,order.getBillToLastName());
            preparedStatement1.setString(20,order.getShipToFirstName());
            preparedStatement1.setString(21,order.getShipToLastName());
            preparedStatement1.setString(22,order.getCreditCard());
            preparedStatement1.setString(23,order.getExpressDate());
            preparedStatement1.setString(24,order.getCardType());
            preparedStatement1.setString(25,order.getLocale());
            preparedStatement1.executeUpdate();
            DBUtil.closeStatement(preparedStatement1);

            Cart orderCart = order.getCart();
            for (int i = 0; i < orderCart.getItemList().size(); i++) {
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                preparedStatement2.setInt(1,order.getOrderId());
                preparedStatement2.setInt(2,i);
                preparedStatement2.setString(3,orderCart.getItemList().get(i).getItemId());
                preparedStatement2.setInt(4,orderCart.getQuantityList().get(i));
                preparedStatement2.setBigDecimal(5,orderCart.getItemList().get(i).getUnitCost());
                preparedStatement2.executeUpdate();
                DBUtil.closeStatement(preparedStatement2);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        DBUtil.closeConnection(connection);
    }

    @Override
    public Cart getOrderCart(int orderId) {
        Cart cart = new Cart();
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT itemid,quantity FROM lineitem WHERE orderid = '" + orderId + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ItemDao itemDao = new ItemDaoImpl();
            while (resultSet.next()) {
                cart.addItem(itemDao.getItem(resultSet.getString("itemid")));
                cart.addItemQuantity(resultSet.getInt("quantity"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cart;
    }

    @Override
    public int createValidOrderId() {
        int maxOrderId = -1;
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT orderid FROM orders";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                maxOrderId = resultSet.getInt("orderid");
            }
            if (maxOrderId != 0) {
                maxOrderId++;
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return maxOrderId;
    }

//    public static void main(String[] args) {
////        List<Order> orderList = getOrder("ACID");
////        for (int i = 0; i < orderList.size(); i++) {
////            System.out.println(orderList.get(i));
////        }
//
////        System.out.println(getOrderCart(order.getOrderId()));
////        order.setOrderId(9999999);
////        addOrder(order);
////        System.out.println(order);
////        System.out.println(order.getCart().toString());
//    }
}
