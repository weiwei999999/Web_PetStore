
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>


    <title>宠物商店</title>
    <link rel="StyleSheet" href="css/top.css" type="text/css"
          media="screen" />
    <link rel="StyleSheet" href="css/MyPetStore.css" type="text/css"
          media="screen" />


</head>

<body>
<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="mainForm"><img src="images/logo-topbar.png"/></a>

    </div>
    </div>
    <div id="Menu">
        <div id="MenuContent">
            <a href="/cartForm"><img align="middle" name="img_cart" src="images/cart.gif" /> </a>
<%--            <img align="middle" name="img_cart" src="images/cart.gif" />--%>
            <c:if  test="${sessionScope.loginAccount==null}">
                <a href="/signonForm">sign in</a>
                <img align="middle" src="images/separator.gif" />
            </c:if>
            <c:if  test="${sessionScope.loginAccount!=null}">
                <a href="/signout">sign out</a>
                <img align="middle" src="images/separator.gif" />
                <a href="/EditForm">My Account</a>
                <img align="middle" src="images/separator.gif" />
            </c:if>
               <a href="help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="/searchForm" method="post">
                <input type="text" name="keyword" size="14">
                <input type="submit" name="searchProducts" value="Search">
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="categoryForm?categoryId=FISH"><img src="images/sm_fish.gif"/></a><!--鱼的网页-->
        <img src="images/separator.gif" />
        <a href="categoryForm?categoryId=DOGS"><img src="/images/sm_dogs.gif" alt=""/></a><!--狗的网页-->
        <img src="images/separator.gif" />
        <a href="categoryForm?categoryId=REPTILES"><img src="/images/sm_reptiles.gif"/> </a><!--爬行动物的网页-->
        <img src="images/separator.gif" />
        <a href="categoryForm?categoryId=CATS"><img src="/images/sm_cats.gif"/></a><!--猫的网页-->
        <img src="images/separator.gif" />
        <a href="categoryForm?categoryId=BIRDS"><img src="/images/sm_birds.gif" alt=""/></a><!--鸟的网页-->
    </div>


</div>

