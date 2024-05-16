package board.serblet;

import data.dao.SimpleBoadDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "board/delete", value = "/board/delete")
public class DeleteServlet extends HttpServlet {
    SimpleBoadDao dao = new SimpleBoadDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //num,currentPage 를 읽는다
        int num=Integer.parseInt(request.getParameter("num"));
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));

        //삭제
        dao.deleteBoard(num);
        response.sendRedirect("./list?currentPage="+currentPage);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
