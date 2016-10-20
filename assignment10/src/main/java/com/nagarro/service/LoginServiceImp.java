package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.LoginModel;
import com.nagarro.model.RegisterModel;
@Service("LoginService")
public class LoginServiceImp implements LoginService {


	@Autowired
	private LoginDao loginDao;
	@Transactional
	public boolean validateUser(LoginModel loginUser) {
		List<RegisterModel> users = loginDao.findUser(loginUser);
		if(users.size() !=0){
				if(users.get(0).getPassword().equals(loginUser.getPassword())){
					return true;
				}
			}
		return false;
	}
}





