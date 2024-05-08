<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="data.dto.SawonDto" %>
<%@ page import="java.util.List" %>
<%@ page import="data.dao.SawonDao" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: jeenukjung
  Date: 2024. 5. 8.
  Time: 오후 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<%
    SawonDao dao = new SawonDao();
    // 전체 사원 데이터 가져오기
    List<SawonDto> list = dao.getAllSawons();
%>
<sawonList>
    <%
        for (SawonDto dto : list) {%>
    <sawon num='<%=dto.getNum()%>'>
        <name><%=dto.getName()%></name>
        <buseo><%=dto.getBuseo()%></buseo>
        <age><%=dto.getAge()%></age>
        <addr><%=dto.getAddr()%></addr>
        <birthday><%=dto.getBirthday()%></birthday>
        <photo><%=dto.getPhoto()%></photo>
        <gender><%=dto.getGender()%></gender>
    </sawon>
    <%
        }
    %>
</sawonList>