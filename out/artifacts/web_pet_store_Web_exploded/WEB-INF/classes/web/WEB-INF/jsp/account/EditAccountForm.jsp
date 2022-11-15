<%@ include file="../common/top.jsp"%>

<div id="Catalog"><form action="Edit" method="post">

    <c:if test="${requestScope.editMsg !=null}">
        <p><font color="red">${requestScope.editMsg}</font></p>
    </c:if>
    <h3>User Information</h3>
    <table>
        <tr>
            <td>User ID:</td>
            <td>${sessionScope.username}</td>
            <td><input value="${sessionScope.username}" name="username" style="display: none"></td>
        </tr>
        <tr>
            <td>New password:</td>
            <td><input type="text" name="password" /></td>
        </tr>
        <tr>
            <td>Repeat password:</td>
            <td><input type="text" name="repeatedPassword" /></td>
        </tr>
    </table>
    <%@ include file="IncludeAccountFields.jsp"%>

    <input type="submit"   name="newAccount" value="Edit Account Information" />

</form>
    <stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean"
        event="listOrders">My Orders</stripes:link>

</div>

<%@ include file="../common/bottom.jsp"%>