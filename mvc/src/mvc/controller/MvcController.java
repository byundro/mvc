package mvc.controller;

import java.io.FileInputStream; //  파일 읽기.
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
       
   //브라우저 실행 -- http://localhost:8080/mvc/member/main.do
   
   //최종적결과를 보관 할  map클래스 선언.
   private Map action = new HashMap();
   
   public void init(ServletConfig config) {   // 사용자가 최초접속 시 딱 한번 정의됨.
      System.out.println("init실행");
      String uri = config.getInitParameter("action");//""xml에서 지정한 이름
         // ↑ action의 value값인 properties경로를 받음.
      System.out.println("uri실행  " +uri);
      
      //java.util.properties 클래스 - properties 파일 로딩가능
      // Properties 클래스도 MAP(key,value) 종류임. (properties확장자에서 =기준으로 key,value)
      try {
         Properties p = new Properties(); // 생성
         InputStream is = new FileInputStream(uri);
         p.load(is);            // properties파일을 String 타입으로 로드
         Enumeration enu = p.keys();   // 모든 키 값
         while(enu.hasMoreElements()) {   // (있는지 없는지 확인하고 하나씩 꺼내줌, 순서유지x)
            String key = (String) enu.nextElement();
            String value = p.getProperty(key);   //해당key의 value를 꺼냄.
            Class c = Class.forName(value);   // DAO처음할때 1단계작엄에 사용.
            Object obj = c.newInstance();   // value인 해당 클래스 객체생성 후 obj에 저장.
            action.put(key,obj);   //최종적인 객체저장.(private Map)
         }
         System.out.println(p);   //{/mvc/member/loginPro.do=mvc.model.LoginProAction, /mvc/member/loginForm.do=mvc.model.LoginFormAction, /mvc/member/main.do=mvc.model.MainAction}
      }catch(Exception e) {      // 콘솔화면에 출력
         e.printStackTrace();
      }
   }      
   
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //사용자가 요청 할 때마다 계속 실행 되는 곳. / init메서드는 최초사용자가 딱한번보여주는것.
      System.out.println("service실행");
      System.out.println(action);
      String key = request.getRequestURI();
      String view = "/member/main.jsp";   //defalut경로를 지정해둬도 됨.
      if(key != null) {
         Object obj = action.get(key);   // key의 value인 obj객체가 꺼내지는 것.
         if(obj != null) {   // 꺼낸 객체가 null이 아닌경우
            SuperAction sa = (SuperAction)obj;
            view = sa.requestAction(request, response);   // SuperAction에서 추상메서드를 만들었고 MainAction에서 implements해서 requestAction해서 MainAction 실행.
         }   // 어떻게 MainAction으로 넘어가는거지?
      }
      request.getRequestDispatcher(view).forward(request,response);
   }
   
   
   
   
   
   
   
/*   // 모든 요청을 받을 수 있는 통합controller를 만드는 것.
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("Controller 실행");
      String uri = request.getRequestURI();   // 요청주소(URI)
      System.out.println("요청 URI=>" + uri);   // .do를 하면 요청됨.
      
      // 뷰로 넘기는 조건
      String view = "";
      if(uri.equals("/mvc/member/loginForm.do")){   // ""는 가상의 주소인 것이고 실제 view는 아랫줄이다.
         //view = "/1124/main.jsp";
         //..java 실행문 ( 모델 처리 영역)
         // DAO, DTO , 요청처리를 위한 클래스 사용 -> 이렇게 되면 코드가 컨트롤안에서 돌아 복잡해짐.
         //=> controller --처리해야될 로직 분리 -> 액션클래스(모델)
         //loginForm.jsp (View)
         //LiginFormAction.java (Model)-액션클래스
      }else if(uri.equals("/mvc/member/loginPro.do")){ 
         //view = "/1124/form.jsp";
         //loginPro.jsp(View)
         //LoginProAction.java (Model)
      }else if(uri.equals("/mvc/member/main.do")) {
         //..java 실행문 ( 모델 처리 영역)
         //main.jsp (View)
         //MainAction.java (Model)
      }
      request.getRequestDispatcher(view).forward(request,response);
   }
*/
}