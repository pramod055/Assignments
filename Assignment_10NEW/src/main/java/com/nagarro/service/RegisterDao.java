package com.nagarro.service;

import java.util.List;

import com.nagarro.model.RegisterModel;

public interface RegisterDao {
   
	 RegisterModel add(RegisterModel registermodel);
	 List<RegisterModel> loadAll();
	 List<RegisterModel> checkUser(RegisterModel registermodel);
	
	
}
