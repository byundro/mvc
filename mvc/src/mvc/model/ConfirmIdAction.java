package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmIdAction implements SuperAction {
	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		// System.out.println("confirmId.jsp ����");
		return "/WEB-INF/views/member/confirmId.jsp";	// �����ؾ��� view�������� �������ش�.
	}	
}