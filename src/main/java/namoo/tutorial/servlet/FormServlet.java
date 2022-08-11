package namoo.tutorial.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//		GET 방식으로 전송한 Form 데이터 읽기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String[] languages =request.getParameterValues("language");
		String car = request.getParameter("cars");
		
		System.out.println("===== 수신한 데이터 =======");
		System.out.println(id);
		System.out.println(name);
		System.out.println(passwd);
		
		if(languages != null) {
			for (String language : languages) {
				System.out.print(language + ",");
			}
		}
		System.out.println();
		System.out.println(car);
		
//		파라메터 이름을 모르는 경우(동적 생성)
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String parameterName = e.nextElement();
			if(parameterName.equals("language")) {
				String[] values = request.getParameterValues(parameterName);
				System.out.println(values);
			}
			String parameterValue= request.getParameter(parameterName);
			System.out.println(parameterValue);
			
		}
	}
	
	
}









