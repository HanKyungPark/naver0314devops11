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
<h3 class="alert alert-danger">Get방식으로 데이타 읽기-각각</h3>
<form action="./read1" method="get">
    <div class="input-group" style="width: 300px">
        <h4>이름</h4>
        <input type="text" name="name" class="form-control">
    </div>
    <div class="input-group" style="width: 300px">
        <h4>주소</h4>
        <input type="text" name="addr" class="form-control">
    </div>
    <div class="input-group" style="width: 300px">
        <h4>나이</h4>
        <input type="text" name="age" class="form-control">
    </div>
    <button type="submit" class="btn btn-success">서버 전송</button>

</form>
</body>
</html>