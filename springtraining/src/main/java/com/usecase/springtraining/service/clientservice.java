package com.usecase.springtraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.springtraining.objects.client_det;
import com.usecase.springtraining.DAO.ClientDAO;

@Service
public class clientservice {

	@Autowired
	ClientDAO ClientDAO;
	
	public client_det checktoken(String token) {
		client_det client_det = ClientDAO.getClientdetWithToken(token);
		return client_det;
	}
}
