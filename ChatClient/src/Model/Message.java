package Model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{

	private String message;
	private String ID_sender;
	
	public Message(String message, String iD_sender) {
		super();
		this.message = message;
		ID_sender = iD_sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getID_sender() {
		return ID_sender;
	}
	public void setID_sender(String iD_sender) {
		ID_sender = iD_sender;
	}
    
}
