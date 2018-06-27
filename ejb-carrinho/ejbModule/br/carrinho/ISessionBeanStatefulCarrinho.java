package br.carrinho;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import br.model.Produto;
import br.model.ProdutoCarrinho;

@Remote
public interface ISessionBeanStatefulCarrinho {
	public void adicionarProdutoCarrinho(ProdutoCarrinho produto);
	
	public void mostrarCarrinho();
}
