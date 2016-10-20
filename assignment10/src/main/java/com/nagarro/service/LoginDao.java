package com.nagarro.service;

import java.util.List;

import com.nagarro.model.LoginModel;
import com.nagarro.model.RegisterModel;

public interface LoginDao {
	List<RegisterModel> findUser(LoginModel loginUser);

}
