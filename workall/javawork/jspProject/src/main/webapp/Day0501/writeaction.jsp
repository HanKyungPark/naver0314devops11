<%@ page import="data.dto.StudentDto" %>
<%@ page import="data.dao.StudentDao" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 5/1/24
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //한글 엔코딩
    request.setCharacterEncoding("utf-8");
    //데이타 읽기(license 경우는 체크하면 y,안할경우 n을 저장)
    String name = request.getParameter("name");
    String blood = request.getParameter("blood");
    char license =request.getParameter("license")==null?'n':'y';
   int java=Integer.parseInt(request.getParameter("java"));
   int spring=Integer.parseInt(request.getParameter("spring"));
   int html=Integer.parseInt(request.getParameter("html"));
    //dto 선언 후 데이타 넣기
    StudentDto dto = new StudentDto();
    dto.setName(name);
    dto.setBlood(blood);
    dto.setLicense(license);
    dto.setJava(java);
    dto.setHtml(html);
    dto.setSpring(spring);
    //dao 선언후 메서드 호출
    StudentDao dao = new StudentDao();
    dao.insertStudent(dto);
    //목록으로 이동
    response.sendRedirect(("list.jsp"));
%>
