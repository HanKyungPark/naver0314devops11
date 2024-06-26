<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/22/24
  Time: 10:02 AM
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
    <c:set var="stpath" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/photocommon"/>
    <script type="text/javascript">
        $(function () {
            //사진변경 이벤트
            $("#photoupload").change(function () {
                let form=new FormData();
                form.append("upload", $("#photoupload")[0].files[0]);
                form.append("num",${dto.num});

                $.ajax({
                    type:"post",
                    dataType:"json",
                    data:form,
                    url:"./upload",
                    processData:false,
                    contentType:false,
                    success: function (data) {
                        //스프링에서 {"photoname":파일명"} 이렇게 보낼것임
                        //프로필 사진 변경 (db변경 후 업로드된 사진파일명을 반환받은것으로 변경)
                        $("#photo").attr("src","${stpath}/"+data.photoname);
                    },
                })
            });
        });
    </script>
</head>


<body>
<table class="table" style="width: 500px;margin: 20px">
    <caption align="top">
        <h2><b>${dto.name}회원님의 정보확인</b></h2>
    </caption>
    <tr>
        <td width="200" align="center">
            <img src="${stpath}/${dto.photo}" id="photo"
                 class="rounded-circle" style="width: 150px;border: 1px solid black"
            onerror="this.src='../image/no1.png'">
            <br><br>
            <input type="file" id="photoupload" style="display: none">

            <button type="button" class="btn btn-success btn-sm"
                    onclick="$('#photoupload').trigger('click')">
                사진수정

            </button>
        </td>
        <td valign="middle">
            아이디 : ${dto.myid}<br>
            핸드폰 : ${dto.hp}<br>
            이메일 : ${dto.email}<br>
            주 소 : ${dto.addr}<br>
            생년월일 : ${dto.birthday}<br>
            가입일 :
            <fmt:formatDate value="${dto.gaipday}"
                            pattern="yyyy-MM-dd HH:mm"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <button type="button" class="btn btn-sm-outline-secondary"
                    style="width: 80px"
                    onclick="location.href='./list'">목록</button>

            <button type="button" class="btn btn-sm-outline-secondary"
                    style="width: 80px"
                    onclick="location.href='./updateform?num=${dto.num}'">수정</button>

            <button type="button" class="btn btn-sm-outline-secondary"
                    style="width: 80px"
                    onclick="del(${dto.num})">삭제</button>

            <script type="text/javascript">
                function del(num) {
                    // alert(num)
                    //비밀번호 입력받기
                    let passwd = prompt("비밀번호를 입력해주세요");
                    $.ajax({
                        type: "post",
                        dataType: "json",
                        url: "./delete",
                        data: {"num":num,"passwd":passwd},
                        success: function (data) {
                            if (data.status == 'success') {
                                alert("삭제되었습니다");
                                //목록으로 이동
                                location.href = "./list";
                            } else {
                                alert("비밀번호가 맞지 않습니다");
                            }
                        },
                    })
                }
            </script>
        </td>
    </tr>
</table>
</body>
</html>
