
	package com.revature.models;

	import java.util.Objects;

	public class LoginDTO {
	    private String username;
	    private String password;

	    public LoginDTO(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    public LoginDTO() {
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        LoginDTO loginDTO = (LoginDTO) o;
	        return Objects.equals(username, loginDTO.username) && Objects.equals(password, loginDTO.password);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(username, password);
	    }

	    @Override
	    public String toString() {
	        return "UserDTO{" +
	                "username='" + username + '\'' +
	                ", password='" + password + '\'' +
	                '}';
	    }
	}

