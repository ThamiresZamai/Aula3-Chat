package br.com.chat.entidade;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Produto {
	@Id
	@SequenceGenerator(name = "produto_id_seq", sequenceName = "chat.produto_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_id_seq")
	private int id;
	
	private String descricao;
	private double valor;
	private String tipo;

	private static List<Produto> lstChat = new ArrayList<Produto>();

	public Produto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static List<Produto> getLstChat() {
		return lstChat;
	}

	public static void setLstChat(List<Produto> lstChat) {
		Produto.lstChat = lstChat;
	}

	

}
