package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.dto.MemberDto;

/**
 * <pre>
 * Singleton pattern
 * 
 *
 * </pre>��
 * 
 * @author kosta
 *
 */
public class MemberDao {
	
	private FactoryDao factory = FactoryDao.getInstance();
	private static MemberDao instance = new MemberDao();
	
	/** db������ ���� property ������� ���� */
	
	private String driver ;
	private String url ;
	private String username ;
	private String password ;
	private ResourceBundle bundle;

/**
 * �⺻ ������
 */
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		return instance;
	}

	/**
	 * ȸ�� ���ڵ� �߰� �޼ҵ�
	 * 
	 * @param dto
	 * @return ���н� 0 , ������  ��ϵ� ���ڵ� ��� ��ȯ
	 */
	public int insert(MemberDto dto) {
		
		String userid = dto.getUserid();
		String userpw = dto.getUserpw();
		String username = dto.getUsername();
		String addr = dto.getAddress();
		String mobile = dto.getMobile();
		String preference = dto.getPreference();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//insert into members values('user01','�̸�','password','�����','010-7852-6100',null);
		String sql = "insert into members values(?,?,?,?,?,?)";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);//�̿ϼ� ���� sql���
			
			pstm.setString(1, userid);
			pstm.setString(2, username);
			pstm.setString(3, userpw);
			pstm.setString(4, addr);
			pstm.setString(5, mobile);
			pstm.setString(6, preference);//�Ϻ��� ���� sql���
			
			return pstm.executeUpdate(); //sql ���� :�Ϻ��� ����̹Ƿ� sql�����ؼ��� �ȵ�

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ����Ͽ���");
		} 
		factory.close(conn, pstm);
		return 0;
	}
	
	/**
	 * ȸ������
	 * @param username
	 * @param birth
	 * @param userid
	 * @param userpw
	 * @param email
	 * @param address
	 * @param mobile
	 * @param preference
	 * @return
	 */
	public int join(String username,String birth,String userid,String userpw,String email,String address,String mobile,String preference) {
	
		Connection conn = null;
		PreparedStatement pstm = null;

		// insert into members
		// values('user01','�̸�','password','�����','010-7852-6100',null);
		
		//String sql2 = "insert into members(USERID,USERNAME,USERPW,ADDR,MOBILE) values(?,?,?,?,?)";
		String sql = "insert into members values(?,?,?,?,?,?,?,?)";
		

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);// �̿ϼ� ���� sql���

			pstm.setString(1, username);
			pstm.setString(2, birth);
			pstm.setString(3, userid);
			pstm.setString(4, userpw);
			pstm.setString(5, email);
			pstm.setString(6, address);
			pstm.setString(7, mobile);
			pstm.setString(8, preference);
			
			return pstm.executeUpdate(); // sql ���� :�Ϻ��� ����̹Ƿ� sql�����ؼ��� �ȵ�

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ����Ͽ���");

		}
		factory.close(conn, pstm);
		return 0;
	}

	/**
	 * ���̵� �ߺ� ��ȸ �޼���
	 * @param userid
	 * @return �����ϸ� true �������� ������ false
	 */
	public boolean isUserid(String userid) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;

		// select * from members where userid='user01';
		String sql = "select * from members where userid=?";

		try {
			conn = factory.getConnection();

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);
			
			rs = pstm.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ����� �ߺ���ȸ ����");

		} 
		factory.close(conn, pstm);
		
		return false;
	}
	
	/**
	 * ȸ�� ��й�ȣ ���� �޼ҵ�  
	 * @param dto
	 * @param pw
	 * @return ������ 1, ���н� 0 ����
	 */
	public int updatePassword(MemberDto dto,String pw) {
		String userid = dto.getUserid();
		
		Connection conn = null;
		// Statement stm = null;
		PreparedStatement pstm = null;
		
		// update members set userpw='1234' where userid='user04';
		String sql = "update members set userpw=?  where userid=?";

		try {
			conn = factory.getConnection();
			// stm = conn.createStatement();
			// return stm.executeUpdate(sql);
			pstm = conn.prepareStatement(sql);// �̿ϼ� ���� sql���

			pstm.setString(1, pw);
			pstm.setString(2, userid);// �Ϻ��� ���� sql���

			return pstm.executeUpdate(); // sql ���� :�Ϻ��� ����̹Ƿ� sql�����ؼ��� �ȵ�

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� ��й�ȣ ���� ����");

		}
		factory.close(conn, pstm);
		return 0;
	}
	
	/**
	 * ��й�ȣ ����
	 * @param id
	 * @param pw
	 * @return
	 */
	public int updatePassword(String id,String pw) {
		
		
		Connection conn = null;
		// Statement stm = null;
		PreparedStatement pstm = null;
		
		// update members set userpw='1234' where userid='user04';
		String sql = "update members set userpw=?  where userid=?";
		
		try {
			conn = factory.getConnection();
			// stm = conn.createStatement();
			// return stm.executeUpdate(sql);
			pstm = conn.prepareStatement(sql);// �̿ϼ� ���� sql���
			
			pstm.setString(1, pw);
			pstm.setString(2, id);// �Ϻ��� ���� sql���
			
			return pstm.executeUpdate(); // sql ���� :�Ϻ��� ����̹Ƿ� sql�����ؼ��� �ȵ�
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� ��й�ȣ ���� ����");
			
		}
		factory.close(conn, pstm);
		return 0;
	}
	
	/**
	 * ȸ������ ����
	 * @param pw
	 * @param addr
	 * @param mobile
	 * @param preference
	 * @param id
	 * @return ���� 1���� ����0����
	 */
	public int update(String pw , String addr ,String mobile,String preference ,String id) {
	
		
		Connection conn = null;
		// Statement stm = null;
		PreparedStatement pstm = null;
		
		// update members set userpw='12345',addr ='��⵵',mobile='010-7421-8900',preference='' where userid='user04';
		String sql = "update members set userpw=?,addr =?,mobile=?,preference=?  where userid=?";
		
		try {
			conn = factory.getConnection();
			// stm = conn.createStatement();
			// return stm.executeUpdate(sql);
			pstm = conn.prepareStatement(sql);// �̿ϼ� ���� sql���
			
			pstm.setString(1, pw);
			pstm.setString(2, addr);// �Ϻ��� ���� sql���
			pstm.setString(3, mobile);
			pstm.setString(4, preference);
			pstm.setString(5, id);
			
			return pstm.executeUpdate(); // sql ���� :�Ϻ��� ����̹Ƿ� sql�����ؼ��� �ȵ�
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� ��й�ȣ ���� ����");
			
		}
		factory.close(conn, pstm);
		return 0;
	}

	/**
	 * ȸ�� ���� �޼ҵ� (Ż��)
	 * @param userid
	 * @return �������� true ���н� false ��ȯ
	 */
	
	public boolean deleteMember(String userid) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;

		
		String sql = "delete from members where userid=?";

		try {
			conn = factory.getConnection();
	
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);

			rs = pstm.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ������ ����");

		} 
		factory.close(conn, pstm);
		return false;
	}

	/**
	 * ȸ�� �� ��ȸ (����������)
	 * @param userid
	 * @return ������ �μ���ü, ���н� null
	 */
	public MemberDto select(String userid) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select * from members where userid='user01';
		String sql = "select * from members where userid=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);
			rs = pstm.executeQuery();

			if (rs.next()) {
				String username = rs.getString("username");
				String userpw = rs.getString("userpw");
				String addr = rs.getString("address");
				String mobile = rs.getString("mobile");
				String birth = rs.getString("birth");
				String email = rs.getString("email");
				String preference = rs.getString("preference");
				
				return new MemberDto(username, birth, userid,  userpw,email, addr, mobile, preference);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� ���� ��ȸ ����");

		}finally {
			factory.close(conn, pstm,rs);
		}
		return null;
	}
	
	/**
	 * ��й�ȣ ã��
	 * @param userid
	 * @return ��й�ȣ 
	 */
	public String selectPw(String userid) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select userpw from members where userid='user01';
		String sql = "select userpw from members where userid=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);

			rs = pstm.executeQuery();

			String userpw = null;
		
			if (rs.next()) {
				userpw = rs.getString("userpw");
				return userpw;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� �α��� ����");

		}
		factory.close(conn, pstm);
		return null;
	}
	/**
	 * ���̵� ã��
	 * @param username
	 * @param mobile
	 * @return ���̵� 
	 */
	public String selectId(String username,String mobile) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select userid from members where username='�̹���' and mobile='010-3060-8952';
		
		String sql = "select userid from members where username=? and mobile=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, mobile);

			rs = pstm.executeQuery();

			String userid = null;

			if (rs.next()) {
				userid = rs.getString("userid");
				return userid;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� ���̵���ȸ ����");

		}
		factory.close(conn, pstm);
		return null;
	}
	
	/**
	 * ��й�ȣ ã��
	 * @param userid
	 * @param mobile
	 * @return ��й�ȣ
	 */
	public String selectPw(String userid,String mobile) {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select userpw from members where userid='user02' and mobile='010-3060-8952';
		
		String sql = "select userpw from members where userid=? and mobile=?";
		
		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);
			pstm.setString(2, mobile);
			
			rs = pstm.executeQuery();
			
			String userpw = null;
			
			if (rs.next()) {
				userpw = rs.getString("userpw");
				return userpw;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� ��й�ȣ ��ȸ ����");
			
		}
		factory.close(conn, pstm);
		return null;
	}
	
	

