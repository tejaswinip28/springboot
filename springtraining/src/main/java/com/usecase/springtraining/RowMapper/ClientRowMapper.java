package com.usecase.springtraining.RowMapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.usecase.springtraining.objects.client_det;

public class ClientRowMapper implements RowMapper <client_det> {
	
	
	@Override
	public client_det mapRow(ResultSet rs, int rownumber) throws SQLException {  
		client_det e = new client_det();  
        e.setC_id(rs.getInt("c_id"));  
        e.setName(rs.getString("name"));  
        e.setToken(rs.getString("token"));  
        return e;  
    }

	

}
