package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements SuperAction {
	//오버라이딩 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {		
		System.out.println("MainAction 실행");
		return "/WEB-INF/views/member/main.jsp";	// 실행해야할 view페이지를 리턴해준다.
	}
	
}