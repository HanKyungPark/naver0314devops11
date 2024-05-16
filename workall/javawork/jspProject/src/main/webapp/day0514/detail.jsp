<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/14/24
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>

</head>
<body>
<table class="table table-bordered" style="width: 400px">
    <caption align="top">
        <b>조회수 ${dto.readcount}</b>
        <b style="margin-left: 10px; color: gray">추천
        &nbsp;<span class="chu">${dto.chu}</span> </b>
        &nbsp;
        <i class="bi bi-hand-thumbs-up mychu"
           style="font-size: 20px;cursor: pointer"></i>
    </caption>
    <tr>
        <th class="table-success" width="100">작성자</th>
        <td>
            <input type="text" class="form-control"
                   name="writer" readonly="readonly" value="${dto.writer} ">

        </td>
    </tr>
    <tr>
        <th class="table-success" width="100">작성일</th>
        <td>
            <input type="text" class="form-control"
                   name="writer" readonly="readonly" value="${dto.writeday} ">

        </td>
    </tr>
    <tr>
        <th class="table-success" width="100">아바타</th>
        <td>
            <!-- 확인후 hidden 으로 수정 할것임-->
            <img src="../image/snoopyAvata/s${dto.avata}.JPG">

        </td>
    </tr>
    <tr>
        <th class="table-success" width="100">제목</th>
        <td>
            <input type="text" class="form-control"
                   name="subject" required="required" value="${dto.subject}">
        </td>
    </tr>
    <tr>
        <th class="table-success" width="100">내용</th>
        <td>
          <textarea style="width: 100%;height: 120px;"
                    name="content" readonly="readonly">${dto.content}</textarea>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <button type="submit" class="btn btn-sm btn-success"
            onclick="location.href='./form'">글쓰기</button>
            <button type="button" class="btn btn-sm btn-success"
                    onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
            <button type="button" class="btn btn-sm btn-success"
                    onclick="del()">삭제</button>
            <button type="submit" class="btn btn-sm btn-success" onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
        </td>
    </tr>
</table>
<script type="text/javascript">

    function del()
    {
        let num=${dto.num};
        let cp=${currentPage};
        console.log(num,cp);

        let a=confirm("해당 게시글을 삭제하시겠습니까?");
        if(a){
            location.href=`./delete?num=\${num}&currentPage=\${cp}`;
        }
    }

    //추천 클릭시 숫자 증가
    $(".mychu").click(function () {
        let num=${dto.num};
        $.ajax({
            type:"get",
            dataType:"json",
            data:{"num":num},
            url:"./updatechu",
            success: function (data) {
                $("span.chu").text(data.chu);
            },
        })
    });
</script>
</body>

</html>
