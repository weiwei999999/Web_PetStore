<p>
    Pet Favorites<br>
    Shop for more of you favorite pets here.
</p>

<ul>
    <c:forEach var="item" items="${sessionScope.myList}">
        <li><a href="ProductForm?productId=${item.productId}">${item.name} (${item.productId})</a></li>
    </c:forEach>
</ul>
