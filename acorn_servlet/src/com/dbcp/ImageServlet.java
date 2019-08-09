package com.dbcp;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File image;
    public ImageServlet() { super(); }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ServletContext context = this.getServletContext();
    	String path = context.getRealPath("/uploaddata");
    	//중간 매체 DB를 이용하면 이미지 업로드 다운이 가능
    	image = new File(path, "i.jpg");
    	response.setContentType("image/jpg");
    	DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(image)));
    	ServletOutputStream out = response.getOutputStream();
    	byte[] data = new byte[512];
    	while (true) {
			int x = in.read(data, 0, data.length);
			if (x == -1) break;
			out.write(data, 0, x);
			out.flush();
		}
    	in.close();
    	out.close();
	}
}
