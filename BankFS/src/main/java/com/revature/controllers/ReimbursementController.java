package com.revature.controllers;

import java.util.List;

import com.revature.models.Ers_Reimbursement;
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
		if (reimService.addReim(reim)) {
			ctx.status(201);
		} else {
			ctx.status(400);
		}
	};

	public Handler updateReimb = (ctx) -> {
		Ers_Reimbursement reim = ctx.bodyAsClass(Ers_Reimbursement.class);
		
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

	@Override
	public void addRoutes(Javalin app) {
		app.get("/Ers_Reimbursement", this.getAllReim);
		app.get("/Ers_Reimbursement/:Ers_Reimbursement", this.getReim);
		app.post("/Ers_Reimbursement", this.addReim);

	}

}
