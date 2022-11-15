<%@ include file="../common/top.jsp"%>

<div id="Catalog">

    <div style="width: 15%; float: left;">&nbsp;</div>

    <div id="allOrders" style="width: 20%; float: left;">
        <h3>My Orders</h3>
        <c:if test="${sessionScope.myOrders.size() <= 0}">
            <p>You don't have any order.</p>
        </c:if>
        <c:if test="${sessionScope.myOrders.size() > 0}">
            <table>
                <tr>
                    <td style="background-color: #aaaaaa">Order ID</td>
                    <td style="background-color: #aaaaaa">Date</td>
                    <td style="background-color: #aaaaaa">Total Price</td>
                </tr>
                <c:forEach var="order" items="${sessionScope.myOrders}">
                    <tr>
                        <td><a href="myOrderForm?orderIdToView=${order.orderId}">#${order.orderId}</a></td>
                        <td>${order.orderDate}</td>
                        <td>
                            <fmt:formatNumber value="${order.totalPrice}" pattern="$#,##0.00" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>

    <div id="orderView" style="width: 45%; float: left;">
        <h3>Order Details</h3>
        <%@ include file="orderView.jsp"%>
        <c:if test="${sessionScope.orderToView == null}">
            <p>Click the order ID to see the details.</p>
        </c:if>
    </div>

    <div style="width: 20%; float: left;">&nbsp;</div>

    <div id="Separator"> </div>
</div>

<%@ include file="../common/bottom.jsp"%>