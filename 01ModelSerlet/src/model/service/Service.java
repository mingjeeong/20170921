package model.service;

import java.util.ArrayList;

import model.dao.MemberDao;
import model.dto.MemberDto;
/**
 * ##Model(Service) ����(����) ����ϴ� Ŭ����
 * 
 * @author kosta
 *
 */
public class Service {
	// �μ����̺� data access �� ���� ��ü ����
	// DeptDao dao= new DeptDao();
	private static MemberDao dao = MemberDao.getInstance();
	
	public Service() {
		
	}
	/**
	 * ȸ�� ��� ��û ����
	 * @param dto �μ� ��ü
	 * @return ���ڵ� �߰� ���� ��� , ���� 1, ���� 0
	 */
	public int add(MemberDto dto) {
		// int result = dao.insert(dto);
		// return dao.insert(dto);

		// ��� ��û�� �μ���ȣ �ߺ���ȸ
		// �ߺ����� ������ �μ����
		// �ߺ��Ǹ� ����ó���� ��Ʈ�ѷ����� ����

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
	 * id �ߺ��˻�
	 * 
	 * @param id
	 * @return
	 */
	public boolean duplicate(String id) {
		if (!dao.isUserid(id)) {// �ߺ� ���̵� �������� ������
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
	 * �α���
	 * @param userid
	 * @param userpw
	 * @return
	 */
	public String login(String userid, String userpw) {
		return dao.login(userid, userpw);
	}
	/**
	 * ���̵� ã��
	 * @param username
	 * @param mobile
	 * @return
	 */
	public String findId(String username,String mobile) {
		return dao.selectId(username, mobile);
	}
	
	/**
	 * ��й�ȣ ã��
	 * @param userid
	 * @param mobile
	 * @return
	 */
	public String findPw(String userid,String mobile) {
		return dao.selectPw(userid, mobile);
	}
	/**
	 * ����������
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
