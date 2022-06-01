package com.usecase.springtraining.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.springtraining.DAO.MessageDAO;
import com.usecase.springtraining.objects.client_det;
import com.usecase.springtraining.objects.message_det;
import com.usecase.springtraining.objects.reqserver;
import com.usecase.springtraining.sqlexception.sqlexception;

@Service
public class messageservice {
	
	@Autowired
	MessageDAO MessageDAO;

	public messageservice(MessageDAO MessageDAO) {
		this.MessageDAO = MessageDAO;
	}
	
	public int msgsaving(reqserver req, client_det client_det) throws sqlexception {
        return MessageDAO.save(req, client_det);
        
    }
	
	public int MsgStatusUpd(int msg_id, boolean tobesent, boolean sentStatus, String whatsapp_id,LocalDateTime sent) {
        return MessageDAO.MsgStatusUpd(msg_id,tobesent,sentStatus,whatsapp_id,sent);
    }
	
	public List<message_det> polling() throws sqlexception {
        return MessageDAO.getAlltheMessages();
    }
	
	public int save(@Valid reqserver req, client_det client_det) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
