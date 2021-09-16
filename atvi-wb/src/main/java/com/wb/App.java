package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.CadastroServico;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosProdutos;
import com.wb.negocio.ListarTodosServicos;

public class App {
	public static void main(String[] args) {
		System.out.println("\n=======================================================");
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty\n");
		Empresa empresa = new Empresa();
		boolean execucao = true;
		while (execucao) {
			System.out.println("Que tipo de operação você deseja fazer:\n");
			System.out.println("[1] - Cadastrar cliente");
			System.out.println("[2] - Listar todos os clientes");
			System.out.println("[3] - Cadastrar produto");
			System.out.println("[4] - Listar todos os produtos");
			System.out.println("[5] - Cadastrar serviço");
			System.out.println("[6] - Listar todos os serviços");
			System.out.println("[7] - Registrar venda");
			
			System.out.println("[0] - Sair\n");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("Até mais!\n");
				break;
			case 1:
				Cadastro cadastro = new CadastroCliente(empresa.getClientes());
				cadastro.cadastrar();
				break;
			case 2:
				Listagem listagem = new ListarTodosClientes(empresa.getClientes());
				listagem.listar();
				break;
			case 3:
				Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
				cadastroProduto.cadastrar();
				break;
			case 4:
				Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos());
				listagemProdutos.listar();
				break;
			case 5:
				Cadastro cadastroServico = new CadastroServico(empresa.getServicos());
				cadastroServico.cadastrar();
				break;
			case 6:
				Listagem listagemServicos = new ListarTodosServicos(empresa.getServicos());
				listagemServicos.listar();
				break;
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}