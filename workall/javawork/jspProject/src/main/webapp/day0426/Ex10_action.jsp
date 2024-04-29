<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 24. 4. 26.
  Time: 오후 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
</head>
<%
    request.setCharacterEncoding("utf-8");
    String menuname = request.getParameter("menuname");
    String foodphoto = request.getParameter("foodphoto");
    String photo=foodphoto.split(",")[0];
    String price=foodphoto.split(",")[1];
    String grade = request.getParameter("grade");
    String member = request.getParameter("member");
%>
<body>
<div style="margin: 30px; font-size: 20px">

    메뉴이름 : <%=menuname%><br>
    가격 : <%=price%><br>
    사진<br>
    <img src="<%=photo%>" width="300" border="2">
    <br>
    만족도 : <%=grade%><br>
    우수회원 : <%=member==null?"일반회원":"우수회원"%>

    <br><br>
    <a href="javascript:history.back()">다시 선택 #1</a>
    <br><br>
    <a href="Ex10_formtag.jsp">다시 선택 #2</a>

</div>
</body>
</html>
