<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 19.01.2018
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="net.golovach.eshop.entity.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%--<head>
    <title>productJsp</title>
</head>--%>
<body>
    <b>PRODUCT PAGE</b>
   <%-- <br/>id: <%=((Product) request.getAttribute("product")).getId()%>
    <br/>name: <%=((Product) request.getAttribute("product")).getName()%>--%>
    <br/>id: ${product.id}
    <br/>name: ${product.name}
    <br/><%--add product to bucket??--%>
    <a href="./productAddToBucket.do?id=${product.id}">Add this product to bucket</a>

    <hr/><%--show products bucket--%>
    <h2>Products in bucket:</h2>
    <ul>
        <%--"цикл для верстаков":
            items="${productsInBucket}" - по ком мы крутимся (можно и Map)
            var="productInBucket" - елемент

            &redirectToId=${product.id} - возвращаемся на страницу товара, на которой были, а не который мы удаляли
            --%>
            <%--TODO: fix redirectToId in removeFromBucket--%>

        <c:forEach var="productInBucket" items="${productsInBucket}">
            <li>
                <a href="./product.do?id=${productInBucket.key.id}">${productInBucket.key.name}</a>: = ${productInBucket.value}
                (<a href="./productRemoveFromBucket.do?id=${productInBucket.key.id}&redirectToId=${product.id}">X</a>)
            </li>
        </c:forEach>
    </ul>
    <br/>
    <br/><a href="./productRemoveBucket.do">Очистить корзину</a>
    <br/>
    <br/><a href="/productAll.do">Product List</a>
</body>
</html>
