<%@ page import="data.dao.GuestDao" %>
<%@ page import="data.dto.GuestDto" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/9/24
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
     int num=Integer.parseInt(request.getParameter("num"));
    GuestDao dao=new GuestDao();
    GuestDto dto = dao.getData(num);

    JSONObject ob=new JSONObject();
    ob.put("num",dto.getNum());
    ob.put("nickname",dto.getNickname());
    ob.put("content",dto.getContent());
%>
<%=ob.toString()%>

