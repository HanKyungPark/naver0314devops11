package board.serblet;

import data.dao.SimpleBoadDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/board/updatechu")
public class UpdateChuServlet extends HttpServlet {
    SimpleBoadDao dao = new SimpleBoadDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //num을 읽기
        int num=Integer.parseInt(request.getParameter("num"));
        //dao 의 chu update
        dao.updateChu(num);
        //update 된 chu 값 얻기
        int chu = dao.getData(num).getChu();
        //json 형식으로 문자열을 만든다
        //{"chu":5} 이런형식으로 만든다
        String s="{\"chu\":"+chu+"}";
        //request 에 담기
        request.setAttribute("s",s);
        //jsonchu.jsp 로 포워드
        RequestDispatcher rd = request.getRequestDispatcher("../day0514/jsonchu.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
