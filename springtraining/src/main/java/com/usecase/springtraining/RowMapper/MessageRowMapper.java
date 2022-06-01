package com.usecase.springtraining.RowMapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.usecase.springtraining.objects.message_det;


public class MessageRowMapper implements RowMapper <message_det> {

	@Override
	public message_det mapRow(ResultSet rs, int rownumber) throws SQLException {  
		message_det e = new message_det();  
        e.setMsg_id(rs.getInt("msg_id"));  
        e.setC_id(rs.getInt("c_id"));  
        e.setWhatsapp_id(rs.getString("whatsapp_id"));
        e.setMessage(rs.getString("message"));
        e.setPhno(rs.getString("phno"));
        e.setCreated(rs.getString("created"));
        e.setScheduled(rs.getString("scheduled"));
        e.setSent(rs.getString("sent"));
        e.setScheduledStatus(rs.getBoolean("scheduledStatus"));
        e.setSentStatus(rs.getBoolean("sentStatus"));
        e.setTobesent(rs.getBoolean("tobesent"));
        
        return e;  
    }

	 
}
