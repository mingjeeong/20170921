package work.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.MemberDto;
import model.service.Service;

/**
 * Servlet implementation class FrontController

 * 
 * 
 */



public class FrontController extends HttpServlet {
	
	private Service service = new Service();
	
	
	//초기화메서드에서 web.xml 초기화 데이터 가져와서 멤버변수 설정
	public void init(ServletConfig config) throws ServletException{
		System.out.println(config.getInitParameter("title")+" "+config.getInitParameter("name"));
		
		
	}
	
	protected void updateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> 회원 정보 변경 요청서비스 메서드 수행");
		
		
	}
	
	protected void showAllInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> 전체 회원 정보 보기 요청서비스 메서드 수행");
		
		ArrayList<MemberDto> result = service.allInfo();
		// debug
		System.out.println(">>>> result : " + result);
		
		if(result != null) {
			request.setAttribute("list",result);
			request.getRequestDispatcher("/AllInfo.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "전체 정보 보기 실패 ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
		
	}
	protected void showMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> 내정보 보기 요청서비스 메서드 수행");
		
		HttpSession session = request.getSession(false);
		String userid = (String) session.getAttribute("userid");
		
		MemberDto result = service.myInfo(userid);
		
		if(result != null) {
			request.setAttribute("dto",result);
			request.getRequestDispatcher("/MyInfo.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "내정보 보기 실패 ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
	}
	
	protected void findPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> 비밀번호 찾기 요청서비스 메서드 수행");
		String userid = request.getParameter("userid");
		String mobile = request.getParameter("mobile");
		
		if(userid==null || userid.trim().length()==0) {
			System.out.println("오류 :아이디 미입력");
			request.setAttribute("errorMessage", "아이디 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}

		if(mobile==null || mobile.trim().length()==0) {
			System.out.println("오류 :휴대폰 미입력");
			request.setAttribute("errorMessage", "휴대폰 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		String result = service.findPw(userid,mobile);
		
		if(result != null) {
			request.setAttribute("successMessage", "비밀번호는  "+result+" 입니다.");
			request.getRequestDispatcher("/ShowPw.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "비밀번호 찾기실패 ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
		
	}
	protected void findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> 아이디 찾기 요청서비스 메서드 수행");
		String username = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		System.out.println("이름 : "+username);
		System.out.println("휴대폰번호 :"+mobile);
		
		if(username==null || username.trim().length()==0) {
			System.out.println("오류 :이름 미입력");
			request.setAttribute("errorMessage", "이름 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}

		if(mobile==null || mobile.trim().length()==0) {
			System.out.println("오류 :휴대폰 미입력");
			request.setAttribute("errorMessage", "휴대폰 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		String result = service.findId(username,mobile);
		
		if(result != null) {
			request.setAttribute("successMessage", "아이디는 "+result+" 입니다.");
			request.getRequestDispatcher("/ShowId.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "로그인실패 ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> 로그아웃 요청서비스 메서드 수행");
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("userid");
		session.invalidate();
		response.sendRedirect("Index.jsp");  
	}
	
	protected void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> 회원가입 요청서비스 메서드 수행");
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String username = request.getParameter("username");

		String birthYear = request.getParameter("birthYear");
		String birthMonth = request.getParameter("birthMonth");
		String birthDate= request.getParameter("birthDate");
		String birth = birthYear + "/" + birthMonth + "/" + birthDate;
		
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2;
		
		String address = request.getParameter("address");
		
		String mobile1 = request.getParameter("mobile1");
		String mobile2 = request.getParameter("mobile2");
		String mobile3= request.getParameter("mobile3");
		String mobile = mobile1 + "-" + mobile2 + "-" + mobile3;
		
		String preference= request.getParameter("preference");
		
		
		if(userid==null || userid.trim().length()==0) {
			System.out.println("오류 :아이디 미입력");
			request.setAttribute("errorMessage", "아이디 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(userpw==null || userpw.trim().length()==0) {
			System.out.println("오류 :비밀번호 미입력");
			request.setAttribute("errorMessage", "비밀번호 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(username==null || username.trim().length()==0) {
			System.out.println("오류 :이름 미입력");
			request.setAttribute("errorMessage", "이름 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(address==null || address.trim().length()==0) {
			System.out.println("오류 :주소 미입력");
			request.setAttribute("errorMessage", "주소 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(mobile1==null || mobile1.trim().length()==0||mobile2==null || mobile2.trim().length()==0||mobile3==null || mobile3.trim().length()==0) {
			System.out.println("오류 :연락처 미입력");
			request.setAttribute("errorMessage", "연락처 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		
		// 모델 서비스에게 가입요청 의뢰해서 결과받아서 응답
		int result = service.join(username,birth,userid,userpw,email,address,mobile,preference);
		if(result !=0) {
			request.setAttribute("successMessage", username+"님 회원가입을 축하합니다!");
			request.getRequestDispatcher("/Index.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "회원가입 실패 ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> 로그인요청서비스 메서드 수행");
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		System.out.println("아이디 : "+userid);
		System.out.println("비밀번호 :"+userpw);
		
		if(userid==null || userid.trim().length()==0) {
			System.out.println("오류 :아이디 미입력");
			request.setAttribute("errorMessage", "아이디 미입력");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(userpw==null||userpw.trim().length()==0) {
			System.out.println("오류 :비밀번호 미입력");
			response.sendRedirect("Login.jsp");  
			return;
			
		}
		String username = service.login(userid,userpw);
		
		if(username != null) {
			request.setAttribute("successMessage", "로그인성공");
			
			HttpSession session = request.getSession(true);
			
			session.setAttribute("userid", userid);
			session.setAttribute("username", username);
			
			request.getRequestDispatcher("/Service.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "로그인실패 ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			
		}
		
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(">>>action : "+action);
		switch(action) {
		case "login" :
			login(request,response);
			break;
		case "join" :
			join(request,response);
			break;
		case "logout" :
			logout(request,response);
			break;
		case "findid" :
			findId(request,response);
			break;
		case "findpw" :
			findPw(request,response);
			break;
		case "myinfo" :
			showMyInfo(request,response);
			break;
		case "allinfo" :
			showAllInfo(request,response);
			break;
		case "updateinfo" :
			updateInfo(request,response);
			break;
		default :
			System.out.println("미지원 서비스입니다");
				
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}

}
