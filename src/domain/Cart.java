package src.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Cart {
    List<Item> itemList = new ArrayList<>();
    List<Integer> quantityList = new ArrayList<>();

    public Cart() {

    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void addItemQuantity(int quantity) {
        this.quantityList.add(quantity);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public List<Integer> getQuantityList() {
        return quantityList;
    }

    public int getItemQuantity(String itemId) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId().equals(itemId)) {
                return quantityList.get(i);
            }
        }
        return 0;
    }

    public void setQuantity(String itemId, int value) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId().equals(itemId)) {
                quantityList.set(i,Integer.valueOf(value));
                return;
            }
        }
        System.out.println("[Cart.setQuantity] 错误: 无法找到目标(itemId=" + itemId + ")");
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (int i = 0; i < itemList.size(); i++) {
            BigDecimal itemsPrice = itemList.get(i).getListPrice().multiply(new BigDecimal(quantityList.get(i)));
            totalPrice = totalPrice.add(itemsPrice);
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        String details = "Cart{Item[";
        for (int i = 0; i < itemList.size(); i++) {
            details += itemList.get(i);
            if (i != itemList.size() - 1) {
                details += ", ";
            }
        }
        details += "], Quantity[";
        for (int i = 0; i < quantityList.size(); i++) {
            details += quantityList.get(i);
            if (i != quantityList.size() - 1) {
                details += ", ";
            }
        }
        details += "]}";
        return details;
    }

}
