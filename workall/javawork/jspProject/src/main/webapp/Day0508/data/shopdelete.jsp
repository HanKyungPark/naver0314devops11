<%@ page import="data.dao.ShopDao" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/9/24
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //shopidx 읽기
    int shopidx = Integer.parseInt(request.getParameter("shopidx"));
    //Dao
    ShopDao dao = new ShopDao();
    //delete 메서드 호출
    dao.deleteShop(shopidx);
%>
