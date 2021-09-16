package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Servico;

public class ListarTodosServicos extends Listagem {
	private List<Servico> servicos;

	public ListarTodosServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os serviços:");
		for (Servico servico : servicos) {
			System.out.println("Nome: " + servico.nome);
			System.out.println("Preço: " + servico.preco);
			System.out.println("Categoria: " + servico.categoria);
			System.out.println("Código: " + servico.codigo);
			System.out.println("--------------------------------------");
		}
	}

}
