package board.serblet;

import data.dao.SimpleBoadDao;
import data.dto.SimpleBoardDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "board/detail", value = "/board/detail")
public class DetailServlet extends HttpServlet {
    SimpleBoadDao dao = new SimpleBoadDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //num,currentPage 를 읽는다
        int num=Integer.parseInt(request.getParameter("num"));
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));
        //조회수 증가
        dao.updateReadcount(num);
        //num 에 해당하는 dto얻기
        SimpleBoardDto dto = dao.getData(num);
        //request에 dto,currentPage 저장
        request.setAttribute("dto",dto);
        request.setAttribute("currentPage",currentPage);

        
        RequestDispatcher rd = request.getRequestDispatcher("/day0514/detail.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
