<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 24. 4. 26.
  Time: 오전 11:54
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
<h5>JSP 로 폼태그 읽기</h5>
<form action="./Ex6_action.jsp" method="get">
    <b>이름</b> :
    <input type="text" name="name" required="required">
    <br><br>
    <b>사진</b> :
    <select name="photo">
        <option value="../image/talent/17.jpg">신민아</option>
        <option value="../image/talent/15.jpg">설현</option>
        <option value="../image/talent/18.jpg">신세경</option>
        <option value="../image/talent/19.jpg">수지</option>
    </select>
    <br><br>
   <!--<button type="submit">서버전송</button> -->
    <input type="image" src="../image/mycar/mycar13.png" style="width: 70px">

</form>
</body>
</html>
