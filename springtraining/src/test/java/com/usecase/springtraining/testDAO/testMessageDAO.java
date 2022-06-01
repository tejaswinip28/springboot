package com.usecase.springtraining.testDAO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import com.usecase.springtraining.DAO.MessageDAO;
import com.usecase.springtraining.objects.client_det;
import com.usecase.springtraining.objects.reqserver;
import com.usecase.springtraining.sqlexception.sqlexception;

@SpringBootTest
public class testMessageDAO {

	@Autowired
	MessageDAO MessageDAO;
	
	 @Test
	 void insertMessage() throws sqlexception {
	        client_det testcase = new client_det(1002,"name_2", "tokenno_2");
	        reqserver req = new reqserver("test message", "8106792389", "2022-06-01T13:47:20");
	        int actualResult = MessageDAO.save(req,testcase);
	        assertThat(actualResult).isEqualTo(1);
	    }

		@Test
	    void MsgStatusUpd() throws sqlexception {
	       int actualResult =  MessageDAO.MsgStatusUpd(1,false,true,"whatsapp_id", LocalDateTime.now());
	       assertThat(actualResult).isEqualTo(1);
	    }
	 
	 
}
