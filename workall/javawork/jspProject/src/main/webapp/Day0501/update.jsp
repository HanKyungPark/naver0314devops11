<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/1/24
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dto" class="data.dto.StudentDto"/>
<jsp:useBean id="dao" class="data.dao.StudentDao"/>
<jsp:setProperty name="dto" property="*"/>
<%
    System.out.println(dto.getNum());
    dao.updateStudent(dto);
response.sendRedirect("detail.jsp?num="+dto.getNum());
%>