package model.service;

import java.util.ArrayList;

import model.dao.MemberDao;
import model.dto.MemberDto;
/**
 * ##Model(Service) 서비스(업무) 담당하는 클래스
 * 
 * @author kosta
 *
 */
public class Service {
	// 부서테이블 data access 을 위한 객체 생성
	// DeptDao dao= new DeptDao();
	private static MemberDao dao = MemberDao.getInstance();
	
	public Service() {
		
	}
	/**
	 * 회원 등록 요청 서비스
	 * @param dto 부서 객체
	 * @return 레코드 추가 성공 행수 , 성공 1, 실패 0
	 */
	public int add(MemberDto dto) {
		// int result = dao.insert(dto);
		// return dao.insert(dto);

		// 등록 요청한 부서번호 중복조회
		// 중복되지 않으면 부서등록
		// 중복되면 오류처리를 컨트롤러에게 전달

		if (!dao.isUserid(dto.getUserid())) {
			return dao.insert(dto);
		}
		return 0;
	}

	public int join(String username, String birth, String userid, String userpw, String email, String address,String mobile, String preference) {
		if (!dao.isUserid(userid)) {
			return dao.join(username, birth, userid, userpw, email, address, mobile, preference);
		}
		return 0;

	}
	/**
	 * id 중복검사
	 * 
	 * @param id
	 * @return
	 */
	public boolean duplicate(String id) {
		if (!dao.isUserid(id)) {// 중복 아이디 존재하지 않으면
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @param deptno
	 * @return
	 */
	public MemberDto get(int deptno) {
		return null;
	}
	/**
	 * 로그인
	 * @param userid
	 * @param userpw
	 * @return
	 */
	public String login(String userid, String userpw) {
		return dao.login(userid, userpw);
	}
	/**
	 * 아이디 찾기
	 * @param username
	 * @param mobile
	 * @return
	 */
	public String findId(String username,String mobile) {
		return dao.selectId(username, mobile);
	}
	
	/**
	 * 비밀번호 찾기
	 * @param userid
	 * @param mobile
	 * @return
	 */
	public String findPw(String userid,String mobile) {
		return dao.selectPw(userid, mobile);
	}
	/**
	 * 내정보보기
	 * @param userid
	 * @return
	 */
	public MemberDto myInfo(String userid) {
		return dao.select(userid);
		
	}
	
	public ArrayList<MemberDto> allInfo() {
		return dao.selectAll();
		
	}

}
