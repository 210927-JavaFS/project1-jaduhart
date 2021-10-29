package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ers_Reimb_Status {
	@Id
	private int Reimb_Status_Id;
	private String Reimb_Stat;
	
	
	public Ers_Reimb_Status(int reimb_Status_Id, String reimb_Stat) {
		super();
		Reimb_Status_Id = reimb_Status_Id;
		Reimb_Stat = reimb_Stat;
	}
	
	
	public Ers_Reimb_Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getReimb_Status_Id() {
		return Reimb_Status_Id;
	}
	public void setReimb_Status_Id(int reimb_Status_Id) {
		Reimb_Status_Id = reimb_Status_Id;
	}
	public String getReimb_Stat() {
		return Reimb_Stat;
	}
	public void setReimb_Stat(String reimb_Stat) {
		Reimb_Stat = reimb_Stat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Reimb_Stat == null) ? 0 : Reimb_Stat.hashCode());
		result = prime * result + Reimb_Status_Id;
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
		Ers_Reimb_Status other = (Ers_Reimb_Status) obj;
		if (Reimb_Stat == null) {
			if (other.Reimb_Stat != null)
				return false;
		} else if (!Reimb_Stat.equals(other.Reimb_Stat))
			return false;
		if (Reimb_Status_Id != other.Reimb_Status_Id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ers_Reimb_Status [Reimb_Status_Id=" + Reimb_Status_Id + ", Reimb_Stat=" + Reimb_Stat + "]";
	}
	
	
}
