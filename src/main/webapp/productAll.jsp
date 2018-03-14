<%@ page import="net.golovach.eshop.entity.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 14.03.2018
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<b>PRODUCT ALL PAGE</b>
<br/>
<br/>
<%List<Product> productAll = (List<Product>) request.getAttribute("productAll");
if(productAll!=null && productAll.size()!=0){
    for (Product product : productAll){
        response.getWriter().write(product.getName());
        response.getWriter().write("\n");
    }
}%>

</body>
</html>
