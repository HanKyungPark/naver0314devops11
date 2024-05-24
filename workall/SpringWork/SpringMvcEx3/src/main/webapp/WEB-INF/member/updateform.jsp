<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/21/24
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
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
<form action="./update" method="post">
    <input type="hidden" name="num" value="${dto.num}">
    <table class="table table-bordered" style="width: 400px">
        <caption align="top">
            <h3><b>회원 수정</b></h3>
        </caption>
        <tr>
            <th width="100" class="table-info">이름</th>
            <td colspan="2">
                <input type="text" name="name" class="form-control"
                required="required" value="${dto.name}">
            </td>
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">핸드폰</th>
            <td width="200" colspan="2">
                <input type="number" name="hp" class="form-control"
                       required="required" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
                placeholder="xxx-xxx-xxxx" value="${dto.hp}">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">이메일</th>
            <td width="200" colspan="2">
                <input type="email" name="email" class="form-control"
                       required="required" value="${dto.email}">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">주소</th>
            <td width="200" colspan="2">
                <input type="text" name="addr" class="form-control"
                       required="required" value="${dto.addr}">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">생년월일</th>
            <td width="200" colspan="2">
                <input type="date" name="birthday" class="form-control"
                       value="${dto.birthday}">
            </td>
        </tr>
        <tr>
            <td colspan="3" align="center">
                <button type="submit" class="btn btn-outline-danger"
                style="width: 100px">정보수정</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
