package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyAction implements SuperAction {
	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		System.out.println("modifyAction ����");
		return "/WEB-INF/views/member/modify.jsp";	// �����ؾ��� view�������� �������ش�.
	}	
}