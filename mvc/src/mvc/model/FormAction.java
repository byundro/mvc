package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormAction implements SuperAction {

	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		// action���� �ؾ��� ���� interface���� �ϴ°�???
		
		System.out.println("FormAction ����");
		return "/1126/form.jsp";	// �����ؾ��� view�������� �������ش�.
	}
}