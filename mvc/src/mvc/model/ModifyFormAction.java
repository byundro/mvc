package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyFormAction implements SuperAction {
	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		System.out.println("modifyFormAction ����");
		return "/WEB-INF/views/member/modifyForm.jsp";	// �����ؾ��� view�������� �������ش�.
	}	
}