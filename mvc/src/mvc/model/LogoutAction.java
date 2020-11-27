package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements SuperAction {
	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logoutAction ����");
		HttpSession session = request.getSession(false);
		if(session !=null)
			session.invalidate();
		return "/WEB-INF/views/member/logout.jsp";	// �����ؾ��� view�������� �������ش�.
	}	
}