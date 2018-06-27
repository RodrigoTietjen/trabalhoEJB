package br.estoque;

import javax.ejb.Remote;

import br.model.Produto;

@Remote
public interface ISessionBeanStatefulEstoque {
	
	public int estoqueDisponivel(int id);
	
	public void adicionarProdutoEstoque(Produto produto);
	
	public void descontarEstoque(int id, int quantidade);
}
