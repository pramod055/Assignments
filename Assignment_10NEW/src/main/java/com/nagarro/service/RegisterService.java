package com.nagarro.service;

import java.util.List;

import com.nagarro.model.RegisterModel;

public interface RegisterService {

	RegisterModel add(RegisterModel registermodel);
	List<RegisterModel> findAllUsers();
	boolean validateUser(RegisterModel registermodel);
}
