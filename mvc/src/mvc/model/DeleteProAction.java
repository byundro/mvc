package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProAction implements SuperAction {
	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		// System.out.println("deletePro.jsp ����");
		return "/WEB-INF/views/member/deletePro.jsp";	// �����ؾ��� view�������� �������ش�.
	}	
}