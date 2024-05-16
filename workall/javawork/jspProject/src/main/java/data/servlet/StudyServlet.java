package data.servlet;


import data.dao.ShopDao;
import data.dto.ShopDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/study3")
public class StudyServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> list1 = Arrays.asList("orange", "green", "pink", "gray", "magenta", "tomato");
        ShopDao dao = new ShopDao();
        List<ShopDto> shoplist = dao.getShopDatas();

        request.setAttribute("list1", list1);
        request.setAttribute("shoplist", shoplist);

        RequestDispatcher rd=request.getRequestDispatcher("./Day0513/test3.jsp");
        rd.forward(request, response);
        //경로 때문에 .. 을 . 으로 변경해서 보내보자
        for (ShopDto dto : shoplist) {
            dto.setSphoto(dto.getSphoto().replace("..", "."));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}