package com.wb.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;
import com.wb.modelo.ProdutoConsumido;

public class CadastroConsumo extends Cadastro {

	private List<Consumo> consumos = new ArrayList<Consumo>();
	private List<Cliente> clientes;
	private List<ProdutoConsumido> produtosConsumidos = new ArrayList<ProdutoConsumido>();
	private Entrada entrada;

	public CadastroConsumo(List<Consumo> consumos, List<Cliente> clientes) {
		this.consumos = consumos;
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		Double valorTotal = 0.0;
		String nome;
		String cpf;
		CPF cpfCliente;

		System.out.println("\n🛍️ CADASTRO DE CONSUMO:");
		//* CADASTRO DE CLIENTE caso não esteja cadastrado
		int flag = 1;
		while(flag == 1) {
			System.out.print("\n🟡 Cliente já cadastrado?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
			System.out.print("\n🟡 Operação desejada: ");
			int operacao = entrada.receberNumeroInteiro();
			switch(operacao) {
				case 1:
					flag = 0;
					break;
				case 2:
					Cadastro cadastroCliente = new CadastroCliente(clientes);
					cadastroCliente.cadastrar();
					flag = 0;
					break;
				default:
					System.out.println("\n🚫 Operação inválida!\n");
					break;
			}
		}

		//* Dados do cliente
		System.out.println("\n🟡 Informe: ");
		System.out.print("\nℹ️  Nome do cliente: ");
		entrada = new Entrada();
		nome = entrada.receberTexto();
		System.out.print("ℹ️  CPF do cliente: ");
		entrada = new Entrada();
		cpf = entrada.receberTexto();

		//* Buscando o cliente na base de dados
		for (Cliente cliente : clientes) {
			if (cpf.equals(cliente.getCpf().getValor().toString())) {
				
				System.out.println("\n✅ Cliente encontrado!");
				String valor = cliente.getCpf().getValor().toString();
				LocalDate data = cliente.getCpf().getDataEmissao();
				cpfCliente = new CPF(data, valor);
				nome = cliente.nome;
				System.out.print("\n🔸 Nome: " + cliente.nome);
				System.out.println("\n🔸 Data de cadastro: " + cliente.getDataCadastro());
				
				Consumo consumo = new Consumo(produtosConsumidos, valorTotal, nome, cpfCliente);
				Cadastro prodCons = new CadastroProdutoConsumido(consumo.getProdutosConsumidos());
				prodCons.cadastrar();

				int flag2 = 1;
				while(flag2 == 1) {
					System.out.print("🟡 Adicionar mais produtos?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
					System.out.print("\n🟡 Operação desejada: ");
					int operacao = entrada.receberNumeroInteiro();
					switch(operacao) {
						case 2:
							flag2 = 0;
							break;
						case 1:
							prodCons.cadastrar();
							break;
						default:
							System.out.println("\n🚫 Operação inválida!\n");
							break;
					}
				}
				//* Calculando o valor total da compra
				for (ProdutoConsumido prod : produtosConsumidos) {
					valorTotal += prod.getPreco();
				}
				consumo.setPrecoTotal(valorTotal);
				this.consumos.add(consumo);
				cliente.getListaConsumo().add(consumo);
				cliente.setConsumoTotal();

				//* Feedback ao usuário
				System.out.println("\n✅ Consumo cadastrado!");
				System.out.print("\n🔹 Cliente: " + nome);
				System.out.print("\n🔹 CPF: " + cpfCliente.getValor());
				System.out.println("\n🔹 Valor total: R$ " + valorTotal);

				//* Listando os produtos consumidos
				for(ProdutoConsumido prod : consumo.getProdutosConsumidos()) {
					System.out.print("\n🔸 Produto: " + prod.getNome());
					System.out.println("\n🔸 Preço: R$ " + prod.getPreco());
				}
				
				break;
			}
		}
		
	}
}