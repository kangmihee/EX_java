package com.dbcp;

import java.io.*;
import java.util.ArrayList;

//제한 사이즈를 초과했을 경우 발생하는 예외
import javax.naming.SizeLimitExceededException;
//서블릿의 정보 context를 확인하는 객체(톰캣서버의 환경)
import javax.servlet.ServletContext;

//implicit object 암묵객체(jsp) - 통신처리
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//파일 업로딩 관련 jar파일 포함 객체
import org.apache.commons.fileupload.FileItem; //form요소를 item
import org.apache.commons.fileupload.disk.DiskFileItemFactory; //item을 모은 것
import org.apache.commons.fileupload.servlet.ServletFileUpload; //파일을 업로드

// 멀티파트로 업로드됨 / 웹서버는 파일 업로딩 기능이 없음
@WebServlet("/fileupload_save")
public class fileupload_save extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public fileupload_save() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = ""; String id = ""; String pw = ""; String filename = "";
		//멀티파트인가를 확인
		boolean check = ServletFileUpload.isMultipartContent(request);
		if (check) {
			//톰캣이 구동되어지는 환경에 대한 context
			ServletContext context = this.getServletContext();
			//실제 경로, 상대주소
			String path = context.getRealPath("/uploaddata"); //디렉토리
			//파일을 오픈
			File dir = new File(path);
			if (!dir.exists()) dir.mkdir(); //디렉토리를 생성
			try {
				//아이템을 묶는 역할
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(10 * 1024); //문지방(경계)
				factory.setRepository(dir); //저장되는 공간
				
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(10 * 1024 * 1024); //10M한계
				upload.setHeaderEncoding("UTF-8");
				
				ArrayList items = (ArrayList)upload.parseRequest(request);
				for (int i = 0; i < items.size(); ++i) {
					//폼에 있는 아이템의 집합
					FileItem item = (FileItem)items.get(i);
					String value = item.getString("UTF-8");
					
					if (item.isFormField()) {
						//getFieldName : 변수이름을 받아오고
						if (item.getFieldName().equals("name")) name = value;
						else if (item.getFieldName().equals("id")) id = value;
						else if (item.getFieldName().equals("pw")) pw = value;
					} else {
						if (item.getFieldName().equals("picture")) {
							filename = item.getName();
							if (filename == null || filename.trim().length() == 0) continue;
							//파일이름을 취함
							filename = filename.substring(filename.lastIndexOf("\\") + 1);
							File file = new File(dir, filename);
							//메모리에서 파싱 분리 그 데이터를 직접 파일로 저장
							item.write(file);
						}
					}
				}
			} catch (SizeLimitExceededException e) { //파일 용량 초과시 발생
				e.printStackTrace();
			} catch (FileNotFoundException e) { //파일이 없을 경우 발생
				e.printStackTrace();
			} catch (Exception e) { //예외의 최상위 오브젝트
				e.printStackTrace();
			}
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			//확인
			out.println("<html><body>");
			out.println("회원 가입할 이름 : " + name + "<br>");
			out.println("회원 가입할 아이디 : " + id + "<br>");
			out.println("회원 가입할 비밀번호 : " + pw + "<br>");
			out.println("회원 가입할 사진 저장 경로 : " + dir + "<br>");
			out.println("회원 가입할 사진 파일 이름 : " + filename + "<br>");
			out.println("</body></html>");
		}
	}
}
