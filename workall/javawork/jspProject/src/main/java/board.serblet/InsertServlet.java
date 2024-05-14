package board.serblet;

import data.dao.SimpleBoadDao;
import data.dto.SimpleBoardDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/board/insert")
public class InsertServlet extends HttpServlet {
    SimpleBoadDao dao = new SimpleBoadDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //doPost 로 부터 호출이 되었으므로 encoding 을 해줘야 한다
        request.setCharacterEncoding("UTF-8");
        //데이타 읽어서 dto 에 담기
        SimpleBoardDto dto = new SimpleBoardDto();
        dto.setWriter(request.getParameter("writer"));
        dto.setSubject(request.getParameter("subject"));
        dto.setAvata(request.getParameter("avata"));
        dto.setContent(request.getParameter("content"));


        //insert 메서드 호출
        dao.insertBoard(dto);

    //목록으로 리다이렉트
        response.sendRedirect("./list");//listServlet 으로 이동
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
