package com.wb.negocio;

import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;

public class CadastroConsumo extends Cadastro {

	private List<Consumo> consumos = new ArrayList<Consumo>();
	private List<Cliente> clientes;
	private List<Produto> produtosConsumidos = new ArrayList<Produto>();
	private List<Produto> todosProdutos;
	private Entrada entrada;

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

		System.out.println("\n🛍️  REGISTRO DE CONSUMO");
		//* CADASTRO DE CLIENTE caso não esteja cadastrado
		boolean execucao = true;
		while(execucao) {
			System.out.print("\n🟡 Cliente já cadastrado?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
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
			String codigoProd = entradaCod.receberTexto();
			boolean flag = true;
			for (Produto prod : todosProdutos) {
				if (codigoProd.equals(prod.codigo)) {
					this.produtosConsumidos.add(prod);
					flag = false;
					ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(prod);
					impressaoProd.imprimir();
					System.out.println("\n✅ "+ prod.getTipo() + " adicionado ao consumo!");
					boolean execAddProd = true;
					while (execAddProd) {
						System.out.print("\n🟡 Adicionar outro produto/serviço?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
						System.out.print("\n❔ ");
						Entrada entradaCont = new Entrada();
						String oper = entradaCont.receberTexto();
						switch (oper) {
							case "1":
								execAddProd = false;
								break;
							case "2":
								execAddProd = false;
								exec = false;
								break;
							default:
								System.out.println("\n🚫 Operação inválida!");
						}
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
		
	}
}