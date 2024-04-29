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
<h5>폼태그 읽기-문제</h5>
<form action="./Ex10_action.jsp" method="post">
    <table class="table table-bordered" style="width: 400px;">
        <tr>
            <th class="table-info" width="100">메뉴명</th>
            <td>
                <input type="text" name="menuname" class="form-control"
                       required="required" autofocus="autofocus">
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">음식사진</th>
            <td class="input-group">
                <select class="form-slect" name="foodphoto" id="foodphoto">
                    <option value="../food/1.jpg,9000,샌드위치 1">샌드위치 1</option>
                    <option value="../food/8.jpg,11000,샌드위치 2">샌드위치 2</option>
                    <option value="../food/11.jpg,13000,망고빙수">망고빙수</option>
                    <option value="../food/10.jpg,8000,햄마요덮밥">햄마요덮밥</option>
                </select>
                <img src="../food/1.jpg" id="photo"
                     width="60" height="60" style="margin-left: 10px">

                <!--제이쿼리 이벤트는 요기에 -->
                <script>
                    $("#foodphoto").change(function () {
                        let v = $(this).val();
                        let photo=v.split(",")[0];
                        $("photo").attr("src",photo);
                    });
                </script>

            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">만족도</th>
            <td>
                <label>
                    <input type="radio" name="grade" value="매우만족"
                    checked="checked">
                    매우만족
                </label> <label>
                <input type="radio" name="grade" value="만족">
                만족
            </label>
                <label>
                    <input type="radio" name="grade" value="보통">
                    보통
                </label> <label>
                <input type="radio" name="grade" value="불만">
                불만
            </label>
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">우수회원</th>
            <td>
                <input type="checkbox" name="member">우수회원
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