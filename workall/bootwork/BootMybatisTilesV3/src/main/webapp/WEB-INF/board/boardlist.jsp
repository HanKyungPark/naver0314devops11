<%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/23/24
  Time: 4:43 PM
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
<!-- 글쓰기 버튼은 로그인을 해야만 보인다-->
<c:if test="${sessionScope.loginok!=null}">
    <button type="button" class="btn btn-outline-success"
            style="width: 100px; margin-left: 100px"
            onclick="location.href='./form'">글쓰기
    </button>
</c:if>
<h5>총 ${totalCount}개의 글이 있습니다</h5>
<table class="table table-striped" style="width: 600px">
    <tr class="table-danger">
        <th width="50">번호</th>
        <th width="270">제목</th>
        <th width="100">작성자</th>
        <th width="120">작성일</th>
        <th>조회</th>
    </tr>
    <!--글이 없는 경우-->
    <c:if test="${totalCount==0}">
        <tr height="60">
            <td colspan="5" align="center" valign="middle">
                <b style="font-size: 22px">
                    등록된 글이 없습니다
                </b>
            </td>
        </tr>
    </c:if>
    <c:forEach var="dto" items="${list}">
        <tr>
            <td>
                    ${no}
                <c:set var="no" value="${no-1}"/>
            </td>
            <td><!--제목-->
                <a href="./detail?num=${dto.num}&currentPage=${currentPage}">
                    <!--relevel 한개당 두칸띄우기-->
                    <c:forEach begin="1" end="${dto.relevel}">
                        &nbsp;&nbsp;
                    </c:forEach>
                    <!--답글일경우 답글 이미지-->
                    <c:if test="${dto.restep>0}">
                        <img src="../image/re.png">
                    </c:if>
                    <!--제목-->
                        ${dto.subject}
                    <!--사진이 있을경우 아이콘 표시 -->
                    <c:if test="${dto.uploadphoto!='no'}">
                        <i class="bi bi-image"
                           style="color: gray"></i>
                    </c:if>

                    <!--댓글이 있는경우만 갯수 출력-->
                    <c:if test="${dto.recount>0}">
                        <span style="color:red">(${dto.recount})</span>
                    </c:if>
                </a>
            </td>
            <td>
                ${dto.myid}
            </td>
            <td>
                ${dto.writeday}
            </td>
            <td>
                ${dto.readcount}
            </td>
        </tr>

    </c:forEach>
</table>
<c:if test="${startPage>1}">
    <a href="./list?currentPage=${startPage-1}"
       style="text-decoration: none;color: black">이전</a>
</c:if>
<c:forEach var="pp" begin="${startPage}" end="${endPage}">
    <a href="./list?currentPage=${pp}"
       style="text-decoration: none;color: ${currentPage==pp?'red':'black'}">
            ${pp}</a>&nbsp;
</c:forEach>
<!--다음:endPage가 totalPage 보다 작다면 다음이 필요하다
그런데 다음을 누를경우 다음블럭의 첫페이지가 현재페이지가 되어야만 한다-->
<c:if test="${endPage<totalPage}">
    <a href="./list?currentPage=${endPage+1}"
       style="text-decoration: none;color: black">다음</a>
</c:if>

</body>
</html>
