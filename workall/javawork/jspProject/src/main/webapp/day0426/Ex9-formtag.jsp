<%--
  Created by IntelliJ IDEA.
  User: qhal5
  Date: 2024-04-26
  Time: 오후 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h5>폼태그 읽기</h5>
<form action="./Ex9_action.jsp" method="post">
    <table class="table table-bordered" style="width: 400px;">
        <tr>
            <th class="table-info" width="100">몸무게</th>
            <td>
                <input type="number" name="weight" class="form-control"
                       min="40" max="100" step="5" value="50">
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">생년월일</th>
            <td>
                <input type="date" name="birth" class="form-control"
                       value="2020-12-12">
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">좋아하는색</th>
            <td>
                <input type="color" name="color" value="#ccffff">
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">숨겨진값</th>
            <td>
               <input type="hidden" name="message" value="안녕하세요">
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">하고싶은말</th>
            <td>
                <textarea style="width: 100%;height: 100px;"
                          name="content" required></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit" class="btn btn-outline-success">서버 전송</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>