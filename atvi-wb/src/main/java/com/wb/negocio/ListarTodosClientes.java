package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;
	private Empresa empresa = new Empresa();
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
		System.out.println("\n4️⃣  - TOP 5 em valor");
		System.out.println("5️⃣  - TOP 10 em produtos");
		System.out.println("6️⃣  - BOTTOM 10 em produtos");
		System.out.print("\n🟡 Operação desejada: ");
		int operacao = entrada.receberNumeroInteiro();
		String genero = "T";
		switch (operacao) {
			//* Masculino
			case 1:
				genero = "M";
				break;
			case 2:
				genero = "F";
				break;
			case 3:
				genero = "Outro";
				break;
			case 4:
				//* Listar os 5 mais (valor)
				System.out.println("\n💵 TOP 5 em valor");
				Listagem listar5MaisClientes = new Listar5MaisClientes(empresa.getClientes());
				listar5MaisClientes.listar();
				break;
			case 5:
				// TODO - Listar os 10 mais (produtos)
				System.out.println("\n🛍️ ➕ TOP 10 em produtos");
				break;
			case 6:
				// TODO - Listar os 10 menos (produtos)
				System.out.println("\n🛍️ ➖ BOTTOM 10 em produtos");
				break;
			default:
				System.out.println("\n🚫 Operação inválida!\n");
				break;
		}
		if (genero == "Outro") {
			for (Cliente cliente : clientes) {
				this.impressao = new ImpressaoCLICliente(cliente);
                impressao.imprimir();
			}
		} else {
			for (Cliente cliente : clientes) {
				if (cliente.getGenero().equalsIgnoreCase(genero)) {
					this.impressao = new ImpressaoCLICliente(cliente);
                	impressao.imprimir();
				}
			}
		}

		
	}
}
