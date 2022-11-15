package src.service;

import src.domain.Account;
import src.domain.Cart;
import src.persistence.CartDao;
import src.persistence.impl.CartDaoImpl;

public class CartService {
    private CartDao cartDao;

    public CartService() {
        this.cartDao = new CartDaoImpl();
    }

    public Cart getCartByAccount(Account account) {
        return cartDao.getCart(account.getUsername());
    }

    //向购物车中的添加1个指定item
    public void addOneItemToCart(Account account, String itemId) {
        cartDao.updateItemQuantityInCart(account.getUsername(), itemId,1);
    }

    //移除购物车中所有指定item
    public void removeItemsInCart(Account account, String itemId) {
        String username = account.getUsername();
        int quantity = cartDao.getItemQuantityInCart(username, itemId);
        cartDao.updateItemQuantityInCart(username,itemId,-quantity);
    }

    //将数据库中 指定用户的购物车信息 设置成 与传入的购物车对象相同
    public void updateCart(Account account, Cart cart) {
        for (int i = 0; i < cart.getItemList().size(); i++) {
            String username = account.getUsername();
            String itemId = cart.getItemList().get(i).getItemId();
            int quantity = cart.getQuantityList().get(i).intValue() - cartDao.getItemQuantityInCart(username, itemId);
            if (quantity != 0) {
                cartDao.updateItemQuantityInCart(username, itemId, quantity);
            }
        }
    }

}
