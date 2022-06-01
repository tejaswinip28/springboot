package com.usecase.springtraining.testcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usecase.springtraining.objects.client_det;
import com.usecase.springtraining.objects.reqserver;
import com.usecase.springtraining.objects.servresponse;
import com.usecase.springtraining.service.clientservice;
import com.usecase.springtraining.service.messageservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class testcontroller {
	
	@MockBean
    clientservice clientservice;
	
	@MockBean
    messageservice messageservice;
	
	@Autowired
    private MockMvc mvc;
	
	@Test
    void authentication() throws Exception {
        reqserver req = new reqserver("message to be sent", "8106792389", "2022-05-31T12:08:20");
        System.out.println("Result: " + mvc.perform(post("/msgscheduling/msgs").contentType(MediaType.APPLICATION_JSON_VALUE).content(new ObjectMapper().writeValueAsString(req)).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andReturn().toString());
        System.out.println("Response String is: " + mvc.perform(post("/msgscheduling/msgs").contentType(MediaType.APPLICATION_JSON_VALUE).content(new ObjectMapper().writeValueAsString(req)).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andReturn().getResponse().getContentAsString());
        servresponse resp = new ObjectMapper().readValue(mvc.perform(post("/msgscheduling/msgs").contentType(MediaType.APPLICATION_JSON_VALUE).content(new ObjectMapper().writeValueAsString(req)).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andReturn().getResponse().getContentAsString(), servresponse.class);
        System.out.println(resp.toString());
        assertThat(resp.getResp_code()).isEqualTo("500");
    }
	
	@Test
    void checkmsg() throws Exception {
        client_det testcase = new client_det(1002, "name_2", "tokenno_2");
        when(clientservice.checktoken("tokenno_2")).thenReturn(testcase);
        reqserver req = new reqserver("message to be sent", "8106792389", "2022-05-31Notvalid");
        System.out.println("Result: " + mvc.perform(post("/msgscheduling/msgs").contentType(MediaType.APPLICATION_JSON_VALUE).header("token", "tokenno_2").content(new ObjectMapper().writeValueAsString(req)).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn().toString());
        System.out.println("Response String is: " + mvc.perform(post("/msgscheduling/msgs").contentType(MediaType.APPLICATION_JSON_VALUE).header("token", "tokenno_2").content(new ObjectMapper().writeValueAsString(req)).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
        servresponse resp = new ObjectMapper().readValue(mvc.perform(post("/msgscheduling/msgs").contentType(MediaType.APPLICATION_JSON_VALUE).header("token", "tokenno_2").content(new ObjectMapper().writeValueAsString(req)).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), servresponse.class);
        assertThat(resp.getResp_code()).isEqualTo("406");
        assertThat(resp.getMessage() == "message should not be empty");
    }

}
