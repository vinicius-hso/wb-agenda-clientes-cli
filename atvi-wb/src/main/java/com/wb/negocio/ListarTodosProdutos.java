package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;

public class ListarTodosProdutos extends Listagem {
	private List<Produto> produtos;
	private List<Consumo> consumos;

	public ListarTodosProdutos(List<Produto> produtos, List<Consumo> consumos) {
		this.produtos = produtos;
		this.consumos = consumos;
	}

	@Override
	public void listar() {
		System.out.println("\n📦 LISTA DE PRODUTOS/SERVIÇOS");
		String filtro = "";

		boolean exec = true;
		while (exec) {
			System.out.println("\n🏷️  POR TIPO:");
			Entrada entrada = new Entrada();
			System.out.println("\n1️⃣  - Produto");
			System.out.println("2️⃣  - Serviço");
			System.out.println("3️⃣  - Todos");
			System.out.println("4️⃣  - 10 Mais consumidos");
			System.out.println("5️⃣  - Mais consumidos por gênero");
			// System.out.println("\n💰 POR CONSUMO:");
			// System.out.println("\n4️⃣  - TOP 5 em valor");
			// System.out.println("5️⃣  - TOP 10 em produtos");
			// System.out.println("6️⃣  - BOTTOM 10 em produtos");
			// System.out.print("\n🟡 Operação desejada: ");
			// System.out.print("\n❔ ");
			System.out.print("\n🟡 Qual operação deseja realizar? ");
			// int operacao = entrada.receberNumeroInteiro();
			String operacao = entrada.receberTexto();
			switch (operacao) {
				case "1":
					filtro = "Produto";
					System.out.println("\n🔷 PRODUTOS");
					exec = false;
					break;
				case "2":
					filtro = "Serviço";
					System.out.println("\n🔷 SERVIÇOS");
					exec = false;
					break;
				case "3":
					filtro = "Todos";
					System.out.println("\n🔷 PRODUTOS & SERVIÇOS");
					exec = false;
					break;
				case "4":
					System.out.println("\n🔷 PRODUTOS & SERVIÇOS MAIS CONSUMIDOS");
					Listagem listaMaisConsumidos = new ListarMaisConsumidos(produtos, consumos);
					listaMaisConsumidos.listar();
					exec = false;
					return;
				case "5":
					System.out.println("\n🔷 PRODUTOS & SERVIÇOS MAIS CONSUMIDOS");
					Listagem listaMaisConsumidosGenero = new ListarMaisConsumidosGenero(produtos, consumos);
					listaMaisConsumidosGenero.listar();
					exec = false;
					break;
				default:
					System.out.println("\n🚫 Operação inválida!");
					break;
			}
		}

		for (Produto produto : produtos) {
			if (filtro.equals("Todos")) {
				ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(produto);
				impressaoProd.imprimir();
			} else {
				if (filtro.equals(produto.tipo)) {
					ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(produto);
					impressaoProd.imprimir();
				}
			}
			
		}
	}

}
