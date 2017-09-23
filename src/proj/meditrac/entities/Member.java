package proj.meditrac.entities;

import java.io.Serializable;
import java.util.Date;

import proj.meditrac.util.Utility;

public class Member implements Serializable {
	
	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 588329871894721259L;
	
	private long id;
	private String password;
	private String group;
	private Date createdAt;
	private Date lastLogin;
	private String active;
	
	public class Group {
		public static final String ADMINISTRATOR = "ADMINISTRATOR";
		public static final String HOSPITAL = "HOSPITAL";
		public static final String DOCTOR = "DOCTOR";
		public static final String PATIENT = "PATIENT";
	}
	
	public class Active {
		public static final String ACTIVE = "ACTIVE";
		public static final String INACTIVE = "NOT_ACTIVE";
	}
	
	public Member() {
		super();
	}

	public Member(long id, String password, String group, Date createdAt, Date lastLogin, String active) {
		super();
		this.id = id;
		this.password = Utility.encrypt(password);
		this.group = group;
		this.createdAt = createdAt;
		this.lastLogin = lastLogin;
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Utility.encrypt(password);
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", group=" + group + ", createdAt=" + createdAt
				+ ", lastLogin=" + lastLogin + ", active=" + active + "]";
	}
		
}
