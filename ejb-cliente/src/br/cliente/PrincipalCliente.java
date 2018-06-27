package br.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import br.carrinho.ISessionBeanStatefulCarrinho;
import br.estoque.ISessionBeanStatefulEstoque;
import br.model.Produto;
import br.model.ProdutoCarrinho;

public class PrincipalCliente {
	
	ISessionBeanStatefulEstoque estoque;
	ISessionBeanStatefulCarrinho carrinho;
	public static void main(String[] args) {
		PrincipalCliente p = new PrincipalCliente();
		p.rodar();
	}
	
	public PrincipalCliente() {
		
	}
	
	public void rodar() {
		InitialContext ctx;
		try {
			ctx = new InitialContext(JNDIConfig.getConfigs());
			estoque = (ISessionBeanStatefulEstoque)ctx.lookup("ejb:/ejb-estoque/SessionBeanStatefulEstoque!br.estoque.ISessionBeanStatefulEstoque?stateful");
			carrinho = (ISessionBeanStatefulCarrinho)ctx.lookup("ejb:/ejb-carrinho/SessionBeanStatefuCarrinho!br.carrinho.ISessionBeanStatefulCarrinho?stateful");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		for(int i = 1; i <= 10; i++) {
			Produto p = new Produto();
			p.setId(i);
			p.setNome("Produto " + i);
			p.setEstoque(10);
			estoque.adicionarProdutoEstoque(p);
		}
		
		System.out.println(estoque.estoqueDisponivel(1));
		ProdutoCarrinho p = new ProdutoCarrinho();
		p.setId(1);
		p.setNome("Produto 1");
		p.setQuantidade(-1);
		
		if(estoque.estoqueDisponivel(p.getId()) >= p.getQuantidade()) {
			estoque.descontarEstoque(p.getId(), p.getQuantidade());
			carrinho.adicionarProdutoCarrinho(p);
		}
		else {
			JOptionPane.showMessageDialog(null, "Estoque Nao disponivel");
		}
		carrinho.mostrarCarrinho();
		System.out.println(estoque.estoqueDisponivel(1));
		
		
	}
}
