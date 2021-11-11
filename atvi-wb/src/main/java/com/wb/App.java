package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Busca;
import com.wb.negocio.BuscaCliente;
import com.wb.negocio.BuscaProduto;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroConsumo;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.CadastroServico;
import com.wb.negocio.Listagem;
import com.wb.negocio.Listar5MaisClientes;
import com.wb.negocio.ListarConsumo;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosProdutos;
import com.wb.negocio.ListarTodosServicos;

public class App {
	public static void main(String[] args) {

		System.out.println("\n🌎 💅 🏢 GRUPO WORLD BEAUTY 🏢 💅 🌎\n");
		System.out.println("👋 Bem-vindo a nosso sistema");
		
		Empresa empresa = new Empresa();
		boolean execucao = true;

		while (execucao) {
			System.out.println("\n🔵 OPERAÇÕES\n");
			System.out.println("1️⃣  - Clientes");
			System.out.println("2️⃣  - Produtos & Serviços");
			System.out.println("3️⃣  - Consumos");
			System.out.println("4️⃣  - Sair");
			// System.out.println("5️⃣  - Cadastrar serviço");
			// System.out.println("6️⃣  - Listar todos os serviços");
			// System.out.println("7️⃣  - Cadastrar consumo");
			// System.out.println("8️⃣  - Listar consumos");
			// System.out.println("9️⃣  - Sair");
			System.out.print("\n🟡 Qual operação deseja realizar? ");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();
			switch (operacao) {
			case 1:
				System.out.println("\n👤  CLIENTES\n");
				System.out.println("1️⃣  - Cadastrar cliente");
				System.out.println("2️⃣  - Listar todos clientes");
				System.out.println("3️⃣  - Buscar cliente");
				System.out.println("4️⃣  - Voltar");
				System.out.print("\n🟡 Qual operação deseja realizar? ");

				Entrada entradaCliente = new Entrada();
				int opCliente = entradaCliente.receberNumeroInteiro();
				switch (opCliente) {
					case 1:
						Cadastro cadastro = new CadastroCliente(empresa.getClientes());
						cadastro.cadastrar();
						break;
					case 2:
						Listagem listagem = new ListarTodosClientes(empresa.getClientes());
						listagem.listar();
						break;
					case 3:
						Busca busca = new BuscaCliente(empresa.getClientes());
						busca.buscar();
						break;
					case 4:
						break;
					default:
						System.out.println("\n🚫 Operação inválida!\n");
				}
				break;
			case 2:
				System.out.println("\n📦  PRODUTOS & SERVIÇOS\n");
				System.out.println("1️⃣  - Cadastrar Produto/Serviço");
				System.out.println("2️⃣  - Listar Produtos/Serviços");
				System.out.println("3️⃣  - Buscar Produto/Serviço");
				System.out.println("4️⃣  - Voltar");
				System.out.print("\n🟡 Qual operação deseja realizar? ");

				Entrada entradaProd = new Entrada();
				int opProd = entradaProd.receberNumeroInteiro();
				switch (opProd) {
					case 1:
						Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
						cadastroProduto.cadastrar();
						break;
					case 2:
						Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos());
						listagemProdutos.listar();
						break;
					case 3:
						Busca buscaProduto = new BuscaProduto(empresa.getProdutos());
						buscaProduto.buscar();
						break;
					case 4:
						break;
					default:
						System.out.println("\n🚫 Operação inválida!\n");
				}
				// Listagem listagem = new ListarTodosClientes(empresa.getClientes());
				// listagem.listar();
				break;
			// case 3:
			// 	Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
			// 	cadastroProduto.cadastrar();	
			// 	break;
			// case 4:
			// 	Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos());
			// 	listagemProdutos.listar();
			// 	break;
			// case 5:
			// 	Cadastro cadastroServico = new CadastroServico(empresa.getServicos());
			// 	cadastroServico.cadastrar();
			// 	break;
			// case 6:
			// 	Listagem listagemServicos = new ListarTodosServicos(empresa.getServicos());
			// 	listagemServicos.listar();
			// 	break;
			// case 7:
			// 	Cadastro cadastroConsumo = new CadastroConsumo(empresa.getConsumos(), empresa.getClientes());
			// 	cadastroConsumo.cadastrar();
			// 	break;
			// case 8:
			// 	Listagem listarConsumo = new ListarConsumo(empresa.getConsumos());
			// 	listarConsumo.listar();
			// 	break;
			// case 9:
			// 	Listagem listar5MaisClientes = new Listar5MaisClientes(empresa.getClientes());
			// 	listar5MaisClientes.listar();
			// 	break;
			case 10:
				execucao = false;
				System.out.println("\n👋 Até mais!\n");
				break;
			default:
				System.out.println("\n🚫 Operação inválida!\n");
			}
		}
	}
}