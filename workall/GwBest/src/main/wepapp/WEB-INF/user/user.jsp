<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
    </style>
</head>
<body>
<form action="user.jsp">
    <table>
        <tr>
            <th>
                <i class="bi bi-person-square"></i>
            </th>
            <td>
                <input type="text" placeholder="아이디" name="id">
            </td>
        </tr>
        <tr>
            <th>
                <i class="bi bi-key-fill"></i>
            </th>
            <td>
                <input type="password" name="passwd"  placeholder="비밀번호">
            </td>
        </tr>
        <tr>
            <th>
                <i class="bi bi-person"></i>
            </th>
            <td>
                <input type="text" name="name" placeholder="이름">
            </td>
        </tr>
        <tr>
            <th>
                <i class="bi bi-gender-ambiguous"></i>
            </th>
            <td>
                <input type="radio" name="gender" value="male">남자
                <input type="radio" name="gender" value="female">여자
            </td>
        </tr>
        <tr>
            <th>
                <i class="bi bi-house-door"></i>
            </th>
            <td>
                <input type="text" name="addr" placeholder="주소">
            </td>
        </tr>
        <tr>
            <th>
                <i class="bi bi-person-badge"></i>
            </th>
            <td>
                <input type="text" name="hp" placeholder="휴대폰 번호">
            </td>
        </tr>
        <tr>
            <th>
                <i class="bi bi-cake2"></i>
            </th>
            <td>
                <input type="date" name="birthday" placeholder="생일" value="2024-01-01">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">회원가입</button>
                <button type="button" onclick="history.back()">이전</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
