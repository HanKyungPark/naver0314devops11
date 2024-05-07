<%@ page import="data.dao.StudentDao" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/1/24
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num=Integer.parseInt(request.getParameter("num"));
    StudentDao StudentDao = new StudentDao();
    StudentDao.deleteStudent(num);
    response.sendRedirect("list.jsp");
%>