package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import model.dto.BooksDto;
import model.dto.MemberDto;

public class BooksDao {
	
	private FactoryDao factory = FactoryDao.getInstance();
	private static BooksDao instance = new BooksDao();
	
	/** db������ ���� property ������� ���� */

	private String driver ;
	private String url ;
	private String username ;
	private String password ;
	private ResourceBundle bundle;

/**
 * �⺻ ������
 */
	private BooksDao() {
		

	}
	
	
	public static BooksDao getInstance() {
		return instance;
	}

	
/**
 * db���� �޼ҵ�
 * @return ���Ἲ���� connection����
 */
	

/**
 * ���� �߰� �޼ҵ�
 * @param dto
 * @return
 */


	public int insert(BooksDto dto) {
		
		String bname = dto.getBname();
		String author = dto.getAuthor();
		String publisher = dto.getPublisher();
		String publishdate = dto.getPublishdate();
		String isbn = dto.getIsbn();
		String loc = dto.getLoc();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//insert into books values('����� �µ�','�̱���','������','2016.08.19','9791195522125','��ġ');
		String sql = "insert into books values(?,?,?,?,?,?)";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);//�̿ϼ� ���� sql���
			
			pstm.setString(1, bname);
			pstm.setString(2, author);
			pstm.setString(3, publisher);
			pstm.setString(4, publishdate);
			pstm.setString(5, isbn);
			pstm.setString(6, loc);//�Ϻ��� ���� sql���
			
			return pstm.executeUpdate(); //sql ���� :�Ϻ��� ����̹Ƿ� sql�����ؼ��� �ȵ�

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ���� ��Ͽ���");

		} 
		factory.close(conn, pstm);
		return 0;
	}

	


	/**
	 * ���� �ߺ� ��ȸ �޼���
	 * @param isbn
	 * @return �����ϸ� true �������� ������ false
	 */
	public boolean isBookIsbn(String isbn) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select * from books where isbn='';
		String sql = "select * from books where isbn=?";

		try {
			conn = factory.getConnection();
			
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, isbn);
			
			rs = pstm.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ������� �ߺ���ȸ ����");

		} 
		factory.close(conn, pstm);
		
		return false;
	}

	
	/**
	 * ���� ���� �޼ҵ� 
	 * @param bname
	 * @param author
	 * @param publisher
	 * @param isbn
	 * @return�������� true ���н� false ��ȯ
	 */
	
	public boolean deleteBook(String bname, String author, String publisher, String isbn) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;

		
		String sql = "delete from books where bname=? and author =? and publisher=? and isbn=?";

		try {
			conn = factory.getConnection();
	
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bname);
			pstm.setString(2, author);
			pstm.setString(3, publisher);
			pstm.setString(4, isbn);

			rs = pstm.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : �������� ����");

		} 
		factory.close(conn, pstm);
		return false;
	}
	
	
	/**
	 * �������� ���� �޼ҵ�  
	 * @param isbn
	 * @param loc
	 * @return ������ 1, ���н� 0 ����
	 */
	public int updateBooks(String isbn,String loc) {
		
	

		Connection conn = null;
		PreparedStatement pstm = null;
		
		// update books set loc='' where isbn='';
		String sql = "update books set loc=? where isbn=?";

		try {
			conn = factory.getConnection();
			
			pstm = conn.prepareStatement(sql);// �̿ϼ� ���� sql���

			pstm.setString(1, loc);// �Ϻ��� ���� sql���
			pstm.setString(2, isbn);
			

			return pstm.executeUpdate(); // sql ���� :�Ϻ��� ����̹Ƿ� sql�����ؼ��� �ȵ�

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ���� ���� ���� ����");

		}
		factory.close(conn, pstm);
		return 0;
	}
	
	/**
	 * isbn �˻�
	 * @param isbn
	 * @return
	 */

	public String selectIsbn(String isbn) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select isbn from books where isbn='';
		String sql = "select isbn from books where isbn=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, isbn);

			rs = pstm.executeQuery();

			
		
			if (rs.next()) {
				isbn = rs.getString("isbn");
				return isbn;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� �α��� ����");

		}
		factory.close(conn, pstm);
		return null;
	}

	
	
/**
 * ���� �� ��ȸ
 * @param bname
 * @param author
 * @param publisher
 * @return �μ���ü, ���н� null
 */
	public BooksDto select(String bname,String author,String publisher) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		String publishdate = null;
		String isbn = null;
		String loc = null;
		//select * from books where bname='user01';
		String sql = "select * from books where bname=? or author =? or publisher=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
	
			pstm.setString(1, bname);
			pstm.setString(2,author);
			pstm.setString(3,publisher);
			
			rs = pstm.executeQuery();			
			
			if (rs.next()) {
				
				publishdate = rs.getString("publishdate");
				isbn = rs.getString("isbn");
				loc = rs.getString("loc");

				BooksDto dto = new BooksDto(bname, author, publisher, publishdate, isbn, loc);
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ���� ����ȸ ����");

		}
		factory.close(conn, pstm);
		
		return null;
	}
	
	
	
/**
 * ���� ��ü ��ȸ
 * @return
 */
	
	
	public ArrayList<BooksDto> selectAll() {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select * from books ;
		String sql = "select * from books";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			ArrayList<BooksDto> list = new ArrayList<BooksDto>();
			
			String bname =null;
			String author = null;
			String publisher = null;
			String publishdate = null;
			String isbn = null;
			String loc = null;
			
			
			while(rs.next()) {
				bname = rs.getString("bname");
				author = rs.getString("author");
				publisher = rs.getString("publisher");
				publishdate = rs.getString("publishdate");
				isbn = rs.getString("isbn");
				loc = rs.getString("loc");
				
				
				list.add(new BooksDto(bname, author, publisher, publishdate, isbn,loc));
				
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ���� ��ü��ȸ ����");

		} 
		factory.close(conn, pstm);
		return null;
	}
	
	

	
	/**
	 * ���� ��ȣ������ ȸ�� ��ü ��ȸ
	 * @param preference
	 * @return
	 */

	public HashMap<String, MemberDto> selectPref(String preference) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;

		// select * from members where preference like ('%����%'); 
		String sql = "select * from members where preference like (?)";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,"%"+preference+"%");
			rs = pstm.executeQuery();

			HashMap<String, MemberDto> map = new HashMap<String, MemberDto>();
		
			String userid =null;
			String username = null;
			String userpw = null;
			String addr = null;
			String mobile = null;
			String prefer = null;
			String birth = null;
			String email = null;
			
			

			if (rs.next()) {

				userid = rs.getString("userid");
				username = rs.getString("username");
				userpw = rs.getString("userpw");
				addr = rs.getString("addr");
				mobile = rs.getString("mobile");
				prefer = rs.getString("preference");
				birth = rs.getString("birth");
				email = rs.getString("email");

				map.put(userid, new MemberDto(username, birth, userid,  userpw, email, addr, mobile, prefer));
				return map;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : ȸ�� ��ȣ�����о� ��ȸ ����");

		}
		factory.close(conn, pstm);
		return null;
	}
}
