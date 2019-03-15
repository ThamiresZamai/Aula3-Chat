package br.com.chat.entidade;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Chat {
	@Id
	@SequenceGenerator(name = "chataula_id_seq", sequenceName = "chat.chataula_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chataula_id_seq")
	private int id;
	
	private String usuario;
	private String message;

	private static List<Chat> lstChat = new ArrayList<Chat>();

	public Chat() {
	}

	public Chat(String user, String message) {
		this.usuario=user;
		this.message=message;
	}

	public String getUser() {
		return usuario;
	}

	public void setUser(String user) {
		this.usuario = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static List<Chat> getLstMessage() {
		return lstChat;
	}

	public static void setLstMessage(List<Chat> lstMessage) {
		Chat.lstChat = lstChat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
