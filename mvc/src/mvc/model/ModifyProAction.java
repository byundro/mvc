package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyProAction implements SuperAction {
	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		// System.out.println("loginForm.jsp ����");
		return "/WEB-INF/views/member/modifyPro.jsp";	// �����ؾ��� view�������� �������ش�.
	}	
}