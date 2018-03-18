<%@ page import="net.golovach.eshop.entity.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 14.03.2018
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body>
<b>PRODUCT ALL PAGE</b>
<br/>
<br/>
<%--<%List<Product> productAll = (List<Product>) request.getAttribute("productList");
if(productAll!=null && productAll.size()!=0){
    for (Product product : productAll){
        response.getWriter().write(product.getName());
        response.getWriter().write("\n");
    }
}%>--%>

<br/>MAIN PAGE
<br/><a href="/eshop/product.do?id=1">product#1</a>
<br/><a href="/eshop/product.do?id=2">product#2</a>
<br/><a href="/eshop/product.do?id=3">product#3</a>

<hr/><%--show products bucket--%>
<h2>Products in bucket:</h2>
<%--
<ul>
    &lt;%&ndash;"цикл для верстаков":
        items="${productsInBucket}" - по ком мы крутимся (можно и Map)
        var="productInBucket" - елемент
        &ndash;%&gt;
    <c:forEach var="productInBucket" items="${productsInBucket}">
        <li>
            <a href="./product.do?id=${productInBucket.key.id}">${productInBucket.key.name}</a>: = ${productInBucket.value}
            (<a href="./productRemoveFromBucket.do?id=${productInBucket.key.id}&redirectToId=${product.id}">X</a>)
        </li>
    </c:forEach>
</ul>

<br/><a href="index.jsp">main page</a>
--%>

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
<br/><a href="./productRemoveBucket.do">Очистить корзину</a>
<br/>
<br/><a href="index.jsp">Welcome Page</a>

</body>
</html>
