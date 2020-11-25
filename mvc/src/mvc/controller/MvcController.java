package mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MvcController")
public class MvcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MvcController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("controller 角青...");
	/* ("夸没 ID" + uri); */
	String uri = request.getRequestURI(); //夸没林家
	
	String view = "";
	if(uri.contentEquals("/mvc/main.do")) {
		
		view = "/1124/main.jsp";
	
	}else if(uri.equals("/mvc/member/index.do")) {
	
		view = "/1124/form.jsp";
	}
	request.getRequestDispatcher(view).forward(request, response);
 }

}
