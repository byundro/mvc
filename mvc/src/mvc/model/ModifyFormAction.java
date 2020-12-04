package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

public class ModifyFormAction implements SuperAction {
	//오버라이딩 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		System.out.println("modifyFormAction 실행");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
	    
	    LogonDBBean manager = LogonDBBean.getInstance();
	    try {
			LogonDataBean c = manager.getMember(id);
			request.setAttribute("c", c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/WEB-INF/views/member/modifyForm.jsp";	// 실행해야할 view페이지를 리턴해준다.
	}	
}