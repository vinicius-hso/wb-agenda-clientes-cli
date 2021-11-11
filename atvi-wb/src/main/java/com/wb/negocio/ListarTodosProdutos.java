package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class ListarTodosProdutos extends Listagem {
	private List<Produto> produtos;

	public ListarTodosProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public void listar() {
		System.out.println("\n📦  LISTA DE PRODUTOS/SERVIÇOS:");
		System.out.println("\n🏷️ POR TIPO:");
		Entrada entrada = new Entrada();
		System.out.println("\n1️⃣  - Produto");
		System.out.println("2️⃣  - Serviço");
		System.out.println("3️⃣  - Todos");
		// System.out.println("\n💰 POR CONSUMO:");
		// System.out.println("\n4️⃣  - TOP 5 em valor");
		// System.out.println("5️⃣  - TOP 10 em produtos");
		// System.out.println("6️⃣  - BOTTOM 10 em produtos");
		System.out.print("\n🟡 Operação desejada: ");
		int operacao = entrada.receberNumeroInteiro();


		for (Produto produto : produtos) {
			System.out.println("\n🔸 Nome: " + produto.nome);
			System.out.println("🔸 Preço: " + produto.preco);
			System.out.println("🔸 Categoria: " + produto.categoria);
			System.out.println("🔸 Código: " + produto.codigo);
		}
	}

}
