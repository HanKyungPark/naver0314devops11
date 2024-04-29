<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 24. 4. 26.
  Time: 오전 11:07
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
<body>
<h5>include1 파일에서 include2 결과 포함시키기</h5>
<%
    request.setCharacterEncoding("utf-8");//한글 엔코딩
%>
<div>
    <jsp:include page="Ex4_include2.jsp">
        <jsp:param name="msg" value="Happy Day!!!안녕!!"/>
        <jsp:param name="car" value="mycar15.png"/>
    </jsp:include>
</div>
</body>
</html>
