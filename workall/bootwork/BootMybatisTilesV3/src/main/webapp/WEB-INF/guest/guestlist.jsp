<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/23/24
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
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
<!--방명록 입력은 로그인을 해야만 한다-->
<c:if test="${sessionScope.loginok!=null}">
<div class="guestformarea" style="width: 400px">
        <textarea style="width: 100%;height: 120px"
        id="gcontent" class="form-control"></textarea>
    <br>
    <input type="file" id="photoupload" multiple="multiple">
    <button type="button" id="btnaddguest"
            class="btn btn-sm btn-info">등록</button>
</div>
<hr>
</c:if>
<div class="guestlistarea">
    방명록 목록이 나올 영역
</div>
</body>
</html>
