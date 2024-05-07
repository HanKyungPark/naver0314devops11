<%@ page import="data.dao.StudentDao" %>
<%@ page import="data.dto.StudentDto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.NumberFormat" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/1/24
  Time: 12:44 PM
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

</head>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    StudentDao dao = new StudentDao();
    StudentDto dto = dao.getData(num);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    int sum=dto.getJava()+dto.getSpring()+dto.getHtml();
    double avg=sum/3.0;
    NumberFormat nf=NumberFormat.getNumberInstance();
    nf.setMaximumFractionDigits(2);
%>
<body>
<div style="margin: 10px;width: 500px">
<table>
    <caption align="top">
        <h2><b><%=dto.getName()%></b></h2>
    </caption>
    <tr>
        <td>
            <h5>등록일 :  <%=sdf.format(dto.getWriteday())%></h5>
            <h5>혈액형 :  <%=dto.getBlood()%>형</h5>
            <h5>운전면허 :  <%=dto.getLicense()=='y'?"있음":"없음"%></h5>
            <h5>java점수 :  <%=dto.getJava()%></h5>
            <h5>spring점수 :  <%=dto.getSpring()%></h5>
            <h5>html점수 :  <%=dto.getHtml()%></h5>
            <h5>총점 :  <%=sum%>점</h5>
            <h5>평균 :  <%=nf.format(avg)%>점</h5>
            <hr>
            <button type="button" class="btn btn-outline-secondary"
                    onclick="location.href='writeform.jsp'"
                    style="width: 100px">학생정보추가</button>

            <button type="button" class="btn btn-outline-secondary"
                    onclick="location.href='writeform.jsp'"
                    style="width: 100px">학생목록</button>
                <br>
            <button type="button" class="btn btn-outline-secondary"
                    onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'"
                    style="width: 100px">학생정보수정</button>

            <button type="button" class="btn btn-outline-secondary"  num="<%=dto.getNum()%>" id="delstudent"
                    style="width: 100px">학생삭제</button>
        </td>
    </tr>
</table>
</div>
<script type="text/javascript">
    $("#delstudent").click(function () {
        let num = $(this).attr("num");
        let a=confirm(`\<%=dto.getName()%> 학생정보를 삭제할까요?`)
        if (a) {
            location.href="delete.jsp?num="+num;
        }
    });
</script>

</body>
</html>
