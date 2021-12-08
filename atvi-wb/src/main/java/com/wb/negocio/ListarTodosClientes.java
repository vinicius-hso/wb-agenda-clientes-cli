package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;
	private ImpressaoCLI impressao;

	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		
		System.out.println("\n👨👩 LISTA DE CLIENTES:");

		boolean exec = true;
		String genero = "T";
		while (exec) {
			System.out.println("\n⚥ POR GÊNERO:");
			Entrada entrada = new Entrada();
			System.out.println("\n1️⃣  - Masculino");
			System.out.println("2️⃣  - Feminino");
			System.out.println("3️⃣  - Todos");
			System.out.println("\n💰 POR CONSUMO:");
			System.out.println("\n4️⃣  - 5 MAIS em valor de consumo");
			System.out.println("5️⃣  - 10 MAIS em quantidade de produtos");
			System.out.println("6️⃣  - 10 MENOS em quantidade de produtos");
			System.out.println("\n7️⃣  - Cancelar");
			System.out.print("\n🟡 Operação desejada: ");
			String operacao = entrada.receberTexto();
			switch (operacao) {
				case "1":
					genero = "Masculino";
					exec = false;
					break;
				case "2":
					genero = "Feminino";
					exec = false;
					break;
				case "3":
					genero = "Outro";
					exec = false;
					break;
				case "4":
					System.out.println("\n💵 5 Clientes que MAIS consumiram em valor");
					Listagem listar5MaisClientes = new Listar5MaisClientes(clientes);
					listar5MaisClientes.listar();
					exec = false;
					break;
				case "5":
					System.out.println("\n🛍️ ➕ 10 Clientes que MAIS consumiram em quantidade");
					Listagem listar10Mais = new Listar10MaisEmProduto(clientes);
					listar10Mais.listar();
					exec = false;
					break;
				case "6":
					System.out.println("\n🛍️ ➖ 10 Clientes que MENOS consumiram em quantidade");
					Listagem listar10Menos = new Listar10MenosEmProduto(clientes);
					listar10Menos.listar();
					exec = false;
					break;
				case "7":
					exec = false;
					break;
				default:
					System.out.println("\n🚫 Operação inválida!");
			}
		}

		if (genero != "T") {
			if (genero == "Outro") {
				System.out.println("\n👨👩 CLIENTES:");
				for (Cliente cliente : clientes) {
					this.impressao = new ImpressaoCLICliente(cliente);
					impressao.imprimir();
				}
			} else {
				System.out.println("\n👨👩 CLIENTES:");
				for (Cliente cliente : clientes) {
					if (cliente.getGenero().equalsIgnoreCase(genero)) {
						this.impressao = new ImpressaoCLICliente(cliente);
						impressao.imprimir();
					}
				}
			}
		}
		
	}
}
