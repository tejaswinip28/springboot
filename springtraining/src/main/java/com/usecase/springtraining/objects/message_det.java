package com.usecase.springtraining.objects;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter 
@NoArgsConstructor
@AllArgsConstructor
public class message_det {
	
	private int msg_id;
	private int c_id;
	private String whatsapp_id;
	private String message;
	private String phno;
	private String created;
	private String scheduled;
	private String sent;
	private boolean scheduledStatus;
	private boolean sentStatus;
	
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getWhatsapp_id() {
		return whatsapp_id;
	}
	public void setWhatsapp_id(String whatsapp_id) {
		this.whatsapp_id = whatsapp_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getScheduled() {
		return scheduled;
	}
	public void setScheduled(String scheduled) {
		this.scheduled = scheduled;
	}
	public String getSent() {
		return sent;
	}
	public void setSent(String sent) {
		this.sent = sent;
	}
	public boolean isScheduledStatus() {
		return scheduledStatus;
	}
	public void setScheduledStatus(boolean scheduledStatus) {
		this.scheduledStatus = scheduledStatus;
	}
	public boolean isSentStatus() {
		return sentStatus;
	}
	public void setSentStatus(boolean sentStatus) {
		this.sentStatus = sentStatus;
	}
	@Override
	public String toString() {
		return "message_det [msg_id=" + msg_id + ", c_id=" + c_id + ", whatsapp_id=" + whatsapp_id + ", message="
				+ message + ", phno=" + phno + ", created=" + created + ", scheduled=" + scheduled + ", sent=" + sent
				+ ", scheduledStatus=" + scheduledStatus + ", sentStatus=" + sentStatus + "]";
	}
	public message_det(int msg_id, int c_id, String whatsapp_id, String message, String phno, String created,
			String scheduled, String sent, boolean scheduledStatus, boolean sentStatus) {
		super();
		this.msg_id = msg_id;
		this.c_id = c_id;
		this.whatsapp_id = whatsapp_id;
		this.message = message;
		this.phno = phno;
		this.created = created;
		this.scheduled = scheduled;
		this.sent = sent;
		this.scheduledStatus = scheduledStatus;
		this.sentStatus = sentStatus;
	}
	
	public message_det() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean tobesent;
	public boolean isTobesent() {
		return tobesent;
	}
	public void setTobesent(boolean tobesent) {
		this.tobesent = tobesent;
	}
	
	public client_det checktoken() {
		return null;
	}

}
