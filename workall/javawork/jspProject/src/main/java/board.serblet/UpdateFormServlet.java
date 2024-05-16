package board.serblet;

import data.dao.SimpleBoadDao;
import data.dto.SimpleBoardDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "board/updateform", value = "/board/updateform")
public class UpdateFormServlet extends HttpServlet {
    SimpleBoadDao dao = new SimpleBoadDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //num,currentPage 를 읽는다
        int num=Integer.parseInt(request.getParameter("num"));
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));
        //dto 가져오기
        SimpleBoardDto dto = dao.getData(num);

        //request 에 저장
        request.setAttribute("dto",dto);
        request.setAttribute("currentPage",currentPage); //최종수정후 상세페이지로 이동시 필요함


        RequestDispatcher rd = request.getRequestDispatcher("../day0514/updateform.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
