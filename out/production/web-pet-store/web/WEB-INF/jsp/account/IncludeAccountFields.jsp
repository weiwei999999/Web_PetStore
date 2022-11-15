<h3>Account Information</h3>

<table>
  <tr>
    <td>First name:</td>
    <c:if test="${sessionScope.loginAccount.firstName !=null}">
      <td><input type="text" name="account.firstName" value="${sessionScope.loginAccount.firstName}"/></td>
    </c:if>
    <c:if test="${sessionScope.loginAccount.firstName ==null}">
      <td><input type="text" name="account.firstName" value="${requestScope.lastname}"/></td>
    </c:if>
  </tr>
  <tr>
    <td>Last name:</td>
    <c:if test="${sessionScope.loginAccount.lastName !=null}">
      <td><input type="text" name="account.lastName" value="${sessionScope.loginAccount.lastName}"/></td>
    </c:if>

    <c:if test="${sessionScope.loginAccount.lastName ==null}">
      <td><input type="text" name="account.lastName" value="${requestScope.lastname}"/></td>
    </c:if>
  </tr>
  <c:if test="${requestScope.emailMsg !=null}">
    <p><font color="red">${requestScope.emailMsg}</font></p>
  </c:if>
  <tr>
    <td>Email:</td>
    <c:if test="${sessionScope.loginAccount.email !=null}">
      <td><input type="text" name="account.email" value="${sessionScope.loginAccount.email }"/></td>
    </c:if>
    <c:if test="${sessionScope.loginAccount.email ==null}">
      <td><input type="text" name="account.email" value="${requestScope.email}"/></td>
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
      <td><input value="${requestScope.Authcode_2}" style="display: none"  name="Authcode_2"></td>
    </c:if>
  </tr>
  <tr>
    <td>Phone:</td>
    <c:if test="${sessionScope.loginAccount.phone!=null}">
    <td><input type="text" name="account.phone" value="${sessionScope.loginAccount.phone}"/></td>>
    </c:if>
    <c:if test="${sessionScope.loginAccount.phone==null}">
      <td><input type="text" name="account.phone" value=""/></td>>
    </c:if>
  </tr>
  <tr>
    <td>Address 1:</td>
    <c:if test="${sessionScope.loginAccount.address1!=null}">
    <td><input type="text" size="40" name="account.address1" value="${sessionScope.loginAccount.address1}" /></td>
    </c:if>
    <c:if test="${sessionScope.loginAccount.address1==null}">
      <td><input type="text" size="40" name="account.address1" value="" /></td>
    </c:if>
  </tr>
  <tr>
    <td>Address 2:</td>
    <c:if test="${sessionScope.loginAccount.address2!=null}">
    <td><input type="text" size="40" name="account.address2" value="${sessionScope.loginAccount.address2}"/></td>
    </c:if>
    <c:if test="${sessionScope.loginAccount.address2==null}">
      <td><input type="text" size="40" name="account.address2" value=""/></td>
    </c:if>
  </tr>
  <tr>
    <td>City:</td>
    <c:if test="${sessionScope.loginAccount.city!=null}">
    <td><input type="text" name="account.city" value="${sessionScope.loginAccount.city}"/></td>
    </c:if>
    <c:if test="${sessionScope.loginAccount.city==null}">
      <td><input type="text" name="account.city" value=""/></td>
    </c:if>
  </tr>
  <tr>
    <td>State:</td>
    <c:if test="${sessionScope.loginAccount.state!=null}">
    <td><input type="text" size="4" name="account.state" value="${sessionScope.loginAccount.state}"/></td>
    </c:if>
    <c:if test="${sessionScope.loginAccount.state==null}">
      <td><input type="text" size="4" name="account.state" value=""/></td>
    </c:if>
  </tr>
  <tr>
    <td>Zip:</td>
    <c:if test="${sessionScope.loginAccount.zip!=null}">
    <td><input type="text" size="10" name="account.zip" value="${sessionScope.loginAccount.zip}"/></td>
    </c:if>
    <c:if test="${sessionScope.loginAccount.zip==null}">
      <td><input type="text" size="10" name="account.zip" value=""/></td>
    </c:if>
  </tr>
  <tr>
    <td>Country:</td>
    <c:if test="${sessionScope.loginAccount.country!=null}">
    <td><input type="text" size="15" name="account.country" value="${sessionScope.loginAccount.country}"/></td>
    </c:if>
    <c:if test="${sessionScope.loginAccount.country==null}">
      <td><input type="text" size="15" name="account.country" value=""/></td>
    </c:if>
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