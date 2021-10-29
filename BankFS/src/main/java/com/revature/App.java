package com.revature;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.Insert;

import com.revature.controllers.Controller;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.models.Ers_Reimb_Status;
import com.revature.models.Ers_Reimb_Type;
import com.revature.models.Ers_Reimbursement;
import com.revature.models.Ers_User_Roles;
import com.revature.models.Ers_Users;
import com.revature.utils.HibUtil;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
	
	private static Javalin app;

	public static void main(String[] args) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		Ers_User_Roles userRole1 = new Ers_User_Roles(1,"Finance Manager");
		Ers_Users ers_User1 = new Ers_Users("User1","password1", "John", "Doe", "jodoe@email.com", userRole1 );
		Ers_User_Roles userRole2 = new Ers_User_Roles(2,"Employee");
		Ers_Users ers_User2 = new Ers_Users("User2","password2", "Jan", "Doe", "jadoe@email.com", userRole2 );
		Ers_User_Roles userRole3 = new Ers_User_Roles(1,"Finance Manager");
		Ers_Users ers_User3 = new Ers_Users("User3","password3", "Rosa", "Diaz", "rodiaz@email.com", userRole3 );
		Ers_User_Roles userRole4 = new Ers_User_Roles(2,"Employee");
		Ers_Users ers_User4 = new Ers_Users("User4","password4", "Juan", "Diaz", "judiaz@email.com", userRole4 );
		
		Ers_Reimb_Type type1 = new Ers_Reimb_Type(1, "LODGING");
		Ers_Reimb_Status stat1 = new Ers_Reimb_Status(1,"PENDING");
		Ers_Reimbursement Reimb1 = new Ers_Reimbursement(100,ts,ts,"Great Wolf", ers_User1, ers_User1, stat1, type1);
//		
//		Ers_Reimb_Type type2 = new Ers_Reimb_Type(2, "TRAVEL");
//		Ers_Reimb_Status stat2 = new Ers_Reimb_Status(2,"APPROVED");
//		Ers_Reimbursement Reimb2 = new Ers_Reimbursement(200,ts,ts,"Aguadilla", ers_User2, ers_User1, stat2, type2);
//		
//		Ers_Reimb_Type type3 = new Ers_Reimb_Type(3, "FOOD");
//		Ers_Reimb_Status stat3 = new Ers_Reimb_Status(3,"DENIED");
//		Ers_Reimbursement Reimb3 = new Ers_Reimbursement(300,ts,ts,"Chillis", ers_User3, ers_User3, stat3, type3);
//		
//		Ers_Reimb_Type type4 = new Ers_Reimb_Type(4, "OTHER");
//		Ers_Reimb_Status stat4 = new Ers_Reimb_Status(1,"PENDING");
//		Ers_Reimbursement Reimb4 = new Ers_Reimbursement(400,ts,ts,"Metal Box", ers_User4, ers_User3, stat4, type4);
//		
		insert(userRole1);
		insert(ers_User1);
		insert(type1);
		insert(stat1);
		insert(Reimb1);
		
		app = Javalin.create((config)->{
			config.addStaticFiles("/static", Location.CLASSPATH);
		});
		
		configure(new ReimbursementController(), new UserController());
		
		app.start(8081);

	}
	
	private static void configure(Controller... controllers) {
		for(Controller c:controllers) {
			c.addRoutes(app);
		}
	}
	private static void insert(Ers_Users ersUser) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(ersUser);
		System.out.println(obj);
		tx.commit();
		HibUtil.closeSession();
	}
	private static void insert(Ers_User_Roles ersUser) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(ersUser);
		System.out.println(obj);
		tx.commit();
		HibUtil.closeSession();
	}
	private static void insert(Ers_Reimbursement ersReim) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(ersReim);
		//System.out.println(obj);
		tx.commit();
		HibUtil.closeSession();
	}
	private static void insert(Ers_Reimb_Type ersReim) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(ersReim);
		System.out.println(obj);
		tx.commit();
		HibUtil.closeSession();
	}
	private static void insert(Ers_Reimb_Status ersReim) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(ersReim);
		System.out.println(obj);
		tx.commit();
		HibUtil.closeSession();
	}
}