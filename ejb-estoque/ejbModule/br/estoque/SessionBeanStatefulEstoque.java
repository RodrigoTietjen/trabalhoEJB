package br.estoque;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.model.Produto;

@Stateful
public class SessionBeanStatefulEstoque implements ISessionBeanStatefulEstoque{
	public List<Produto> produtos = new ArrayList<Produto>();
	
	@Override
	public int estoqueDisponivel(int id) {
		
		for (Produto produto : produtos) {
			if(produto.getId() == id) {
				return produto.getEstoque();
			}
		}
		return -1;
	}

	@Override
	public void adicionarProdutoEstoque(Produto produto) {
		produtos.add(produto);
	}

	@Override
	public void descontarEstoque(int id, int quantidade) {
		for (Produto produto : produtos) {
			if(produto.getId() == id) {
				produto.setEstoque(produto.getEstoque() - quantidade);
			}
		}
	}

}
