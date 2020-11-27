package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

public class InputProAction implements SuperAction {
	private Throwable e1;

	//�������̵� 
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {	
		// System.out.println("inputPro.jsp ����");
		try {
			request.setCharacterEncoding("EUC-KR");
		} catch (Exception e) {
			e1.printStackTrace();
		}
		LogonDataBean dto = new LogonDataBean();
		dto.setId(request.getParameter("id"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setName(request.getParameter("name"));
		dto.setJumin1(request.getParameter("jumin1"));
		dto.setJumin2(request.getParameter("jumin2"));
		dto.setEmail(request.getParameter("email"));
		dto.setBlog(request.getParameter("blog"));
		
		LogonDBBean manager = LogonDBBean.getInstance();
		try {
			manager.insertMember(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/WEB-INF/views/member/inputPro.jsp";	// �����ؾ��� view�������� �������ش�.
	}	
}