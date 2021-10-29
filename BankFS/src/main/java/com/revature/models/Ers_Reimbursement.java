package com.revature.models;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ers_Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Reimb_Id;
	private int Reimb_Amt;
	//if i wanted to do the reciept image here , i'd need to create a data type for it to get saved on here
	private java.sql.Timestamp Reimb_Sub;
	private java.sql.Timestamp Reimb_Resd;
	private String Reimb_Des;	
	private Blob Reimb_Rec;
	@ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	//make these actual references to the new classes you just made rather than ints
	private Ers_Users Reimb_Auth;
	@ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id", insertable = false, updatable = false)
	private Ers_Users Reimb_Res;
	@ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Reimb_Status_Id")
	private Ers_Reimb_Status Reimb_StatId;
	@ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Reimb_Type_Id")
	private Ers_Reimb_Type Reimb_TypeId;
	
	
	
	public Ers_Reimbursement(int reimb_Id, int reimb_Amt, Timestamp reimb_Sub, Timestamp reimb_Resd, String reimb_Des,
			Blob reimb_Rec, Ers_Users reimb_Auth, Ers_Users reimb_Res, Ers_Reimb_Status reimb_StatId,
			Ers_Reimb_Type reimb_TypeId) {
		super();
		Reimb_Id = reimb_Id;
		Reimb_Amt = reimb_Amt;
		Reimb_Sub = reimb_Sub;
		Reimb_Resd = reimb_Resd;
		Reimb_Des = reimb_Des;
		Reimb_Rec = reimb_Rec;
		Reimb_Auth = reimb_Auth;
		Reimb_Res = reimb_Res;
		Reimb_StatId = reimb_StatId;
		Reimb_TypeId = reimb_TypeId;
	}
	
	
	public Ers_Reimbursement(int reimb_Amt, Timestamp reimb_Sub, Timestamp reimb_Resd, String reimb_Des, Blob reimb_Rec,
			Ers_Users reimb_Auth, Ers_Users reimb_Res, Ers_Reimb_Status reimb_StatId, Ers_Reimb_Type reimb_TypeId) {
		super();
		Reimb_Amt = reimb_Amt;
		Reimb_Sub = reimb_Sub;
		Reimb_Resd = reimb_Resd;
		Reimb_Des = reimb_Des;
		Reimb_Rec = reimb_Rec;
		Reimb_Auth = reimb_Auth;
		Reimb_Res = reimb_Res;
		Reimb_StatId = reimb_StatId;
		Reimb_TypeId = reimb_TypeId;
	}

	public Ers_Reimbursement(int reimb_Amt, Timestamp reimb_Sub, Timestamp reimb_Resd, String reimb_Des,
			Ers_Users reimb_Auth, Ers_Users reimb_Res, Ers_Reimb_Status reimb_StatId, Ers_Reimb_Type reimb_TypeId) {
		super();
		Reimb_Amt = reimb_Amt;
		Reimb_Sub = reimb_Sub;
		Reimb_Resd = reimb_Resd;
		Reimb_Des = reimb_Des;
		Reimb_Auth = reimb_Auth;
		Reimb_Res = reimb_Res;
		Reimb_StatId = reimb_StatId;
		Reimb_TypeId = reimb_TypeId;
	}


	public Ers_Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getReimb_Id() {
		return Reimb_Id;
	}
	public void setReimb_Id(int reimb_Id) {
		Reimb_Id = reimb_Id;
	}
	public int getReimb_Amt() {
		return Reimb_Amt;
	}
	public void setReimb_Amt(int reimb_Amt) {
		Reimb_Amt = reimb_Amt;
	}
	public java.sql.Timestamp getReimb_Sub() {
		return Reimb_Sub;
	}
	public void setReimb_Sub(java.sql.Timestamp reimb_Sub) {
		Reimb_Sub = reimb_Sub;
	}
	public java.sql.Timestamp getReimb_Resd() {
		return Reimb_Resd;
	}
	public void setReimb_Resd(java.sql.Timestamp reimb_Resd) {
		Reimb_Resd = reimb_Resd;
	}
	public String getReimb_Des() {
		return Reimb_Des;
	}
	public void setReimb_Des(String reimb_Des) {
		Reimb_Des = reimb_Des;
	}
	public Blob getReimb_Rec() {
		return Reimb_Rec;
	}
	public void setReimb_Rec(Blob reimb_Rec) {
		Reimb_Rec = reimb_Rec;
	}
	public Ers_Users getReimb_Auth() {
		return Reimb_Auth;
	}
	public void setReimb_Auth(Ers_Users reimb_Auth) {
		Reimb_Auth = reimb_Auth;
	}
	public Ers_Users getReimb_Res() {
		return Reimb_Res;
	}
	public void setReimb_Res(Ers_Users reimb_Res) {
		Reimb_Res = reimb_Res;
	}
	public Ers_Reimb_Status getReimb_StatId() {
		return Reimb_StatId;
	}
	public void setReimb_StatId(Ers_Reimb_Status reimb_StatId) {
		Reimb_StatId = reimb_StatId;
	}
	public Ers_Reimb_Type getReimb_TypeId() {
		return Reimb_TypeId;
	}
	public void setReimb_TypeId(Ers_Reimb_Type reimb_TypeId) {
		Reimb_TypeId = reimb_TypeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Reimb_Amt;
		result = prime * result + ((Reimb_Auth == null) ? 0 : Reimb_Auth.hashCode());
		result = prime * result + ((Reimb_Des == null) ? 0 : Reimb_Des.hashCode());
		result = prime * result + Reimb_Id;
		result = prime * result + ((Reimb_Rec == null) ? 0 : Reimb_Rec.hashCode());
		result = prime * result + ((Reimb_Res == null) ? 0 : Reimb_Res.hashCode());
		result = prime * result + ((Reimb_Resd == null) ? 0 : Reimb_Resd.hashCode());
		result = prime * result + ((Reimb_StatId == null) ? 0 : Reimb_StatId.hashCode());
		result = prime * result + ((Reimb_Sub == null) ? 0 : Reimb_Sub.hashCode());
		result = prime * result + ((Reimb_TypeId == null) ? 0 : Reimb_TypeId.hashCode());
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
		Ers_Reimbursement other = (Ers_Reimbursement) obj;
		if (Reimb_Amt != other.Reimb_Amt)
			return false;
		if (Reimb_Auth == null) {
			if (other.Reimb_Auth != null)
				return false;
		} else if (!Reimb_Auth.equals(other.Reimb_Auth))
			return false;
		if (Reimb_Des == null) {
			if (other.Reimb_Des != null)
				return false;
		} else if (!Reimb_Des.equals(other.Reimb_Des))
			return false;
		if (Reimb_Id != other.Reimb_Id)
			return false;
		if (Reimb_Rec == null) {
			if (other.Reimb_Rec != null)
				return false;
		} else if (!Reimb_Rec.equals(other.Reimb_Rec))
			return false;
		if (Reimb_Res == null) {
			if (other.Reimb_Res != null)
				return false;
		} else if (!Reimb_Res.equals(other.Reimb_Res))
			return false;
		if (Reimb_Resd == null) {
			if (other.Reimb_Resd != null)
				return false;
		} else if (!Reimb_Resd.equals(other.Reimb_Resd))
			return false;
		if (Reimb_StatId == null) {
			if (other.Reimb_StatId != null)
				return false;
		} else if (!Reimb_StatId.equals(other.Reimb_StatId))
			return false;
		if (Reimb_Sub == null) {
			if (other.Reimb_Sub != null)
				return false;
		} else if (!Reimb_Sub.equals(other.Reimb_Sub))
			return false;
		if (Reimb_TypeId == null) {
			if (other.Reimb_TypeId != null)
				return false;
		} else if (!Reimb_TypeId.equals(other.Reimb_TypeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ers_Reimbursement [Reimb_Id=" + Reimb_Id + ", Reimb_Amt=" + Reimb_Amt + ", Reimb_Sub=" + Reimb_Sub
				+ ", Reimb_Resd=" + Reimb_Resd + ", Reimb_Des=" + Reimb_Des + ", Reimb_Rec=" + Reimb_Rec
				+ ", Reimb_Auth=" + Reimb_Auth + ", Reimb_Res=" + Reimb_Res + ", Reimb_StatId=" + Reimb_StatId
				+ ", Reimb_TypeId=" + Reimb_TypeId + "]";
	}
	
	
	
}
