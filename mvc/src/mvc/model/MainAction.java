package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements SuperAction {
	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {		
		System.out.println("MainAction ����");
		return "/WEB-INF/views/member/main.jsp";	// �����ؾ��� view�������� �������ش�.
	}
	
}