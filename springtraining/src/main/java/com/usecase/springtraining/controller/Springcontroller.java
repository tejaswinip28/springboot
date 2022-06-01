package com.usecase.springtraining.controller;


import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.usecase.springtraining.objects.client_det;
import com.usecase.springtraining.objects.reqserver;
import com.usecase.springtraining.objects.servresponse;
import com.usecase.springtraining.service.messageservice;
import com.usecase.springtraining.sqlexception.sqlexception;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/msgscheduling/")
public class Springcontroller {
	
	@RequestMapping("/home")
	String home() {
		return "home";
	}
    messageservice messageservice;
    
    @RequestMapping(value = "/ifvalid", method = RequestMethod.GET)
    public servresponse ifValid() {
    	return new servresponse("201", "sussesful!");
    }
    
    Logger logger = LoggerFactory.getLogger(Springcontroller.class);
    @RequestMapping(value = "/msgs", method = RequestMethod.POST)
    public servresponse Msgfunc(@RequestBody @Valid reqserver req, HttpServletRequest request) throws sqlexception {
    
    	servresponse servresponse = null;
    	try {
    		
    		servresponse = new servresponse("200", "sussesful msg schedule!");
    	}
    	catch (Exception e) {
    		client_det client_det = (client_det) request.getAttribute("client_det");
            logger.info("client_det: " + client_det);
            int result = messageservice.msgsaving(req, client_det);
            logger.info("ifsaved: " + result);
    		servresponse = new servresponse("405", "scheduling failed!");
    	}
    	return servresponse;
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    servresponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		
		FieldError fieldError = e.getBindingResult().getFieldErrors().get(0);
		String errorMessage =  fieldError.getDefaultMessage();
		servresponse servresponse = new servresponse("406",errorMessage);
		return servresponse;
	}
    
}
