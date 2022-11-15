package src.domain;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private int orderId;
    private String userId;
    private Date orderDate;
    private String shipAddress1;
    private String shipAddress2;
    private String shipCity;
    private String shipState;
    private String shipZip;
    private String shipCountry;

    private String billAddress1;
    private String billAddress2;
    private String billCity;
    private String billState;
    private String billZip;
    private String billCountry;

    private String courier;
    private BigDecimal totalPrice;
    private String billToFirstName;
    private String billToLastName;
    private String shipToFirstName;
    private String shipToLastName;

    private String creditCard;
    private String expressDate;
    private String cardType;
    private String locale;

    Cart cart;


    public Order() {

    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setShipAddress1(String shipAddress1) {
        this.shipAddress1 = shipAddress1;
    }

    public void setShipAddress2(String shipAddress2) {
        this.shipAddress2 = shipAddress2;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public void setBillAddress1(String billAddress1) {
        this.billAddress1 = billAddress1;
    }

    public void setBillAddress2(String billAddress2) {
        this.billAddress2 = billAddress2;
    }

    public void setBillCity(String billCity) {
        this.billCity = billCity;
    }

    public void setBillState(String billState) {
        this.billState = billState;
    }

    public void setBillZip(String billZip) {
        this.billZip = billZip;
    }

    public void setBillCountry(String billCountry) {
        this.billCountry = billCountry;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setBillToFirstName(String billToFirstName) {
        this.billToFirstName = billToFirstName;
    }

    public void setBillToLastName(String billToLastName) {
        this.billToLastName = billToLastName;
    }

    public void setShipToFirstName(String shipToFirstName) {
        this.shipToFirstName = shipToFirstName;
    }

    public void setShipToLastName(String shipToLastName) {
        this.shipToLastName = shipToLastName;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setExpressDate(String expressDate) {
        this.expressDate = expressDate;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setCart(Cart cart) {
        this.totalPrice = cart.getTotalPrice();
        this.cart = cart;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getShipAddress1() {
        return shipAddress1;
    }

    public String getShipAddress2() {
        return shipAddress2;
    }

    public String getShipCity() {
        return shipCity;
    }

    public String getShipState() {
        return shipState;
    }

    public String getShipZip() {
        return shipZip;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public String getBillAddress1() {
        return billAddress1;
    }

    public String getBillAddress2() {
        return billAddress2;
    }

    public String getBillCity() {
        return billCity;
    }

    public String getBillState() {
        return billState;
    }

    public String getBillZip() {
        return billZip;
    }

    public String getBillCountry() {
        return billCountry;
    }

    public String getCourier() {
        return courier;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public String getBillToFirstName() {
        return billToFirstName;
    }

    public String getBillToLastName() {
        return billToLastName;
    }

    public String getShipToFirstName() {
        return shipToFirstName;
    }

    public String getShipToLastName() {
        return shipToLastName;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getExpressDate() {
        return expressDate;
    }

    public String getCardType() {
        return cardType;
    }

    public String getLocale() {
        return locale;
    }

    public Cart getCart() {
        return cart;
    }

    public void batchSetShipAddress(String address1, String address2, String city, String state, String zip, String country) {
        this.setShipAddress1(address1);
        this.setShipAddress2(address2);
        this.setShipCity(city);
        this.setShipState(state);
        this.setShipZip(zip);
        this.setShipCountry(country);

    }

    public void batchSetBillAddress(String address1, String address2, String city, String state, String zip, String country) {
        this.setBillAddress1(address1);
        this.setBillAddress2(address2);
        this.setBillCity(city);
        this.setBillState(state);
        this.setBillZip(zip);
        this.setBillCountry(country);
    }

    public void batchSetOrderUsername(String firstName, String lastName) {
        this.setShipToFirstName(firstName);
        this.setShipToLastName(lastName);
        this.setBillToFirstName(firstName);
        this.setBillToLastName(lastName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId='" + userId + '\'' +
                ", orderDate=" + orderDate +
                ", shipAddress1='" + shipAddress1 + '\'' +
                ", shipAddress2='" + shipAddress2 + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipState='" + shipState + '\'' +
                ", shipZip='" + shipZip + '\'' +
                ", shipCountry='" + shipCountry + '\'' +
                ", billAddress1='" + billAddress1 + '\'' +
                ", billAddress2='" + billAddress2 + '\'' +
                ", billCity='" + billCity + '\'' +
                ", billState='" + billState + '\'' +
                ", billZip='" + billZip + '\'' +
                ", billCountry='" + billCountry + '\'' +
                ", courier='" + courier + '\'' +
                ", totalPrice=" + totalPrice +
                ", billToFirstName='" + billToFirstName + '\'' +
                ", billToLastName='" + billToLastName + '\'' +
                ", shipToFirstName='" + shipToFirstName + '\'' +
                ", shipToLastName='" + shipToLastName + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", expressDate='" + expressDate + '\'' +
                ", cardType='" + cardType + '\'' +
                ", locale='" + locale + '\'' +
                ", cart=" + cart +
                '}';
    }
}
