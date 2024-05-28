<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/28/24
  Time: 9:45 AM
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
<c:if test="${sessionScope.loginok==null}">
    <script type="text/javascript">
        alert("먼저 로그인후 글을 작성해주세요");
        history.back();
    </script>
</c:if>
<script>
    let jungbok=false;

    $(function () {
        $("#upload").change(function () {
            console.log($(this)) // 배열타입으로 넘어오는 것을 확인할 수 있다.
            let reg = /(.*?)\/(jpg|jpeg|png|gif)$/
            let f = $(this)[0].files[0]
            if (!f.type.match(reg)) {
                alert("이미지 파일만 가능합니다.")
                return
            }
            if (f) {
                let reader = new FileReader()
                reader.onload = function (e) {
                    $("#showImg1").attr("src", e.target.result)
                }
                reader.readAsDataURL($(this)[0].files[0])
            }
        })
    })
</script>

<body>
<form action="./update" method="post" enctype="multipart/form-data">
    <!-- 2개 hidden -->
    <input type="hidden" name="num" value="${dto.num}">
    <input type="hidden" name="currentPage" value="${currentPage}">

    <table  class="table table-bordered" style="width: 400px;">
        <caption align="top">
            <h4><b>글수정</b></h4>
        </caption>
        <tr>
            <th width="100" class="table-warning">제목</th>
            <td>
                <input type="text" name="subject" required="required"
                       value="${dto.subject}" class="form-control">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-warning">사진</th>
            <td>
                <img src="../save/${dto.uploadphoto}" id="showimg"
                     onerror="this.src='../image/no1.png'">
                <b>사진을 선택하지 않으면 기존사진이 유지됩니다</b><br>
                <input type="file" name="upload" id="upload" class="form-control">
            </td>
        </tr>
        <tr>
            <td colspan="2">
				<textarea name="content" required="required"
                          style="width: 100%;height: 150px;"
                          placeholder="내용을 입력하세요">${dto.content}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit" class="btn btn-secondary"
                        style="width: 100px;">글수정</button>

                <button type="button" class="btn btn-secondary"
                        style="width: 100px;"
                        onclick="history.back()">이전으로</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
