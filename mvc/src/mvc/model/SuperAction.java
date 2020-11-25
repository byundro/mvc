package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SuperAction {
	//인터페이스에는 상수 와 추상메서드만 정의될수 있다. 
	public String requestAction(HttpServletRequest request,
								HttpServletResponse response);
}
