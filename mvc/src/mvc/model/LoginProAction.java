package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;

public class LoginProAction implements SuperAction {

	//오버라이딩 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		    System.out.println("loginPro.jsp 실행");
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");			
			LogonDBBean manager = LogonDBBean.getInstance();
			
			try {
				int check = manager.userCheck(id, passwd);
				if(check == 1) {
					HttpSession session = request.getSession();
					session.setAttribute("memId" , id);
				}
				request.setAttribute("check", check);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "/WEB-INF/views/member/loginPro.jsp";	// 실행해야할 view페이지를 리턴해준다.
	}	
}