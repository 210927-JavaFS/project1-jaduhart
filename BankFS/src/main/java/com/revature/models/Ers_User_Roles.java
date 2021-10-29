package com.revature.models;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ers_User_Roles {
	@Id
	private int User_Role_Id;
	private String User_Role;
	
	
	
	
	public Ers_User_Roles(int user_Role_Id, String user_Role) {
		super();
		User_Role_Id = user_Role_Id;
		User_Role = user_Role;
	}
	
	
	public Ers_User_Roles() {
		super();
	}


	public int getUser_Role_Id() {
		return User_Role_Id;
	}
	public void setUser_Role_Id(int user_Role_Id) {
		User_Role_Id = user_Role_Id;
	}
	public String getUser_Role() {
		return User_Role;
	}
	public void setUser_Role(String user_Role) {
		User_Role = user_Role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((User_Role == null) ? 0 : User_Role.hashCode());
		result = prime * result + User_Role_Id;
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
		Ers_User_Roles other = (Ers_User_Roles) obj;
		if (User_Role == null) {
			if (other.User_Role != null)
				return false;
		} else if (!User_Role.equals(other.User_Role))
			return false;
		if (User_Role_Id != other.User_Role_Id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ers_User_Roles [User_Role_Id=" + User_Role_Id + ", User_Role=" + User_Role + "]";
	}
	
	
}
