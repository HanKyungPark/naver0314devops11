<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/21/24
  Time: 11:09 AM
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
<h2 class="alert alert-danger" style="width: 500px">
    총 ${totalCount}명의 회원이 있습니다.
    <span style="float: right">
        <button type="button" class="btn btn-sm btn-success"
                onclick="location.href='./form'">멤버등록</button>
    </span>
</h2>


<table class="table table-bordered" style="width: 400px">
    <tr>
        <th width="100" class="table-info">번호</th>
        <th width="100" class="table-info">회원명</th>
        <th width="100" class="table-info">아이디</th>
        <th width="100" class="table-info">핸드폰</th>
        <th width="100" class="table-info">상세보기</th>
    </tr>
    <c:forEach var="s" items="${list}" varStatus="i">
        <tr>
            <th>${i.count}</th>
            <th><img src="/resources/${s.photo}" width="50px" height="50px"
            style="border-radius: 50%"> ${s.name}</th>

            <th>${s.myid}</th>
            <th>${s.hp}</th>
            <td>
                <button type="button" class="btn btn-sm btn-info"
                onclick="location.href='./detail?num=${s.num}'">Detail</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>