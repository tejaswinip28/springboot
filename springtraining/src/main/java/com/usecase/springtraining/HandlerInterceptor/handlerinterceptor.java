package com.usecase.springtraining.HandlerInterceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usecase.springtraining.objects.client_det;
import com.usecase.springtraining.objects.servresponse;
import com.usecase.springtraining.service.clientservice;

@Component
public class handlerinterceptor implements HandlerInterceptor {

	@Autowired
	clientservice clientservice;
	@Override
	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String token;
	       token = request.getHeader("token");
	        System.out.println("token as header " + token);
	        client_det client_det = clientservice.checktoken(token);
	        if(client_det == null) 
	        {
	        	System.out.println("Authentication fail!");
	        	response.setContentType("application/json");
	            response.setStatus(400);
	            PrintWriter out = response.getWriter();
	            servresponse resp = new servresponse("500", "Authentication failed");
	            String responseString = new ObjectMapper().writeValueAsString(resp);
	            out.print(responseString);
	            return false;
	        }
	        
	        System.out.println(client_det);
	        request.setAttribute("client_det", client_det);
	      return true;
	   }
	   /*
	    * @Override
	    
	   public void postHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception {
		   
	   }
	   
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, Exception exception) throws Exception {
		   
	   }
	   */
}
