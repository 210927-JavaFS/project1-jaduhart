package com.revature.models;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ers_Reimb_Type {
	@Id
	private int Reimb_Type_Id;
	private String Reimb_Type;
	public Ers_Reimb_Type(int reimb_Type_Id, String reimb_Type) {
		super();
		Reimb_Type_Id = reimb_Type_Id;
		Reimb_Type = reimb_Type;
	}
	public Ers_Reimb_Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReimb_Type_Id() {
		return Reimb_Type_Id;
	}
	public void setReimb_Type_Id(int reimb_Type_Id) {
		Reimb_Type_Id = reimb_Type_Id;
	}
	public String getReimb_Type() {
		return Reimb_Type;
	}
	public void setReimb_Type(String reimb_Type) {
		Reimb_Type = reimb_Type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Reimb_Type == null) ? 0 : Reimb_Type.hashCode());
		result = prime * result + Reimb_Type_Id;
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
		Ers_Reimb_Type other = (Ers_Reimb_Type) obj;
		if (Reimb_Type == null) {
			if (other.Reimb_Type != null)
				return false;
		} else if (!Reimb_Type.equals(other.Reimb_Type))
			return false;
		if (Reimb_Type_Id != other.Reimb_Type_Id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ers_Reimb_Type [Reimb_Type_Id=" + Reimb_Type_Id + ", Reimb_Type=" + Reimb_Type + "]";
	}
	
	
}
