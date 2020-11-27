package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyProAction implements SuperAction {
	//오버라이딩 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		// System.out.println("loginForm.jsp 실행");
		return "/WEB-INF/views/member/modifyPro.jsp";	// 실행해야할 view페이지를 리턴해준다.
	}	
}