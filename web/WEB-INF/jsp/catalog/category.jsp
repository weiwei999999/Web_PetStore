<%@ include file="../common/top.jsp"%>
<link rel="StyleSheet" href="css/catagory.css" type="text/css"
      media="screen" />

<div id="BackLink">
  <a href="mainForm">Click to back to the Main</a>
</div>

<div id="Catalog">

  <h2>${sessionScope.category.name}</h2>

  <table>
    <tr>
      <th> </th>
      <th>Product ID</th>
      <th>Name</th>
    </tr>
    <c:forEach var="product" items="${sessionScope.productList}">
      <tr>
        <td>
          <a href="ProductForm?productId=${product.productId}">${product.description}</a>
        </td>
        <td>
        <a href="ProductForm?productId=${product.productId}">${product.productId}</a>
        </td>
        <td>${product.name}</td>
      </tr>
    </c:forEach>
  </table>

</div>

<%@ include file="../common/bottom.jsp"%>
