package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SuperAction {
	//�������̽����� ��� �� �߻�޼��常 ���ǵɼ� �ִ�. 
	public String requestAction(HttpServletRequest request,
								HttpServletResponse response);
}
