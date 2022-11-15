<%@ include file="../common/top.jsp"%>

<div id="BackLink"><
    <a href="mainForm">Return to Main Menu</a>
</div>

<div id="Catalog">
    <div id="Cart">
        <h2>Shopping Cart</h2>
        <form action="updateCart" method="POST">
            <table>
                <tr>
                    <th><b>Item ID</b></th>
                    <th><b>Product ID</b></th>
                    <th><b>Description</b></th>
                    <th><b>In Stock?</b></th>
                    <th><b>Quantity</b></th>
                    <th><b>List Price</b></th>
                    <th><b>Total Cost</b></th>
                    <th>&nbsp;</th>
                </tr>

                <c:forEach var="item" items="${sessionScope.cart.itemList}">
                    <tr>
                        <td>
                            <a href="#" >${item.itemId}</a>
                        </td>
                        <td>${item.product.productId}</td>
                        <td>${item.attribute1} ${item.attribute2} ${item.attribute3}
                                ${item.attribute4} ${item.attribute5} ${item.product.name}</td>
                        <td>${item.quantity>0?"true":"false"}</td>
                        <td>
                            <input type="text" name="${item.itemId}" value="${sessionScope.cart.getItemQuantity(item.itemId)}">
                        </td>
                        <td>
                            <fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00" />
                        </td>
                        <td>
                            <fmt:formatNumber value="${(sessionScope.cart.getItemQuantity(item.itemId)) * (item.listPrice)}" pattern="$#,##0.00" />
                        </td>
                        <td>
                            <a href="removeItemInCart?removeItemId=${item.itemId}" class="Button">Remove</a>
                        </td>
                    </tr>
                </c:forEach>

                <tr>
                    <td>
                        Sub Total: <fmt:formatNumber value="${sessionScope.cart.totalPrice}" pattern="$#,##0.00"/>
                        <input type="submit" value="updateCart">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/bottom.jsp"%>

