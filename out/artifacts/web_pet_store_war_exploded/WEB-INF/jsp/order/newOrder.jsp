<%@ include file="../common/top.jsp"%>

<div id="BackLink"><
    <a href="mainForm">Return to Main Menu</a>
</div>

<div id="Catalog">
    <h3 style="color: white">Please confirm the information below to continue...</h3>
    <table>
        <tr>
            <td colspan="2"><h3>Order</h3>
                #${sessionScope.orderToConfirm.orderId}  <br>
                ${sessionScope.orderToConfirm.orderDate}
            </td>
        </tr>
        <tr>
            <%@ include file="addressFields.jsp"%>
    </table>



    <a href="orderConfirmed" class="Button">Confirm</a>
</div>

<%@ include file="../common/bottom.jsp"%>