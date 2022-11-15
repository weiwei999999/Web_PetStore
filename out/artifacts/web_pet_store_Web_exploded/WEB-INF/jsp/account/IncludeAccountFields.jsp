<h3>Account Information</h3>

<table>
  <tr>
    <td>First name:</td>
    <c:if test="${requestScope.firstname !=null}">
      <td><input type="text" name="account.firstName" value="${requestScope.firstname}"/></td>
    </c:if>
    <c:if test="${requestScope.firstname ==null}">
      <td><input type="text" name="account.firstName" value=""/></td>
    </c:if>
  </tr>
  <tr>
    <td>Last name:</td>
    <c:if test="${requestScope.lastname !=null}">
      <td><input type="text" name="account.lastName" value="${requestScope.lastname}"/></td>
    </c:if>
    <c:if test="${requestScope.lastname ==null}">
      <td><input type="text" name="account.lastName" value=""/></td>
    </c:if>
  </tr>
  <c:if test="${requestScope.emailMsg !=null}">
    <p><font color="red">${requestScope.emailMsg}</font></p>
  </c:if>
  <tr>
    <td>Email:</td>
    <c:if test="${requestScope.email !=null}">
      <td><input type="text" name="account.email" value="${requestScope.email}"/></td>
    </c:if>
    <c:if test="${requestScope.email ==null}">
      <td><input type="text" name="account.email" value=""/></td>
    </c:if>
  </tr>
<tr>
  <td>
<c:if test="${sessionScope.Form==null}">
    <c:if test="${requestScope.Authcode_2 ==null}">
      <td><input type="submit"  formaction="send" formmethod="post"></td>
  </c:if>
  <c:if test="${requestScope.Authcode_2 !=null}">
    <td><input type="submit"  formaction="send" formmethod="post" style="display: none"></td>
  </c:if>
  </c:if>
</tr>
  <tr>
    <c:if test="${sessionScope.Form==null}">
      <td>auth code:</td>
      <td><input type="text" name="authcode" /></td>
      <td><input value="${requestScope.Authcode_2}" style="display: none"  name="Authcode_1"></td>
    </c:if>
  </tr>
  <tr>
    <td>Phone:</td>
    <td><input type="text" name="account.phone" /></td>
  </tr>
  <tr>
    <td>Address 1:</td>
    <td><input type="text" size="40" name="account.address1" /></td>
  </tr>
  <tr>
    <td>Address 2:</td>
    <td><input type="text" size="40" name="account.address2" /></td>
  </tr>
  <tr>
    <td>City:</td>
    <td><input type="text" name="account.city" /></td>
  </tr>
  <tr>
    <td>State:</td>
    <td><input type="text" size="4" name="account.state" /></td>
  </tr>
  <tr>
    <td>Zip:</td>
    <td><input type="text" size="10" name="account.zip" /></td>
  </tr>
  <tr>
    <td>Country:</td>
    <td><input type="text" size="15" name="account.country" /></td>
  </tr>
</table>

<h3>Profile Information</h3>

<table>

  <tr>
    <td>Favourite Category:</td>
    <td>
    <select name="account.favouriteCategoryId">
      <option value="BIRDS" >BIRDS</option>
      <option value="CATS" >CATS</option>
      <option value="DOGS" >DOGS</option>
      <option value="FISH" >FISH</option>
      <option value="REPTILES" >REPTILES</option>
    </select>


    </td>
  </tr>
  <tr>
    <td>Enable MyList</td>
    <td><input type="checkbox" name="account.listOption" /></td>
  </tr>
  <tr>
    <td>Enable MyBanner</td>
    <td><input type="checkbox" name="account.bannerOption" /></td>
  </tr>

</table>