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
   // 브라우저 실행 --- http://localhost:8080/mvc/member/main.do
   
   private Map action = new HashMap();
   private Object key;
   public void init(ServletConfig config) throws ServletException {
	  System.out.println("init 실행......");
      String uri = config.getInitParameter("action");
      try {
         Properties p = new Properties();
         InputStream is = new FileInputStream(uri);
         p.load(is); // String 타입으로 로드 
         Enumeration enu = p.keys();  // 모든 키값 
         while(enu.hasMoreElements()) {
            String key = (String)enu.nextElement();
            String value = p.getProperty(key);
            Class c = Class.forName(value);
            Object obj = c.newInstance();  // 객체생성 
            action.put(key, obj);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("서비스 실행......");
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