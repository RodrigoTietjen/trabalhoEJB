package br.model;

import java.io.Serializable;

public class ProdutoCarrinho implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7861723784456963840L;

	private int id;

	private String nome;
	
	private int quantidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
