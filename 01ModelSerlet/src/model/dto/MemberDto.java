package model.dto;

import java.io.Serializable;

/**
 * <pre>
 * ##dtoŬ���� ����
 *  data transfer object pattern 
 *  ������ �����ؼ� ���� 
 *  encapsulation, ����ȭ��ü
 *  ������ : equals(), hashCode(),toString 
 *  ������ �ߺ� ���� 
 *  ���̺� ���� �����ؼ� �ۼ� 
 *  �ڹ� ������ ��Ģ/ DB SQL �÷��� ��Ģ
 *  
 *  ##�ڹٺ� ������Ʈ
 * </pre>
 * 
 * @author kosta
 * @version ver.1.0
 * @since jdk1.4
 *
 */

public class MemberDto implements Serializable {
	/** ȸ�� �̸� */
	private String username;
	/** ȸ�� ������� */
	private String birth;
	/** ȸ�� ���̵� */
	public String userid;
	/** ȸ�� ��й�ȣ */
	private String userpw;
	/** ȸ�� �̸��� */
	private String email;
	/** ȸ�� �ּ� */
	private String address;
	/** ȸ�� ��ȣ */
	private String mobile;
	/** ȸ�� ��ȣ �о� */
	private String preference;

	/** �⺻������ */
	public MemberDto() {

	}

	/**
	 * �ʼ������� �ʱ�ȭ ������
	 * @param userid
	 * @param userpw
	 */
	public MemberDto(String userid, String userpw) {

		this.userid = userid;
		this.userpw = userpw;
	}
	
	public MemberDto(String userid) {
		this.userid = userid;
	}

	
/**
 * ��ü ������
 * @param username
 * @param birth
 * @param userid
 * @param userpw
 * @param email
 * @param address
 * @param mobile
 * @param preference
 */
	public MemberDto(String username, String birth, String userid, String userpw, String email, String address,
			String mobile, String preference) {
		
		this.username = username;
		this.birth = birth;
		this.userid = userid;
		this.userpw = userpw;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.preference = preference;
	}

	/** setter and getter*/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((preference == null) ? 0 : preference.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userpw == null) ? 0 : userpw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDto other = (MemberDto) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("�̸� : "+username);
		builder.append(",\t");
		builder.append("������� : "+birth);
		builder.append(",\t");
		builder.append("���̵� : "+userid);
		builder.append(",\t");
		builder.append("��й�ȣ : "+userpw);
		builder.append(",\t");
		builder.append("�̸��� : "+email);
		builder.append(",\t");
		builder.append("�ּ� : "+address);
		builder.append(",\t");
		builder.append("�޴�����ȣ : "+mobile);
		builder.append(",\t");
		builder.append("��ȣ�ϴ� ���� �о� : "+preference);
		return builder.toString();
	}

}
