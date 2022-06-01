package com.usecase.springtraining.DAO;

import java.time.LocalDateTime;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usecase.springtraining.RowMapper.MessageRowMapper;
import com.usecase.springtraining.objects.client_det;
import com.usecase.springtraining.objects.message_det;
import com.usecase.springtraining.objects.reqserver;
import com.usecase.springtraining.sqlexception.sqlexception;

@Component
public class MessageDAO {
	@Autowired
	JdbcTemplate template;
	
	Logger logger = LoggerFactory.getLogger(MessageDAO.class);
	
	public int save(reqserver req,client_det client_det) throws sqlexception  {
		int message = 0;
		try {
			String query = "insert into message (message,scheduled,phno,c_id,created,tobesent,scheduledStatus) values (?,?,?,?,?,?,?)";
			message = template.update(query, req.getMessage(), req.getTimeofsched(),
					req.getPh_numb(), client_det.getC_id(), LocalDateTime.now(), true,true);
			return message;
		} 
		catch (Exception e) {
			throw new sqlexception("error with sql operation!");
		}

	}

	public int MsgStatusUpd(int msg_id, boolean tobesent, boolean sentStatus, String whatsapp_id,LocalDateTime sent){

		System.out.println("Msg status updation with msg_id " + msg_id);
		int message = 0;
		try
		{
			message = template.update("update message set sent=?, tobesent = ?, sentStatus=?, whatsapp_id=? where msg_id = ?",sent,tobesent,sentStatus,whatsapp_id,msg_id);
			return message;
		}catch (Exception e){
			return 0;
		}
		
	}
	public List<message_det> getAlltheMessages() throws sqlexception {

	       List<message_det> message = Collections.emptyList();
	       logger.info("msg polling at " + LocalDateTime.now());
	       try {
	           message = template.query("select * from message where scheduled < now() and tobesent = true", new MessageRowMapper());
	           return message;
	       } 
	       catch (Exception e) {
	    	   throw new sqlexception("error with polling messages!");
	       }
	       
	   }
}