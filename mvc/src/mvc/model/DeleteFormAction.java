package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements SuperAction {
	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		// System.out.println("deleteForm.jsp ����");
		return "/WEB-INF/views/member/deleteForm.jsp";	// �����ؾ��� view�������� �������ش�.
	}	
}