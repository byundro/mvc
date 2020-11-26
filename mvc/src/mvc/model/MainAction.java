package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements SuperAction {

	//오버라이딩 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		// action에서 해야할 것을 interface에서 하는것???
		
		System.out.println("MainAction 실행");
		return "/member/main.jsp";	// 실행해야할 view페이지를 리턴해준다.
	}
	
}