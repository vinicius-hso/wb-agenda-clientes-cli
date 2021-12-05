package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;
	// private Empresa empresa = new Empresa();
	private ImpressaoCLI impressao;

	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		
		System.out.println("\n👨👩 LISTA DE CLIENTES:");
		System.out.println("\n⚥ POR GÊNERO:");
		Entrada entrada = new Entrada();
		System.out.println("\n1️⃣  - Masculino");
		System.out.println("2️⃣  - Feminino");
		System.out.println("3️⃣  - Todos");
		System.out.println("\n💰 POR CONSUMO:");
		System.out.println("\n4️⃣  - 5 MAIS em valor de consumo");
		System.out.println("5️⃣  - 10 MAIS em quantidade de produtos");
		System.out.println("6️⃣  - 10 MENOS em quantidade de produtos");
		// System.out.print("\n🟡 Operação desejada: ");
		System.out.print("\n❔ ");
		// int operacao = entrada.receberNumeroInteiro();
		String operacao = entrada.receberTexto();
		String genero = "T";
		switch (operacao) {
			//* Masculino
			case "1":
				genero = "M";
				break;
			case "2":
				genero = "F";
				break;
			case "3":
				genero = "Outro";
				break;
			case "4":
				System.out.println("\n💵 5 MAIS em valor de consumo");
				Listagem listar5MaisClientes = new Listar5MaisClientes(clientes);
				listar5MaisClientes.listar();
				return;
			case "5":
				System.out.println("\n🛍️ ➕ 10 MAIS em quantidade de produtos");
				Listagem listar10Mais = new Listar10MaisEmProduto(clientes);
				listar10Mais.listar();
				return;
			case "6":
				System.out.println("\n🛍️ ➖ 10 MENOS em quantidade de produtos");
				Listagem listar10Menos = new Listar10MenosEmProduto(clientes);
				listar10Menos.listar();
				return;
			default:
				System.out.println("\n🚫 Operação inválida!\n");
				break;
		}
		
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
