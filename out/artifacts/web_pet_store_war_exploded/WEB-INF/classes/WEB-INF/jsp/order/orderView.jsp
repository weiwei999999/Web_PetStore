
<c:if test="${sessionScope.orderToView != null}">
    <table>
        <tr>
            <td colspan="5">
                <h3>Order  #${sessionScope.orderToView.orderId}  ${sessionScope.orderToView.orderDate}</h3>
            </td>
        </tr>
        <tr>
            <td colspan="5" style="background-color: #aaaaaa"><b>Payment Details</b></td>
        </tr>
        <tr>
            <td colspan="2">Card Type:</td>
            <td colspan="3">${sessionScope.orderToView.cardType}</td>
        </tr>
        <tr>
            <td colspan="2">Card Number:</td>
            <td colspan="3">${sessionScope.orderToView.creditCard}</td>
        </tr>
        <tr>
            <td colspan="2">Expiry Date (MM/YYYY):</td>
            <td colspan="3">${sessionScope.orderToView.expressDate}</td>
        </tr>
        <%@ include file="orderViewAddressFields.jsp"%>
        <tr>
            <td colspan="2">Courier:</td>
            <td colspan="3">${sessionScope.orderToView.courier}</td>
        </tr>
        <tr>
            <td colspan="5">Status: P</td>
        </tr>

        <tr>
            <td style="background-color: #aaaaaa"><b>Item ID</b></td>
            <td style="background-color: #aaaaaa"><b>Description</b></td>
            <td style="background-color: #aaaaaa"><b>Quantity</b></td>
            <td style="background-color: #aaaaaa"><b>Price</b></td>
            <td style="background-color: #aaaaaa"><b>Total Cost</b></td>
        </tr>

        <c:forEach var="item" items="${sessionScope.orderToView.cart.itemList}">
            <tr>
                <td>${item.itemId}</td>
                <td>${item.attribute1} ${item.attribute2} ${item.attribute3}
                        ${item.attribute4} ${item.attribute5} ${item.product.name}</td>
                <td>${sessionScope.orderToView.cart.getItemQuantity(item.itemId)}</td>
                <td>
                    <fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00" />
                </td>
                <td>
                    <fmt:formatNumber value="${(sessionScope.orderToView.cart.getItemQuantity(item.itemId)) * (item.listPrice)}" pattern="$#,##0.00" />
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="5" style="background-color: #aaaaaa"><b>Total: $${sessionScope.orderToView.cart.totalPrice}</b></td>
        </tr>

    </table>
</c:if>