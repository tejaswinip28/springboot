package com.usecase.springtraining.testservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.usecase.springtraining.service.messageservice;
import com.usecase.springtraining.sqlexception.sqlexception;

import java.util.Collections;
import java.util.List;
import com.usecase.springtraining.DAO.MessageDAO;
import com.usecase.springtraining.objects.client_det;
import com.usecase.springtraining.objects.message_det;
import com.usecase.springtraining.objects.reqserver;

@SpringBootTest
public class testmessageservice {
	@Autowired
	messageservice messageservice;
	
	@MockBean
	MessageDAO MessageDAO;
	
	@Test
    void msgsaving() throws sqlexception {
        client_det testcase;
        testcase = new client_det(1002, "name_1", "token_1");
        reqserver req = new reqserver("first message", "8106792389", "2022-05-30T12:35:00");
        when(MessageDAO.save(req, testcase)).thenReturn(1);
        assertThat(messageservice.msgsaving(req, testcase)).isEqualTo(1);
    }
	
	@Test
    void MsgStatusUpd() {
        when(MessageDAO.MsgStatusUpd(anyInt(), any(), any(), any(), any())).thenReturn(1);
        assertEquals(1, (int) (messageservice.MsgStatusUpd(anyInt(), any(), any(), any(), any())));
    }
	
	@Test
    void polling() throws sqlexception {
        List<message_det> firstlist = Collections.emptyList();
        List<message_det> secondlist = messageservice.polling();
        when(MessageDAO.getAlltheMessages()).thenReturn(firstlist);
        assertThat(secondlist.size()).isEqualTo(firstlist.size());
    }

}
