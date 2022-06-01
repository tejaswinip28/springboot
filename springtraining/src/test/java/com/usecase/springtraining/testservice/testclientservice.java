package com.usecase.springtraining.testservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import com.usecase.springtraining.DAO.ClientDAO;
import com.usecase.springtraining.objects.client_det;
import com.usecase.springtraining.service.clientservice;

@SpringBootTest
public class testclientservice {

	@Autowired
	clientservice clientservice;
	
	@MockBean
	ClientDAO ClientDAO;
	
	@Test
	void checktoken()
	{
		client_det testcase;
		testcase = new client_det(1002, "name_2", "tokenno_2");
		when(ClientDAO.getClientdetWithToken("tokenno_2")).thenReturn(testcase);
        assertThat(clientservice.checktoken("tokenno_2")).isEqualTo(testcase);
	}
	
	@Test
	void checktokennotvalid()
	{
		when(ClientDAO.getClientdetWithToken("Token not valid")).thenReturn(null);
        assertThat(clientservice.checktoken("Token not valid")).isNull();
	}
	
}
