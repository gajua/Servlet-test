package namoo.tutorial.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class MimeServlet extends HttpServlet {
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String path = "D:/Lecture/강의자료/Servlet.pdf";
		String path = "D:/Lecture/강의자료/sample.mp3";
		//		Powerpoint 파일 전송을 위한 MIME 타입 변경
//		response.setContentType("application/pdf");
//		response.setContentType("audio/mpeg");
		response.setContentType("application/octet-stream");
		OutputStream out = response.getOutputStream();
		InputStream in = new FileInputStream(path);
		byte[] buffer = new byte[1024];
		int count = 0;
		while((count=in.read(buffer)) != -1) {
			out.write(buffer, 0, count);			
		}
		out.close();
		in.close();
	}

}








