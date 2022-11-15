<%@ include file="../common/top.jsp"%>

<script>


</script>
<div id="Catalog"><form action="register" method="post">
    <c:if test="${requestScope.registerMsg !=null}">
        <p><font color="red">${requestScope.registerMsg}</font></p>
    </c:if>
    <h3>User Information</h3>


    <table>
        <tr>
            <td>User ID:</td>
            <c:if test="${requestScope.username_e !=null}">
            <td><input type="text" name="username" value="${requestScope.username_e}"/></td>
            </c:if>
            <c:if test="${requestScope.username_e ==null}">
                <td><input type="text" name="username" value=""/></td>
            </c:if>
        </tr>
        <tr>
            <td>New password:</td>
            <c:if test="${requestScope.password !=null}">
            <td><input type="text" name="password" value="${requestScope.password}"/></td>
            </c:if>
            <c:if test="${requestScope.password ==null}">
                <td><input type="text" name="password" value=""/></td>
            </c:if></td>
        </tr>
        <tr>
            <td>Repeat password:</td>
            <c:if test="${requestScope.re_password !=null}">
                <td><input type="text" name="repeatedPassword" value="${requestScope.re_password}"/></td>
            </c:if>
            <c:if test="${requestScope.re_password ==null}">
                <td><input type="text" name="repeatedPassword" value=""/></td>
            </c:if></td>
        </tr>
    </table>

    <%@ include file="IncludeAccountFields.jsp"%>

    <input type="submit"   name="newAccount" value="Save Account Information" />



<%@ include file="../common/bottom.jsp"%>