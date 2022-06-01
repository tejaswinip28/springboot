package com.usecase.springtraining.ScheduleTImer;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usecase.springtraining.objects.message_det;
import com.usecase.springtraining.service.messageservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Component
public class TaskSchedule extends TimerTask {

	@Autowired
	messageservice messageservice;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<message_det> message = null; 
		System.out.println("Every minute TimerTask is called");
		
		try {
		message = messageservice.polling();
		}
		catch (Exception e) {
			 return;
		}
		Gson g = new Gson();
		for(message_det msg_det : message)
		{
			System.out.println("msg_id: " + msg_det.getMsg_id());
			try {
				URL Url = new URL("https://api.gupshup.io/sm/api/v1/msg");
				HttpURLConnection Httpconn = (HttpURLConnection) Url.openConnection();
				Httpconn.setDoInput(true);
				Httpconn.setDoOutput(true);
				//Httpconn.setConnectTimeout( 20000 ); 
				//Httpconn.setReadTimeout( 20000 );
				Httpconn.setUseCaches (false);
				//Httpconn.setDefaultUseCaches (false);
				Httpconn.setRequestProperty("Accept", "application/json");
				Httpconn.setRequestProperty ("Content-Type", "application/x-www-form-urlencoded");
				Httpconn.setRequestProperty("apikey", "fbxjmvbbkimxullzduoom0wpe7cobesf");
				Httpconn.setRequestMethod("POST");
				OutputStream writer = Httpconn.getOutputStream();
				HashMap<Object, Object> DMETimeOuts = new HashMap<>();
				DMETimeOuts.put("type", "text");
				DMETimeOuts.put("text", msg_det.getMessage());
				String str = g.toJson(DMETimeOuts);
				JsonObject jsonObject = JsonParser.parseString(str).getAsJsonObject();
				HashMap<Object, Object> keys = new HashMap<>();
				keys.put("channel", "whatsapp");
				keys.put("source", "917834811114");
				keys.put("src.name", "WhatsappTP");
				keys.put("destination","91" + msg_det.getPhno());
				keys.put("message", jsonObject);
				keys.put("disablePreview", "true");
				StringBuilder stringBuilder = new StringBuilder();
				for (HashMap.Entry<Object, Object> param : keys.entrySet()) 
				{
					if ( stringBuilder.length() != 0)  stringBuilder.append('&');
					stringBuilder.append(URLEncoder.encode((String) param.getKey(), "UTF-8"));
					stringBuilder.append('=');
					stringBuilder.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
				}
				//PrintWriter writer = new PrintWriter(Httpconn.getOutputStream());
				writer.write(stringBuilder.toString().getBytes("UTF-8"));
				System.out.println("write: " + writer.toString() + "resp code: " + Httpconn.getResponseCode());
				
				if (Httpconn.getResponseCode() != HttpURLConnection.HTTP_ACCEPTED) 
				{
					System.out.println("Status updation done: " + messageservice.MsgStatusUpd(msg_det.getMsg_id(),false,false, null,null));
					System.out.println("Failed to send message with msg_id " + msg_det.getMsg_id());
				}
				else
				{
					ObjectMapper objectMapper = new ObjectMapper();
					@SuppressWarnings("unchecked")
					HashMap<Object, Object> response = objectMapper.readValue(Httpconn.getInputStream(), HashMap.class);
					System.out.println("whatsapp_id:  " + response.get("whatsapp_id") + response.toString());
					if(messageservice.MsgStatusUpd(msg_det.getMsg_id(),false,true, (String) response.get("whatsapp_id"),LocalDateTime.now()) >= 1)
					  System.out.println("Status updation done: "+ messageservice.MsgStatusUpd(msg_det.getMsg_id(),false,true, (String) response.get("whatsapp_id"),LocalDateTime.now()));
					else System.out.println("Couldn't update status");
				} 
				
			} 
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}