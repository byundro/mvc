package mvc.model;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch11.logon.LogonDataBean;
public class ProAction implements SuperAction{
   public String requestAction(HttpServletRequest request, HttpServletResponse response) {
      String name = request.getParameter("name");      
      String num = request.getParameter("num");
      int n = Integer.parseInt(num) + 100;
      
      LogonDataBean dto = new LogonDataBean();
      dto.setId("java");
      dto.setPasswd("1234");
      dto.setName("global");
      
      ArrayList list = new ArrayList();
      list.add("hello");
      list.add(777);
      list.add(dto);
      request.setAttribute("list", list);
      
      request.setAttribute("dto", dto);
      request.setAttribute("result", n);
      request.setAttribute("name", name);
      
      
      return "/1126/pro.jsp";
   }
}