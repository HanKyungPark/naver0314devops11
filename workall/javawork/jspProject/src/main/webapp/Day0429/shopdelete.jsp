<%@ page import="data.dao.ShopDao" %>
<%@ page import="data.dto.ShopDto" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 4/29/24
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //shopidx int 타입으로 읽기
    int shopidx = Integer.parseInt(request.getParameter("shopidx"));
    //dao 선언
    ShopDao ShopDao = new ShopDao();
    //delete메서드 호출
    ShopDao.deleteShop(shopidx);
    //목록 shoplist jsp 로 이동
    response.sendRedirect(("shoplist.jsp"));

%>