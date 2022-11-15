package src.persistence;

import src.domain.Cart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface CartDao {

    //返回数据库中对应用户的购物车对象
    public Cart getCart(String userId);

    ////返回 指定用户的购物车中 指定的宠物的 数量 (不存在时返回0)
    public int getItemQuantityInCart(String userId, String itemId);

    //更新 指定用户的 购物车中 指定宠物的 数量 (例: value=1 则为增加1个宠物数量; value=-2 则为减少2个宠物数量)
    public void updateItemQuantityInCart(String userId, String itemId, int value);

}
