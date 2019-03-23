package br.com.chat.entidade;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Pedido {

	@Id
	@SequenceGenerator(name = "pedido_id_seq", sequenceName = "chat.pedido_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_id_seq")
	private int id;
	private String descricao;
	private String dt_compra;
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_produto")
	private Produto produto;

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

	public String getDt_compra() {
		return dt_compra;
	}

	public void setDt_compra(String dt_compra) {
		this.dt_compra = dt_compra;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
