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
	
	
	//�ʱ�ȭ�޼��忡�� web.xml �ʱ�ȭ ������ �����ͼ� ������� ����
	public void init(ServletConfig config) throws ServletException{
		System.out.println(config.getInitParameter("title")+" "+config.getInitParameter("name"));
		
		
	}
	
	protected void updateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ȸ�� ���� ���� ��û���� �޼��� ����");
		
		
	}
	
	protected void showAllInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ��ü ȸ�� ���� ���� ��û���� �޼��� ����");
		
		ArrayList<MemberDto> result = service.allInfo();
		// debug
		System.out.println(">>>> result : " + result);
		
		if(result != null) {
			request.setAttribute("list",result);
			request.getRequestDispatcher("/AllInfo.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "��ü ���� ���� ���� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
		
	}
	protected void showMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ������ ���� ��û���� �޼��� ����");
		
		HttpSession session = request.getSession(false);
		String userid = (String) session.getAttribute("userid");
		
		MemberDto result = service.myInfo(userid);
		
		if(result != null) {
			request.setAttribute("dto",result);
			request.getRequestDispatcher("/MyInfo.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "������ ���� ���� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
	}
	
	protected void findPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ��й�ȣ ã�� ��û���� �޼��� ����");
		String userid = request.getParameter("userid");
		String mobile = request.getParameter("mobile");
		
		if(userid==null || userid.trim().length()==0) {
			System.out.println("���� :���̵� ���Է�");
			request.setAttribute("errorMessage", "���̵� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}

		if(mobile==null || mobile.trim().length()==0) {
			System.out.println("���� :�޴��� ���Է�");
			request.setAttribute("errorMessage", "�޴��� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		String result = service.findPw(userid,mobile);
		
		if(result != null) {
			request.setAttribute("successMessage", "��й�ȣ��  "+result+" �Դϴ�.");
			request.getRequestDispatcher("/ShowPw.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "��й�ȣ ã����� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
		
	}
	protected void findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ���̵� ã�� ��û���� �޼��� ����");
		String username = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		System.out.println("�̸� : "+username);
		System.out.println("�޴�����ȣ :"+mobile);
		
		if(username==null || username.trim().length()==0) {
			System.out.println("���� :�̸� ���Է�");
			request.setAttribute("errorMessage", "�̸� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}

		if(mobile==null || mobile.trim().length()==0) {
			System.out.println("���� :�޴��� ���Է�");
			request.setAttribute("errorMessage", "�޴��� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		String result = service.findId(username,mobile);
		
		if(result != null) {
			request.setAttribute("successMessage", "���̵�� "+result+" �Դϴ�.");
			request.getRequestDispatcher("/ShowId.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "�α��ν��� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> �α׾ƿ� ��û���� �޼��� ����");
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("userid");
		session.invalidate();
		response.sendRedirect("Index.jsp");  
	}
	
	protected void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ȸ������ ��û���� �޼��� ����");
		
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
			System.out.println("���� :���̵� ���Է�");
			request.setAttribute("errorMessage", "���̵� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(userpw==null || userpw.trim().length()==0) {
			System.out.println("���� :��й�ȣ ���Է�");
			request.setAttribute("errorMessage", "��й�ȣ ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(username==null || username.trim().length()==0) {
			System.out.println("���� :�̸� ���Է�");
			request.setAttribute("errorMessage", "�̸� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(address==null || address.trim().length()==0) {
			System.out.println("���� :�ּ� ���Է�");
			request.setAttribute("errorMessage", "�ּ� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(mobile1==null || mobile1.trim().length()==0||mobile2==null || mobile2.trim().length()==0||mobile3==null || mobile3.trim().length()==0) {
			System.out.println("���� :����ó ���Է�");
			request.setAttribute("errorMessage", "����ó ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		
		// �� ���񽺿��� ���Կ�û �Ƿ��ؼ� ����޾Ƽ� ����
		int result = service.join(username,birth,userid,userpw,email,address,mobile,preference);
		if(result !=0) {
			request.setAttribute("successMessage", username+"�� ȸ�������� �����մϴ�!");
			request.getRequestDispatcher("/Index.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "ȸ������ ���� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> �α��ο�û���� �޼��� ����");
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		System.out.println("���̵� : "+userid);
		System.out.println("��й�ȣ :"+userpw);
		
		if(userid==null || userid.trim().length()==0) {
			System.out.println("���� :���̵� ���Է�");
			request.setAttribute("errorMessage", "���̵� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(userpw==null||userpw.trim().length()==0) {
			System.out.println("���� :��й�ȣ ���Է�");
			response.sendRedirect("Login.jsp");  
			return;
			
		}
		String username = service.login(userid,userpw);
		
		if(username != null) {
			request.setAttribute("successMessage", "�α��μ���");
			
			HttpSession session = request.getSession(true);
			
			session.setAttribute("userid", userid);
			session.setAttribute("username", username);
			
			request.getRequestDispatcher("/Service.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "�α��ν��� ");
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
			System.out.println("������ �����Դϴ�");
				
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
