<%@ page import="data.dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="data.dto.StudentDto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="data.dto.ShopDto" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/1/24
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%
        StudentDao dao = new StudentDao();
        List<StudentDto> list = dao.getAllStundent();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %>
</head>
<body>
<div style="width: 400px; margin: 30px">
<table class="table table-bordered">
    <tr class="table-danger">
        <th width="100">이름</th>
        <th width="100">등록일</th>
        <th width="100">상세보기</th>
    </tr>
    <%
        for (StudentDto dto : list) {%>
    <tr>
        <td>
            <%=dto.getName()%>
        </td>
        <td>
            <%=sdf.format(dto.getWriteday())%>
        </td>
        <td>
            <button type="button" class="btn btn-outline-primary"
                    style="margin-top: 10px"
            onclick="location.href='detail.jsp?num=<%=dto.getNum()%>'">상세보기</button>
        </td>
    </tr>
    <%
        }
    %>


</table>
</div>
</body>
</html>
