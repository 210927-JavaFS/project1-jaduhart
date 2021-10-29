package com.revature.controllers;

import java.util.List;

import com.revature.models.Ers_Users;
import com.revature.services.ErsUserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController implements Controller {
private ErsUserService userService = new ErsUserService();
	
	public Handler getAllUsers = (ctx) -> {
		List<Ers_Users> list = userService.findAllUsers();
		
		ctx.json(list);
		ctx.status(200);
	};

//	public Handler getUser = (ctx)->{
//		Ers_Users ers_Users = userService.findUserById(Integer.parseInt(ctx.pathParam("ers_Users")));
//		ctx.json(ers_Users);
//		ctx.status(200);
//	};
	

	public Handler getUser = (ctx)->{
		
		try {
			
		
			Ers_Users ers_Users = userService.findUserById(Integer.parseInt(ctx.pathParam("ers_Users")));
			ctx.json(ers_Users);
			ctx.status(200);
			}catch(NumberFormatException e) {
				e.printStackTrace();
				ctx.status(406);
			}
		};
	
//	public Handler addErs_Users = (ctx)->{
//		Ers_Users ers_Users = ctx.bodyAsClass(Ers_Users.class);
//		if(userService.findAllUsers(ers_Users)) {
//			ctx.status(201);
//		}else {
//			ctx.status(400);
//		}
//	};
//	
//	public Handler updateErs_Users = (ctx)->{
//		Ers_Users ers_Users = ctx.bodyAsClass(Ers_Users.class);
//		if(userService.updateErs_Users(ers_Users)) {
//			ctx.status(200);
//		}else {
//			ctx.status(400);
//		}
//	};
//	
//	public Handler deleteErs_Users = (ctx)->{
//		String ers_Users = ctx.pathParam("ers_Users");
//		if(ers_UsersService.deleteErs_Users(ers_Users)) {
//			ctx.status(200);
//		}else {
//			ctx.status(400);
//		}
//	};
	
	@Override
	public void addRoutes(Javalin app) {
		app.get("/users", this.getAllUsers);
		app.get("/users/:Users", this.getUser);
//		app.post("/ers_Userss", this.addErs_Users);
//		app.put("/ers_Userss", this.updateErs_Users);
//		app.delete("/ers_Userss/:ers_Users", this.deleteErs_Users);
	}

	
}

