package co.edu.unal.unshop.shared;



import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class UserShop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String userid;	
	
	private String passuser;
	private String name;
	private String email;
	private boolean isAdmin;
	
	public UserShop(){	
    }
	public UserShop(String userid, String name, String email, boolean role, String passuser) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.isAdmin = role;
		this.passuser = passuser;

	}

	
	public String getPassUser() {
		return passuser;
	}

	
	public void setPassUser(String passuser) {
		this.passuser = passuser;
	}


	
	public String getUserId() {
		return userid;
	}

	
	public void setUserId(String userid) {
		this.userid = userid;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public boolean getRole() {
		return isAdmin;
	}

	
	public void setRole(boolean role) {
		this.isAdmin = role;
	}
	

}
