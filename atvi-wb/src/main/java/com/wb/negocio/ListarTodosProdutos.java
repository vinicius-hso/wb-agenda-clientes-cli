package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Produto;

public class ListarTodosProdutos extends Listagem {
	private List<Produto> produtos;

	public ListarTodosProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os produtos:");
		for (Produto produto : produtos) {
			System.out.println("Nome: " + produto.nome);
			System.out.println("Preço: " + produto.preco);
			System.out.println("Categoria: " + produto.categoria);
			System.out.println("Código: " + produto.codigo);
			System.out.println("--------------------------------------");
		}
	}

}
