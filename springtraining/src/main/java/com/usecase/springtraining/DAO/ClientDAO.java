package com.usecase.springtraining.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usecase.springtraining.RowMapper.ClientRowMapper;
import com.usecase.springtraining.objects.client_det;

@Repository
public class ClientDAO {
	
	@Autowired
	JdbcTemplate template;
	
	public client_det getClientdetWithToken(String token) {
        client_det client_det = null;
        try {
        	client_det = (com.usecase.springtraining.objects.client_det) template.queryForObject("select * from client where token = ?", new ClientRowMapper(), token);
            System.out.println("query: " + "select * from client where token= ?");
            System.out.println("obtained result: " + client_det.toString());
            return client_det;
        } catch (Exception e) {
            return null;
        }

    }
	
}
