<%@ page import="data.dao.GuestDao" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/9/24
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num=Integer.parseInt(request.getParameter("num"));
    GuestDao dao = new GuestDao();
    dao.deleteGuest(num);
    
%>