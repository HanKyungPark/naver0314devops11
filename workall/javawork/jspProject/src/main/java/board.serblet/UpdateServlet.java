package board.serblet;

import data.dao.SimpleBoadDao;
import data.dto.SimpleBoardDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "board/update", value = "/board/update")

public class UpdateServlet extends HttpServlet {
    SimpleBoadDao dao = new SimpleBoadDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //doPost 로 부터 호출이 되었으므로 encoding 을 해줘야 한다
        request.setCharacterEncoding("UTF-8");
        //데이타 읽어서 dto 에 담기
        SimpleBoardDto dto = new SimpleBoardDto();
        int num=Integer.parseInt(request.getParameter("num"));
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));

        dto.setNum(num);
        dto.setWriter(request.getParameter("writer"));
        dto.setSubject(request.getParameter("subject"));
        dto.setAvata(request.getParameter("avata"));
        dto.setContent(request.getParameter("content"));

        //수정메서드 호출
        dao.updateBoard(dto);

        response.sendRedirect("./detail?num="+num+"&currentPage="+currentPage);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
