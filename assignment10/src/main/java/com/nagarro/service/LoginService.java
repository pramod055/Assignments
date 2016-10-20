package com.nagarro.service;

import com.nagarro.model.LoginModel;

public interface LoginService {
	boolean validateUser(LoginModel login);
}
