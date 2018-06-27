package br.model;

import java.io.Serializable;

public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8336522171528299447L;

	private int id;
	
	private String nome;
	
	private int estoque;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

}
