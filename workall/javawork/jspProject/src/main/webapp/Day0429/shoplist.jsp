<%@ page import="java.util.List" %>
<%@ page import="data.dto.ShopDto" %>
<%@ page import="data.dao.ShopDao" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 4/29/24
  Time: 11:07 AM
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

        .smallphoto{
            width: 50px;
            height: 50px;
            border: 1px solid gray;
            margin-right: 5px;
        }
    </style>


</head>
<%
    //dao 선언
    ShopDao dao = new ShopDao();
    //db에 등록된 상품들 가져오기
    List<ShopDto> list = dao.getShopDatas();
    //날짜형식
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
<div style="margin: 10px; width: 400px">
    <h5 class="alert alert-danger">
        <b>총 <%=list.size() %>개의 상품이 등록되어 있습니다.</b></h5>
    <button type="button" class="btn btn-outline-primary"
            style="margin-top: 10px;margin-left: 300px"
            onclick="location.href='./shopform.jsp'">상품 추가
    </button>
    <table class="table table-bordered">
        <tr class="table-danger">
            <th width="200px">상품명</th>
            <th width="100px">가격</th>
            <th>등록일</th>
        </tr>
        <%
            for (ShopDto dto : list) {%>
        <tr>
            <td>
                <a href="./shopdetail.jsp?shopidx=<%=dto.getShopidx()%>"
                   style="text-decoration: none; color: black">
                <img src="<%=dto.getSphoto()%>" class="smallphoto">
                <%=dto.getSname()%>
                </a>
            </td>
            <td align="right"><%=dto.getSprice()%>원</td>
            <td>
                <%=sdf.format(dto.getWriteday())%>
            </td>
        </tr>
        <%
            }
        %>

    </table>
</div>
</body>
</html>
