package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.models.Ers_Reimbursement;
import com.revature.models.Ers_Users;
import com.revature.services.ErsReimbursementService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbursementController implements Controller {
	private ErsReimbursementService reimService = new ErsReimbursementService();

	public Handler getAllReim = (ctx) -> {
		List<Ers_Reimbursement> list = reimService.findAllReim();

		ctx.json(list);
		ctx.status(200);
	};

	public Handler getReim = (ctx) -> {
		try {
			String idString = ctx.pathParam("Ers_Reimbursement");
			int id = Integer.parseInt(idString);
			Ers_Reimbursement reim = reimService.findReimById(id);
			ctx.json(reim);
			ctx.status(200);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			ctx.status(406);
		}
	};

	public Handler addReim = (ctx) -> {
		Ers_Reimbursement reim = ctx.bodyAsClass(Ers_Reimbursement.class);
		HttpSession userSess = ctx.req.getSession(false);
		Ers_Users curUser = (Ers_Users) userSess.getAttribute("user");
		System.err.println(curUser);
		reim.setReimb_Auth(curUser);
		System.err.println(reim);
		if (reimService.addReim(reim)) {
			ctx.status(201);
		} else {
			ctx.status(400);
		}
	};

	public Handler updateReim = (ctx) -> {
		Ers_Reimbursement reim = ctx.bodyAsClass(Ers_Reimbursement.class);
		HttpSession userSess = ctx.req.getSession(false);
		Ers_Users curUser = (Ers_Users) userSess.getAttribute("user");
		System.err.println(curUser);
		reim.setReimb_Res(curUser);
		//not trying to add but cupdate, but idk how to mention the parameters
		if (reimService.updateReim(reim)) {
			ctx.status(200);
		} else {
			ctx.status(400);
		}
	};

//	public Handler deleteAvenger = (ctx) -> {
//		String id = ctx.pathParam("avenger");
//		try {
//			int avenger = Integer.parseInt(id);
//			if (avengerService.deleteAvenger(avenger)) {
//				ctx.status(200);
//			} else {
//				ctx.status(400);
//			}
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//			ctx.status(406);
//		}
	//};
	public Handler getAllReimPen = (ctx) -> {
		String statId = ctx.pathParam("statId");
		int statInt = Integer.parseInt(statId);

		List<Ers_Reimbursement> list = reimService.allReimByStat(statInt);

		ctx.json(list);
		ctx.status(200);
	};

	public Handler getAllUserReim = (ctx) -> {
		String userId = ctx.pathParam("userId");
		//int statInt = Integer.parseInt(userId);

		List<Ers_Reimbursement> list = reimService.getPastReim(userId);

		ctx.json(list);
		ctx.status(200);
	};
	@Override
	public void addRoutes(Javalin app) {
		app.get("/Ers_Reimbursement", this.getAllReim);
		app.get("/Ers_Reimbursement/:Ers_Reimbursement", this.getReim);
		app.post("/Ers_Reimbursement", this.addReim);
		app.put("/Ers_Reimbursement", this.updateReim);
		app.get("/Ers_Reimbursement/Open/:statId", this.getAllReimPen);
		app.get("/Ers_Reimbursement/Open/:userId", this.getAllUserReim);

	}

}
