package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private List<Telefone> telefones;
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
			System.out.println("\n🟡 Gênero: ");
			System.out.print("\n1️⃣  - Masculino\n2️⃣  - Feminino\n3️⃣  - Outro\n");
			System.out.print("\n🟡 Operação desejada: ");
			int operacao = entrada.receberNumeroInteiro();
			switch (operacao) {
				case 1:
					g = "M";
					exec = false;
					break;
				case 2:
					g = "F";
					exec = false;
					break;
				case 3:
					g = "Outro";
					exec = false;
					break;
				default:
					break;
			}
		}
		String genero = g;

		entrada = new Entrada();
		System.out.print("\nℹ️  CPF: ");
		String valor = entrada.receberTexto();
		System.out.print("ℹ️  Data de Emissão CPF [dd/mm/yyyy]: ");
		String data = entrada.receberTexto();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		CPF cpf = new CPF(dataEmissao, valor);
		
		Cliente cliente = new Cliente(nome, nomeSocial, genero, cpf, telefones);
		
		Cadastro cadastroTelefone = new CadastroTelefone(cliente.getTelefones());
		cadastroTelefone.cadastrar();
		
		int flag = 1;
		while(flag == 1) {
			System.out.print("🟡 Cadastrar outro telefone?\n\n1️⃣  - Sim\n2️⃣  - Não\n");
			System.out.print("\n🟡 Operação desejada: ");
			int operacao = entrada.receberNumeroInteiro();
			switch(operacao) {
				case 2:
					flag = 0;
					break;
				case 1:
					cadastroTelefone.cadastrar();
					break;
				default:
					System.out.println("\n🚫 Operação inválida!\n");
					break;
			}
		}
		
		this.clientes.add(cliente);
		System.out.println("\n✅ Cliente cadastrado com sucesso!\n");
	}
}