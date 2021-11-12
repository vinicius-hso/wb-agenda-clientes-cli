package com.wb.negocio;

// import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
// import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;
// import com.wb.modelo.ProdutoConsumido;

public class CadastroConsumo extends Cadastro {

	private List<Consumo> consumos = new ArrayList<Consumo>();
	private List<Cliente> clientes;
	private List<Produto> produtosConsumidos = new ArrayList<Produto>();
	private List<Produto> todosProdutos;
	private Entrada entrada;

	// private List<ProdutoConsumido> produtosConsumidos = new ArrayList<ProdutoConsumido>();

	public CadastroConsumo(List<Consumo> consumos, List<Cliente> clientes, List<Produto> todosProdutos) {
		this.consumos = consumos;
		this.clientes = clientes;
		this.todosProdutos = todosProdutos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		Double valorTotal = 0.0;
		String cpf = null;
		Cliente cliente = null;

		// CPF cpfCliente;
		// String nome;

		System.out.println("\n🛍️  REGISTRO DE CONSUMO");
		//* CADASTRO DE CLIENTE caso não esteja cadastrado
		boolean execucao = true;
		while(execucao) {
			System.out.print("\n🟡 Cliente já cadastrado?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
			// System.out.print("\n🟡 Operação desejada: ");
			System.out.print("\n❔ ");
			int operacao = entrada.receberNumeroInteiro();
			switch(operacao) {
				case 1:
					System.out.println("\n🟡 Informe");
					System.out.print("\nℹ️  CPF do cliente: ");
					entrada = new Entrada();
					cpf = entrada.receberTexto();
					execucao = false;
					break;
				case 2:
					Cadastro cadastroCliente = new CadastroCliente(clientes);
					cadastroCliente.cadastrar();
					cliente = clientes.get(clientes.size() - 1);
					cpf = cliente.getCpf().getValor();
					execucao = false;
					break;
				default:
					System.out.println("\n🚫 Operação inválida!\n");
					// break;
			}
		}

		if (cpf != "") {
			for (Cliente c : clientes) {
				if (cpf.equals(c.getCpf().getValor())) {
					cliente = c;
					ImpressaoCLI impressaoCliente = new ImpressaoCLICliente(cliente);
					impressaoCliente.imprimir();
					break;
				}
			}
		} if (cliente == null) {
			System.out.println("\n🚫 Não foi possível encontrar o cliente!");
			return;
		}

		//* Inserindo produtos na lista
		System.out.println("\n🛍️  REGISTRO DE CONSUMO");
		boolean exec = true;
		while (exec) {
			Entrada entradaCod = new Entrada();
			System.out.println("\n🟡 Informe");
			System.out.print("\nℹ️  Código do produto: ");
			int codigoProd = entradaCod.receberNumeroInteiro();
			boolean flag = true;
			for (Produto prod : todosProdutos) {
				if (codigoProd == prod.codigo) {
					this.produtosConsumidos.add(prod);
					flag = false;
					ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(prod);
					impressaoProd.imprimir();
					System.out.println("\n✅ "+ prod.getTipo() + " adicionado ao consumo!");
					System.out.print("\n🟡 Adicionar outro produto/serviço?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
					System.out.print("\n❔ ");
					Entrada entradaCont = new Entrada();
					int oper = entradaCont.receberNumeroInteiro();
					switch (oper) {
						case 1:
							break;
						case 2:
							exec = false;
							break;
						default:
							System.out.println("\n🚫 Operação inválida!\n");
					}
					break;
				}
			}
			if (flag) {
				System.out.println("\n🚫 Não foi possível encontrar o produto!");
				System.out.print("\n🟡 Tentar novamente?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
				System.out.print("\n❔ ");
				Entrada entradaAcao = new Entrada();
				int op = entradaAcao.receberNumeroInteiro();
				switch (op) {
					case 1:
						break;
					case 2:
						exec = false;
						break;
					default:
						System.out.println("\n🚫 Operação inválida!\n");
				}
			}
		}

		//* Calculando o valor total da compra
		for (Produto produtoConsumido : produtosConsumidos) {
			valorTotal +=  produtoConsumido.getPreco();
		}
		//* Add consumo ao cliente e a lista geral de consumos
		Consumo novoConsumo = new Consumo(produtosConsumidos, valorTotal, cliente);
		cliente.getListaConsumo().add(novoConsumo);
		cliente.setConsumoTotal();
		this.consumos.add(novoConsumo);

		//* Feedback ao usuário
		System.out.println("\n✅ Consumo cadastrado!");
		System.out.print("\n🔹 Cliente: " + cliente.nome);
		System.out.print("\n🔹 CPF: " + cliente.getCpf().getValor());
		System.out.println("\n🔹 Valor total: R$ " + valorTotal);

		//* Listando os produtos consumidos
		for(Produto prod : novoConsumo.getProdutosConsumidos()) {
			System.out.print("\n🔸 " + prod.getTipo() + ": " + prod.getNome());
			System.out.println("\n🔸 Preço: R$ " + prod.getPreco());
		}

		// //* Dados do cliente
		// System.out.println("\n🟡 Informe: ");
		// System.out.print("\nℹ️  Nome do cliente: ");
		// entrada = new Entrada();
		// nome = entrada.receberTexto();
		// System.out.print("ℹ️  CPF do cliente: ");
		// entrada = new Entrada();
		// cpf = entrada.receberTexto();

		// //* Buscando o cliente na base de dados
		// for (Cliente cliente : clientes) {
		// 	if (cpf.equals(cliente.getCpf().getValor().toString())) {
				
		// 		System.out.println("\n✅ Cliente encontrado!");
		// 		String valor = cliente.getCpf().getValor().toString();
		// 		LocalDate data = cliente.getCpf().getDataEmissao();
		// 		cpfCliente = new CPF(data, valor);
		// 		nome = cliente.nome;
		// 		System.out.print("\n🔸 Nome: " + cliente.nome);
		// 		System.out.println("\n🔸 Data de cadastro: " + cliente.getDataCadastro());
				
		// 		Consumo consumo = new Consumo(produtosConsumidos, valorTotal, nome, cpfCliente);
		// 		Cadastro prodCons = new CadastroProdutoConsumido(consumo.getProdutosConsumidos());
		// 		prodCons.cadastrar();

		// 		int flag2 = 1;
		// 		while(flag2 == 1) {
		// 			System.out.print("🟡 Adicionar mais produtos?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
		// 			System.out.print("\n🟡 Operação desejada: ");
		// 			int operacao = entrada.receberNumeroInteiro();
		// 			switch(operacao) {
		// 				case 2:
		// 					flag2 = 0;
		// 					break;
		// 				case 1:
		// 					prodCons.cadastrar();
		// 					break;
		// 				default:
		// 					System.out.println("\n🚫 Operação inválida!\n");
		// 					break;
		// 			}
		// 		}
		// 		//* Calculando o valor total da compra
		// 		for (ProdutoConsumido prod : produtosConsumidos) {
		// 			valorTotal += prod.getPreco();
		// 		}
		// 		consumo.setPrecoTotal(valorTotal);
		// 		this.consumos.add(consumo);
		// 		cliente.getListaConsumo().add(consumo);
		// 		cliente.setConsumoTotal();

		// 		//* Feedback ao usuário
		// 		System.out.println("\n✅ Consumo cadastrado!");
		// 		System.out.print("\n🔹 Cliente: " + nome);
		// 		System.out.print("\n🔹 CPF: " + cpfCliente.getValor());
		// 		System.out.println("\n🔹 Valor total: R$ " + valorTotal);

		// 		//* Listando os produtos consumidos
		// 		for(ProdutoConsumido prod : consumo.getProdutosConsumidos()) {
		// 			System.out.print("\n🔸 Produto: " + prod.getNome());
		// 			System.out.println("\n🔸 Preço: R$ " + prod.getPreco());
		// 		}
				
		// 		break;
		// 	}
		// }
		
	}
}