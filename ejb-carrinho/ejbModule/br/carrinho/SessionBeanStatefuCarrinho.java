package br.carrinho;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.model.Produto;
import br.model.ProdutoCarrinho;

@Stateful
public class SessionBeanStatefuCarrinho implements ISessionBeanStatefulCarrinho{

	List<ProdutoCarrinho> carrinho = new ArrayList<ProdutoCarrinho>();
	
	@Override
	public void adicionarProdutoCarrinho(ProdutoCarrinho produto) {
		carrinho.add(produto);
	}

	@Override
	public void mostrarCarrinho() {
		System.out.println("\n\nProdutos:\n");
		for (ProdutoCarrinho produto : carrinho) {
			System.out.println(produto.getNome() + "  " + produto.getQuantidade() + " unidades");
		}
	}
	
	
	
}
