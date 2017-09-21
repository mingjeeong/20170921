package model.dto;

import java.io.Serializable;

/**
 * <pre>
 * ##dto클래스 구현
 *  data transfer object pattern 
 *  설계기술 적용해서 구현 
 *  encapsulation, 직렬화객체
 *  재정의 : equals(), hashCode(),toString 
 *  생성자 중복 정의 
 *  테이블 구조 참조해서 작성 
 *  자바 변수명 규칙/ DB SQL 컬럼명 규칙
 *  
 *  ##자바빈 컴포넌트
 * </pre>
 * 
 * @author kosta
 * @version ver.1.0
 * @since jdk1.4
 *
 */

public class MemberDto implements Serializable {
	/** 회원 이름 */
	private String username;
	/** 회원 생년월일 */
	private String birth;
	/** 회원 아이디 */
	public String userid;
	/** 회원 비밀번호 */
	private String userpw;
	/** 회원 이메일 */
	private String email;
	/** 회원 주소 */
	private String address;
	/** 회원 번호 */
	private String mobile;
	/** 회원 선호 분야 */
	private String preference;

	/** 기본생성자 */
	public MemberDto() {

	}

	/**
	 * 필수데이터 초기화 생성자
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
 * 전체 생성자
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
		builder.append("이름 : "+username);
		builder.append(",\t");
		builder.append("생년월일 : "+birth);
		builder.append(",\t");
		builder.append("아이디 : "+userid);
		builder.append(",\t");
		builder.append("비밀번호 : "+userpw);
		builder.append(",\t");
		builder.append("이메일 : "+email);
		builder.append(",\t");
		builder.append("주소 : "+address);
		builder.append(",\t");
		builder.append("휴대폰번호 : "+mobile);
		builder.append(",\t");
		builder.append("선호하는 도서 분야 : "+preference);
		return builder.toString();
	}

}
