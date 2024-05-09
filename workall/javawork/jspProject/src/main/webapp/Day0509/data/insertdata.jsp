<%@ page import="data.dto.GuestDto" %>
<%@ page import="data.dao.GuestDao" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/9/24
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    GuestDto dto = new GuestDto();
    dto.setNickname(request.getParameter("nickname"));
    dto.setAvata(request.getParameter("avata"));
    dto.setContent(request.getParameter("content"));

    GuestDao dao=new GuestDao();
    dao.insertGuest(dto);

%>