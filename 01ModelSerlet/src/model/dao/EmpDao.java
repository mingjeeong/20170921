package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * �������̺� ���� db access object Ŭ����
 * singleton pattern ���� ����
 * @author kosta
 *
 */

public class EmpDao {
	private FactoryDao factory = FactoryDao.getInstance();
	private static EmpDao instance = new EmpDao();
//	
//	private String driver ;
//	private String url ;
//	private String username ;
//	private String password ;
	
	private ResourceBundle bundle;
	
	private EmpDao() {
		
//		bundle = ResourceBundle.getBundle("conf/dbserver");
//		driver = bundle.getString("oracle.driver");
//		url=bundle.getString("oracle.url");
//		username =bundle.getString("oracle.username");
//		password=bundle.getString("oracle.password");
//		
//		try {
//			Class.forName(driver);
//		} catch (ClassNotFoundException e) {
//			System.out.println("����̹� �ε� ����");
//		}
//
//		
	}
	public static EmpDao getInstance() {
		return instance;
	}
	
//	public Connection getConnection() {
//		try {
//			return DriverManager.getConnection(url, username, password);
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//			System.out.println("DB���� �������");
//		}
//		return null;
//	}

}
