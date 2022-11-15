<c:if test="${sessionScope.orderToConfirm != null || sessionScope.orderToConfirm.orderId>0}">
    <tr>
        <td colspan="2" style="background-color: #aaaaaa"><b>Billing Address</b></td>
    </tr>
    <tr>
        <td>First name:</td>
        <td>${sessionScope.orderToConfirm.billToFirstName}</td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td>${sessionScope.orderToConfirm.billToLastName}</td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td>${sessionScope.orderToConfirm.billAddress1}</td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td>${sessionScope.orderToConfirm.billAddress2}</td>
    </tr>
    <tr>
        <td>City:</td>
        <td>${sessionScope.orderToConfirm.billCity}</td>
    </tr>
    <tr>
        <td>State:</td>
        <td>${sessionScope.orderToConfirm.billState}</td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td>${sessionScope.orderToConfirm.billZip}</td>
    </tr>
    <tr>
        <td>Country:</td>
        <td>${sessionScope.orderToConfirm.billCountry}</td>
    </tr>

    <tr>
        <td colspan="2" style="background-color: #aaaaaa"><b>Shipping Address</b></td>
    </tr>
    <tr>
        <td>First name:</td>
        <td>${sessionScope.orderToConfirm.shipToFirstName}</td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td>${sessionScope.orderToConfirm.shipToLastName}</td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td>${sessionScope.orderToConfirm.shipAddress1}</td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td>${sessionScope.orderToConfirm.shipAddress2}</td>
    </tr>
    <tr>
        <td>City:</td>
        <td>${sessionScope.orderToConfirm.shipCity}</td>
    </tr>
    <tr>
        <td>State:</td>
        <td>${sessionScope.orderToConfirm.shipState}</td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td>${sessionScope.orderToConfirm.shipZip}</td>
    </tr>
    <tr>
        <td>Country:</td>
        <td>${sessionScope.orderToConfirm.shipCountry}</td>
    </tr>
</c:if>

<c:if test="${sessionScope.orderToConfirm == null || sessionScope.orderToConfirm.orderId<=0}">
    <tr>
        <td colspan="5" style="background-color: #aaaaaa"><b>Billing Address</b></td>
    </tr>
    <tr>
        <td colspan="2">First name:</td>
        <td colspan="3">${sessionScope.orderSubmitted.billToFirstName}</td>
    </tr>
    <tr>
        <td colspan="2">Last name:</td>
        <td colspan="3">${sessionScope.orderSubmitted.billToLastName}</td>
    </tr>
    <tr>
        <td colspan="2">Address 1:</td>
        <td colspan="3">${sessionScope.orderSubmitted.billAddress1}</td>
    </tr>
    <tr>
        <td colspan="2">Address 2:</td>
        <td colspan="3">${sessionScope.orderSubmitted.billAddress2}</td>
    </tr>
    <tr>
        <td colspan="2">City:</td>
        <td colspan="3">${sessionScope.orderSubmitted.billCity}</td>
    </tr>
    <tr>
        <td colspan="2">State:</td>
        <td colspan="3">${sessionScope.orderSubmitted.billState}</td>
    </tr>
    <tr>
        <td colspan="2">Zip:</td>
        <td colspan="3">${sessionScope.orderSubmitted.billZip}</td>
    </tr>
    <tr>
        <td colspan="2">Country:</td>
        <td colspan="3">${sessionScope.orderSubmitted.billCountry}</td>
    </tr>

    <tr>
        <td colspan="5" style="background-color: #aaaaaa"><b>Shipping Address</b></td>
    </tr>
    <tr>
        <td colspan="2">First name:</td>
        <td colspan="3">${sessionScope.orderSubmitted.shipToFirstName}</td>
    </tr>
    <tr>
        <td colspan="2">Last name:</td>
        <td colspan="3">${sessionScope.orderSubmitted.shipToLastName}</td>
    </tr>
    <tr>
        <td colspan="2">Address 1:</td>
        <td colspan="3">${sessionScope.orderSubmitted.shipAddress1}</td>
    </tr>
    <tr>
        <td colspan="2">Address 2:</td>
        <td colspan="3">${sessionScope.orderSubmitted.shipAddress2}</td>
    </tr>
    <tr>
        <td colspan="2">City:</td>
        <td colspan="3">${sessionScope.orderSubmitted.shipCity}</td>
    </tr>
    <tr>
        <td colspan="2">State:</td>
        <td colspan="3">${sessionScope.orderSubmitted.shipState}</td>
    </tr>
    <tr>
        <td colspan="2">Zip:</td>
        <td colspan="3">${sessionScope.orderSubmitted.shipZip}</td>
    </tr>
    <tr>
        <td colspan="2">Country:</td>
        <td colspan="3">${sessionScope.orderSubmitted.shipCountry}</td>
    </tr>
</c:if>
