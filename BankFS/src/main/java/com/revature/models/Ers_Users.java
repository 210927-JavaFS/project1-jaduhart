package com.revature.models;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ers_Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int User_Id;
	@Column (unique = true)
	private String Username;
	private String Password;
	private String First_Name;	
	private String Last_Name;
	@Column (unique = true)
	private String Email;
	@ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Role_Id")
	private Ers_User_Roles User_Role;
	
	
	
	public Ers_Users(int user_Id, String username, String password, String first_Name, String last_Name, String email,
			Ers_User_Roles user_Role) {
		super();
		User_Id = user_Id;
		Username = username;
		Password = password;
		First_Name = first_Name;
		Last_Name = last_Name;
		Email = email;
		User_Role = user_Role;
	}
	
	
	
	public Ers_Users(String username, String password, String first_Name, String last_Name, String email,
			Ers_User_Roles user_Role) {
		super();
		Username = username;
		Password = password;
		First_Name = first_Name;
		Last_Name = last_Name;
		Email = email;
		User_Role = user_Role;
	}

	

	public Ers_Users() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Ers_User_Roles getUser_Role() {
		return User_Role;
	}
	public void setUser_Role(Ers_User_Roles user_Role) {
		User_Role = user_Role;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((First_Name == null) ? 0 : First_Name.hashCode());
		result = prime * result + ((Last_Name == null) ? 0 : Last_Name.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + User_Id;
		result = prime * result + ((User_Role == null) ? 0 : User_Role.hashCode());
		result = prime * result + ((Username == null) ? 0 : Username.hashCode());
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
		Ers_Users other = (Ers_Users) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (First_Name == null) {
			if (other.First_Name != null)
				return false;
		} else if (!First_Name.equals(other.First_Name))
			return false;
		if (Last_Name == null) {
			if (other.Last_Name != null)
				return false;
		} else if (!Last_Name.equals(other.Last_Name))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (User_Id != other.User_Id)
			return false;
		if (User_Role == null) {
			if (other.User_Role != null)
				return false;
		} else if (!User_Role.equals(other.User_Role))
			return false;
		if (Username == null) {
			if (other.Username != null)
				return false;
		} else if (!Username.equals(other.Username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Ers_Users [User_Id=" + User_Id + ", Username=" + Username + ", Password=" + Password + ", First_Name="
				+ First_Name + ", Last_Name=" + Last_Name + ", Email=" + Email + ", User_Role=" + User_Role + "]";
	}

	
	
}
