<%@ page import="data.dao.SawonDao" %>
<%@ page import="data.dto.SawonDto" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 4/30/24
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="data.dto.SawonDto"/>
<jsp:useBean id="dao" class="data.dao.SawonDao"/>
<jsp:setProperty name="dto" property="*"/>
<%
    System.out.println(dto.getNum());
    dao.updateSawon(dto);
    response.sendRedirect("sawonlist.jsp");
%>
