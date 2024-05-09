<%@ page import="data.dao.GuestDao" %>
<%@ page import="data.dto.GuestDto" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/9/24
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String Nickname = request.getParameter("nickname");
    String content = request.getParameter("content");
    int num = Integer.parseInt(request.getParameter("num"));

    GuestDto dto = new GuestDto();
    dto.setNickname(Nickname);
    dto.setContent(content);
    dto.setNum(num);

    GuestDao dao = new GuestDao();

    dao.updateGuest(dto);
%>

