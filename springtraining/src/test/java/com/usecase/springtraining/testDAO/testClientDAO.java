package com.usecase.springtraining.testDAO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import com.usecase.springtraining.DAO.ClientDAO;
import com.usecase.springtraining.objects.client_det;

@SpringBootTest
public class testClientDAO {
	@Autowired
	ClientDAO ClientDAO;
	
	@Test 
	void getClientdetWithToken()  {
		  client_det testcase = new client_det(1002, "name_2", "tokenno_2");
	      client_det usingclient_det = ClientDAO.getClientdetWithToken("tokenno_2");
		  assertThat(usingclient_det.toString()).isEqualTo(testcase.toString());
	 }
	
	@Test
	void getClientdetWithTokennotvalid() {
		  client_det usingclient_det = null;
		  try {
		        usingclient_det = ClientDAO.getClientdetWithToken("Token not valid");
		        System.out.println("usingclient_det: " + usingclient_det);
		  }  
		  catch (Exception e) {
		            assertThat(usingclient_det).isEqualTo(null);
		  }
	}

}
