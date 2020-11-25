package mvc.controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.SuperAction;

public class MvcController extends HttpServlet {
   // ������ ���� --- http://localhost:8080/mvc/member/main.do
   
   private Map action = new HashMap();
   private Object key;
   public void init(ServletConfig config) throws ServletException {
	  System.out.println("init ����......");
      String uri = config.getInitParameter("action");
      try {
         Properties p = new Properties();
         InputStream is = new FileInputStream(uri);
         p.load(is); // String Ÿ������ �ε� 
         Enumeration enu = p.keys();  // ��� Ű�� 
         while(enu.hasMoreElements()) {
            String key = (String)enu.nextElement();
            String value = p.getProperty(key);
            Class c = Class.forName(value);
            Object obj = c.newInstance();  // ��ü���� 
            action.put(key, obj);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("���� ����......");
	   String uri = request.getRequestURI();
	   String view = "";
	   if(key != null) {
		   Object obj = action.get(key);
		   if(obj != null) {
			   SuperAction sa = (SuperAction)obj;
			   view = sa.requestAction(request, response);
		   }
	   }
	   request.getRequestDispatcher(view).forward(request, response);
   }
}