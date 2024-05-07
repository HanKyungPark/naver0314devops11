<%@ page import="data.dao.SawonDao" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 4/30/24
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //num읽기
    int num=Integer.parseInt(request.getParameter("num"));
    //dao선언
    SawonDao SawonDao = new SawonDao();
    //delete메서드 호출
    SawonDao.deleteSawon(num);
    //목록 sawonlist jsp로 이동
    response.sendRedirect("sawonlist.jsp");
%>