package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputFormAction implements SuperAction {
	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		System.out.println("inputForm.jsp ����");
		return "/WEB-INF/views/member/inputForm.jsp";	// �����ؾ��� view�������� �������ش�.
	}	
}