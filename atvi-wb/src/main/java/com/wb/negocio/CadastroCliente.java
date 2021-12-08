package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private List<Telefone> telefones;
	private List<RG> rgs;
	private CPF cpf;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\n🗄️  CADASTRO DE CLIENTE:");
		System.out.println("\n🟡 Informe: ");
		System.out.print("\nℹ️  Nome: ");
		String nome = entrada.receberTexto();
		System.out.print("ℹ️  Nome Social: ");
		String nomeSocial = entrada.receberTexto();
		String g = "";

		boolean exec = true;
		while (exec) {
			System.out.println("\n🔵 Gênero: ");
			System.out.print("\n1️⃣  - Masculino\n2️⃣  - Feminino\n3️⃣  - Outro\n");
			System.out.print("\n🟡 Informe o gênero: ");
			String operacao = entrada.receberTexto();
			
			switch (operacao) {
				case "1":
					g = "Masculino";
					exec = false;
					break;
				case "2":
					g = "Feminino";
					exec = false;
					break;
				case "3":
					g = "Outro";
					exec = false;
					break;
				default:
					System.out.println("\n🚫 Opção inválida! Tente novamente.");
					break;
			}
		}
		String genero = g;

		Cliente cliente = new Cliente(nome, nomeSocial, genero, cpf, telefones, rgs);

		Cadastro cadastroCpf = new CadastroCpf(cliente);
		cadastroCpf.cadastrar();

		Cadastro cadastroRg = new CadastroRg(cliente.getRgs());
		cadastroRg.cadastrar();

		int flagRg = 1;
		while(flagRg == 1) {
			System.out.print("🟡 Cadastrar outro RG?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
			System.out.print("\n🟡 Operação desejada: ");
			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
			switch(operacao) {
				case "2":
					flagRg = 0;
					break;
				case "1":
					cadastroRg.cadastrar();
					break;
				default:
					System.out.println("\n🚫 Operação inválida!\n");
					break;
			}
		}

		
		Cadastro cadastroTelefone = new CadastroTelefone(cliente.getTelefones());
		cadastroTelefone.cadastrar();
		
		int flag = 1;
		while(flag == 1) {
			System.out.print("\n🟡 Cadastrar outro telefone?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
			System.out.print("\n🟡 Operação desejada: ");
			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
			switch(operacao) {
				case "2":
					flag = 0;
					break;
				case "1":
					cadastroTelefone.cadastrar();
					break;
				default:
					System.out.println("\n🚫 Operação inválida!\n");
					break;
			}
		}
		
		this.clientes.add(cliente);
		System.out.println("\n✅ Cliente cadastrado com sucesso!");
	}
}