/**
 * ȸ�� ��ü ��ȸ
 * @return
 */
	public ArrayList<MemberDto> selectAll() {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select * from members order by date;
		String sql = "select * from members";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			ArrayList<MemberDto> list = new ArrayList<MemberDto>();
			
			String userid =null;
			String username = null;
			String userpw = null;
			String addr = null;
			String mobile = null;
			String preference = null;
			String birth = null;
			String email = null;
			
			while(rs.next()) {
				userid = rs.getString("userid");
				username = rs.getString("username");
				userpw = rs.getString("userpw");
				addr = rs.getString("address");
				mobile = rs.getString("mobile");
				preference = rs.getString("preference");
				birth = rs.getString("birth");
				email = rs.getString("email");
				
				list.add(new MemberDto(username, birth, userid,  userpw,email, addr, mobile, preference));
				
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� ��ü��ȸ ����");

		} finally {
			factory.close(conn, pstm);
		}
		return null;
	}
	
	/**
	 * ���� ��ȣ�����о��� ��� ��ȸ �޼���
	 * @param preference
	 * @return
	 */
	public ArrayList<MemberDto> selectPref(String preference) {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		// select * from members where preference like ('%�̼�%'); 
		String sql = "select * from members where preference like (?)";
		
		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,"%"+preference+"%");
			rs = pstm.executeQuery();
			
			ArrayList<MemberDto> list = new ArrayList<MemberDto>();
			
			String userid =null;
			String username = null;
			String userpw = null;
			String addr = null;
			String mobile = null;
			String birth = null;
			String email = null;
		
			while(rs.next()) {
				userid = rs.getString("userid");
				username = rs.getString("username");
				userpw = rs.getString("userpw");
				addr = rs.getString("addr");
				mobile = rs.getString("mobile");
				birth = rs.getString("birth");
				email = rs.getString("email");
				
				list.add(new MemberDto(username, birth, userid,  userpw,email, addr, mobile, preference));
				
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� ��ü��ȸ ����");
			
		} 
		factory.close(conn, pstm);
		return null;
	}
	/**
	 * �α���
	 * @param userid
	 * @param userpw
	 * @return
	 */
	public String login(String userid,String userpw) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		
		String sql = "select username from members where userid=? and userpw=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);
			pstm.setString(2, userpw);

			rs = pstm.executeQuery();

			if (rs.next()) {
				return rs.getString("username");

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� �α��� ����");
		} finally {
			factory.close(conn, pstm);
		}
		return null;
	}
	
}
