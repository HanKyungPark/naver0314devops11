package data.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

@WebServlet("/study1")
public class HelloServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("message", "안녕하세요. 비트캠프입니다");
        request.setAttribute("today",new Date());
        request.setAttribute("num1",8);
        request.setAttribute("num2",5);


        //test1.jsp 로 포워드 (url안바뀜,response,request 그래도 전달)
        RequestDispatcher rd=request.getRequestDispatcher("./Day0513/test1.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
