<%@ page import="data.dto.ShopDto" %>
<%@ page import="data.dao.ShopDao" %><%--
  Created by IntelliJ IDEA.
  User: hankyung
  Date: 4/29/24
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1.엔코딩
    request.setCharacterEncoding("utf-8");
    //2.5개의 상품데이타 읽기
    String sname = request.getParameter("sname");
    String scolor = request.getParameter("scolor");
    String sphoto = request.getParameter("sphoto");
    int sprice = Integer.parseInt(request.getParameter("sprice"));
    int scount = Integer.parseInt(request.getParameter("scount"));
    //3.dto에 넣기 -setter 로 넣기 (총6개)

    //4.dao 선언
    ShopDao dao = new ShopDao();

    //6.update 메서드 호출


    //6. shoplist.jsp 로 이동
    response.sendRedirect(("shoplist.jsp"));//url 주소 바뀜

%>
