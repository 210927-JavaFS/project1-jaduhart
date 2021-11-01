
   
package com.revature.services;

import com.revature.models.Ers_Users;
import com.revature.models.LoginDTO;
import com.revature.DAOs.UserDAO;
import com.revature.DAOs.UserDAOImp;

public class LoginService {

    private UserDAO userDAO = new UserDAOImp();

    public Ers_Users login(LoginDTO loginDTO) {
        Ers_Users user = userDAO.getUserByName(loginDTO.getUsername());
        String password = loginDTO.getPassword();
        if (user != null && password == user.getPassword()) {
            return user;
        }
        return null;
    }
}