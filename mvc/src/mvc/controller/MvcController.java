package mvc.controller;

import java.io.FileInputStream; //  ���� �б�.
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.SuperAction;

public class MvcController extends HttpServlet {
       
   //������ ���� -- http://localhost:8080/mvc/member/main.do
   
   //����������� ���� ��  mapŬ���� ����.
   private Map action = new HashMap();
   
   public void init(ServletConfig config) {   // ����ڰ� �������� �� �� �ѹ� ���ǵ�.
      System.out.println("init����");
      String uri = config.getInitParameter("action");//""xml���� ������ �̸�
         // �� action�� value���� properties��θ� ����.
      System.out.println("uri����  " +uri);
      
      //java.util.properties Ŭ���� - properties ���� �ε�����
      // Properties Ŭ������ MAP(key,value) ������. (propertiesȮ���ڿ��� =�������� key,value)
      try {
         Properties p = new Properties(); // ����
         InputStream is = new FileInputStream(uri);
         p.load(is);            // properties������ String Ÿ������ �ε�
         Enumeration enu = p.keys();   // ��� Ű ��
         while(enu.hasMoreElements()) {   // (�ִ��� ������ Ȯ���ϰ� �ϳ��� ������, ��������x)
            String key = (String) enu.nextElement();
            String value = p.getProperty(key);   //�ش�key�� value�� ����.
            Class c = Class.forName(value);   // DAOó���Ҷ� 1�ܰ��۾��� ���.
            Object obj = c.newInstance();   // value�� �ش� Ŭ���� ��ü���� �� obj�� ����.
            action.put(key,obj);   //�������� ��ü����.(private Map)
         }
         System.out.println(p);   //{/mvc/member/loginPro.do=mvc.model.LoginProAction, /mvc/member/loginForm.do=mvc.model.LoginFormAction, /mvc/member/main.do=mvc.model.MainAction}
      }catch(Exception e) {      // �ܼ�ȭ�鿡 ���
         e.printStackTrace();
      }
   }      
   
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //����ڰ� ��û �� ������ ��� ���� �Ǵ� ��. / init�޼���� ���ʻ���ڰ� ���ѹ������ִ°�.
      System.out.println("service����");
      System.out.println(action);
      String key = request.getRequestURI();
      String view = "/member/main.jsp";   //defalut��θ� �����صֵ� ��.
      if(key != null) {
         Object obj = action.get(key);   // key�� value�� obj��ü�� �������� ��.
         if(obj != null) {   // ���� ��ü�� null�� �ƴѰ��
            SuperAction sa = (SuperAction)obj;
            view = sa.requestAction(request, response);   // SuperAction���� �߻�޼��带 ������� MainAction���� implements�ؼ� requestAction�ؼ� MainAction ����.
         }   // ��� MainAction���� �Ѿ�°���?
      }
      request.getRequestDispatcher(view).forward(request,response);
   }
   
   
   
   
   
   
   
/*   // ��� ��û�� ���� �� �ִ� ����controller�� ����� ��.
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("Controller ����");
      String uri = request.getRequestURI();   // ��û�ּ�(URI)
      System.out.println("��û URI=>" + uri);   // .do�� �ϸ� ��û��.
      
      // ��� �ѱ�� ����
      String view = "";
      if(uri.equals("/mvc/member/loginForm.do")){   // ""�� ������ �ּ��� ���̰� ���� view�� �Ʒ����̴�.
         //view = "/1124/main.jsp";
         //..java ���๮ ( �� ó�� ����)
         // DAO, DTO , ��ûó���� ���� Ŭ���� ��� -> �̷��� �Ǹ� �ڵ尡 ��Ʈ�Ѿȿ��� ���� ��������.
         //=> controller --ó���ؾߵ� ���� �и� -> �׼�Ŭ����(��)
         //loginForm.jsp (View)
         //LiginFormAction.java (Model)-�׼�Ŭ����
      }else if(uri.equals("/mvc/member/loginPro.do")){ 
         //view = "/1124/form.jsp";
         //loginPro.jsp(View)
         //LoginProAction.java (Model)
      }else if(uri.equals("/mvc/member/main.do")) {
         //..java ���๮ ( �� ó�� ����)
         //main.jsp (View)
         //MainAction.java (Model)
      }
      request.getRequestDispatcher(view).forward(request,response);
   }
*/
}