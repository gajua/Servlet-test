package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>동적구구단 출력하기</title>");
		out.println("<link rel='stylesheet' type='text/css' href='css/001.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>구구단</h2>");
		out.println("<table>");
		for (int i = 2; i < 10; i++) {
			out.println("<tr>");
			for (int j = 1; j < 10; j++) {
				out.println("<td>"+i+"*"+j+"="+(i*j)+"</td>");
			}
			out.println("</tr>");			
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}







