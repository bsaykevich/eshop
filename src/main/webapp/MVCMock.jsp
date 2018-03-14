<%@ page import="net.golovach.eshop.entity.MockEntityB" %>
<%@ page import="net.golovach.eshop.entity.MockEntityA" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.03.2018
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <b>MVC Mock View</b>
    <br/>reqAttrName.name = ${reqAttrName.name}
    <br/>reqAttrName.map["key-0"] = ${reqAttrName.map["key-0"]}
    <br/>reqAttrName.mockEntityB.beanName = ${reqAttrName.mockEntityB.beanName}
    <hr/>
    <br/>reqAttrName.mockEntityB.beanName = <%=((MockEntityA) request.getAttribute("reqAttrName")).getMockEntityB().getBeanName()%>
    <br/>sessionAttrName.mockEntityB.beanName =
        <%=((MockEntityA) request.getSession().getAttribute("sessionAttrName")).getMockEntityB().getBeanName()%>
    <hr/>
    <br/>sessionAttrName.name = ${sessionAttrName.name}
    <br/>contextAttrName.listOfElements[0] = ${contextAttrName.listOfElements[0]}
    <br/>
   <%-- <br/>sessionAttrName.invalidField = ${sessionAttrName.invalidField}--%>
    <br/>requestScope.reqAttrName.name = ${requestScope.reqAttrName.name}
    <br/>test = ${test}
    <br/>sessionScope.test = ${sessionScope.test}
    <hr/>
    <jsp:useBean id="pageBean" scope="page" class="net.golovach.eshop.entity.MockEntityB"/>
    <br/>pageBean.beanName = ${pageBean.beanName}
    <hr/>
    <br/>(pageBean.intValue0 gt -10) and (pageBean.intValue1 lt 10) =
        ${(pageBean.intValue0 gt -10) and (pageBean.intValue1 lt 10)}
    <hr/>
    <br/>test = ${test}

</body>
</html>
