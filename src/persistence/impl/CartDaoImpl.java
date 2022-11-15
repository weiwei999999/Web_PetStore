package src.persistence.impl;

import src.domain.Cart;
import src.persistence.*;

import java.sql.*;

public class CartDaoImpl implements CartDao {

//    public CartDaoImpl() {
//
//    }

    //返回数据库中对应用户的购物车对象实例
    public Cart getCart(String userId) {
        Cart cart = new Cart();
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT itemid , quantity FROM cart WHERE userid = '" + userId +"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ItemDao itemDao = new ItemDaoImpl();
            while (resultSet.next())
            {
                String itemId = resultSet.getString("itemid");
                cart.addItem(itemDao.getItem(itemId));
                cart.addItemQuantity(resultSet.getInt("quantity"));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return cart;
    }


    //返回 指定用户的购物车中 指定的宠物的 数量 (不存在时返回0)
    public int getItemQuantityInCart(String userId, String itemId) {
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT * FROM cart WHERE userid = '" + userId +"' AND itemid = '" + itemId + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int count = resultSet.getInt("quantity");
                DBUtil.closeResultSet(resultSet);
                DBUtil.closeStatement(statement);
                DBUtil.closeConnection(connection);
                return count;
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DBUtil.closeConnection(connection);
        return 0;
    }

    //更新 指定用户的 购物车中 指定宠物的 数量 (例: value=1 则为增加1个宠物数量; value=-2 则为减少2个宠物数量)
    public void updateItemQuantityInCart(String userId, String itemId, int value) {
        if (value == 0) {
            System.out.println("[CardDAO.updateItemQuantityInCart] 无意义操作: itemid = " + itemId + ",value = 0");
            return;
        }
        Connection connection = DBUtil.getConnection();
        int quantity = getItemQuantityInCart(userId,itemId);
        String sql = "";
        if (quantity == 0 && value > 0) {
            sql += "INSERT INTO cart VALUES ('" + userId + "','" + itemId +"'," + value + ")";
        }
        else if (value > 0) {
            quantity += value;
            sql += "UPDATE cart SET quantity = '" + quantity + "' WHERE userid = '" + userId + "' AND itemid = '" + itemId +"'";
        }
        else if (quantity > 0 && quantity + value <= 0) {
            sql += "DELETE FROM cart WHERE userid = '" + userId + "' AND itemid = '" + itemId + "'";
        }
        else if (quantity > 0){
            quantity += value;
            sql += "UPDATE cart SET quantity = '" + quantity + "' WHERE userid = '" + userId + "' AND itemid = '" + itemId + "'";
        }
        else {
            System.out.println("[CardDAO.updatePetCountInCart] 无效操作: 不能对不存在的对象(petId=" + itemId +")进行数量减少操作");
            return;
        }
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            DBUtil.closeStatement(statement);
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

}
