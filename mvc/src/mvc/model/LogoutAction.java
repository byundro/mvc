package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements SuperAction {
	//오버라이딩 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logoutAction 실행");
		HttpSession session = request.getSession(false);
		if(session !=null)
			session.invalidate();
		return "/WEB-INF/views/member/logout.jsp";	// 실행해야할 view페이지를 리턴해준다.
	}	
}