<link rel="StyleSheet" href="css/bottom.css" type="text/css"
      media="screen" />

<div id="Footer">

    <div id="PoweredBy">&nbsp<a href="https://gitee.com/weiwei999/web-pet-store">gitee.com/weiwei999/web-pet-store</a>
    </div>

    <div id="Banner">
        <c:if test="${sessionScope.loginAccount != null }">

                <c:if test="${sessionScope.loginAccount.bannerOption}">
                    ${sessionScope.loginAccount.bannerName}
                </c:if>

        </c:if>

    </div>

</div>
</body>
</html>