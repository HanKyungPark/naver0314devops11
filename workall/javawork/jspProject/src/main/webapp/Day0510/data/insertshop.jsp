<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/10/24
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="data.dao.ShopDao"/>
<jsp:useBean id="dto" class="data.dto.ShopDto"/>
<jsp:setProperty name="dto" property="*"></jsp:setProperty> <!--이름이 같은 데이타를 dto에 넣는다 -->
<%
    dao.insertShop(dto);
%>