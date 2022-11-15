<%--
  Created by IntelliJ IDEA.
  User: GuoRonghuan
  Date: 2022/11/10
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/top.jsp"%>

<div id="BackLink">
    <a href="mainForm">Return to Main Menu</a>
</div>

<div id="Catalog">

    <table>
        <tr>
            <th>&nbsp;</th>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${sessionScope.productList}">
            <tr>
                <td>
                    <a href="viewProduct?productId=${product.productId}">${product.description}</a>
                </td>
                <td><b>
                    <a href="ProductForm?productId=${product.productId}">${product.productId}</a>
                </b></td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>

    </table>

</div>

<%@ include file="../common/bottom.jsp"%>