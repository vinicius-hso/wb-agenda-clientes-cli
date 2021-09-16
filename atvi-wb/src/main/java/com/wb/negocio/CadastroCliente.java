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
		System.out.println("Início do cadastro do cliente");
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o nome social do cliente:");
		String nomeSocial = entrada.receberTexto();
		System.out.println("Por favor informe o gênero: ");
		String genero = entrada.receberTexto();
		System.out.println("Por favor informe o número do cpf:");
		String valor = entrada.receberTexto();
		System.out.println("Por favor informe a data de emissão do cpf, no padrão dd/mm/yyyy:");
		String data = entrada.receberTexto();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		CPF cpf = new CPF(dataEmissao, valor);
		Cliente cliente = new Cliente(nome, nomeSocial, genero, cpf, telefones);
		
		while(true) {
			System.out.println("Por favor informe o telefone de contato\n\nDDD: ");
//			String ddd = entrada.receberTexto();
//			System.out.println("Número: ");
//			String numero = entrada.receberTexto();
//			Telefone telefone = new Telefone(ddd, numero);
			
			Cadastro cadastroTelefone = new CadastroTelefone(cliente.getTelefones());
			cadastroTelefone.cadastrar();
			System.out.println("Cadastro de telefone realizado com sucesso!\n");			
			System.out.println("Cadastrar outro telefone?\n[1] - Sim\n[0] - Não");
			int operacao = entrada.receberNumeroInteiro();
			if (operacao == 0) break;
			else if (operacao != 1) {
				System.out.println("Operação inválida!");
			}
		}
		
		this.clientes.add(cliente);
	}
}