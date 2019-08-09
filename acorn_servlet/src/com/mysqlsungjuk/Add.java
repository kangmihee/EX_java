package com.mysqlsungjuk;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 이벤트를 받고 처리할 때 사용 (클라이언트 요청이 도착하는 곳)
@WebServlet("/Add")
public class Add extends HttpServlet {
   private static final long serialVersionUID = 1L;
    public Add() {super();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       String name = request.getParameter("addname");
       
       int kor = Integer.parseInt(request.getParameter("addkor"));
       int mat = Integer.parseInt(request.getParameter("addmat"));
       int eng = Integer.parseInt(request.getParameter("addeng"));
       
       SungjukDTO dto = new SungjukDTO();
       dto.setName(name);
       dto.setKor(kor);;
       dto.setMat(mat);
       dto.setEng(eng);;
       
       SungjukDAO dao = SungjukDAO.getInstance();
       boolean bool = dao.addSungjuk(dto);
       if(bool) { response.sendRedirect("View.html");}
    }


}













