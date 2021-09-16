package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.ServicoFeminino;
import com.wb.modelo.ServicoMasculino;
import com.wb.modelo.Servico;

public class CadastroServico extends Cadastro {
	private List<Servico> servicos;
	private Entrada entrada;
	
	public CadastroServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro do serviço");
		System.out.println("Por favor informe o nome do serviço:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o preço: R$");
		Double preco = entrada.receberNumeroDouble();
		System.out.println("Por favor informe o código do serviço:");
		int codigo = entrada.receberNumeroInteiro();
		
		System.out.println("Por favor informe a categoria do produto:");
		System.out.println("[1] - Feminino\n[2] - Masculino\n");
		int categoria = entrada.receberNumeroInteiro();
		switch (categoria) {
			case 1:
				Servico servicoF = new ServicoFeminino(nome, preco, codigo);
				this.servicos.add(servicoF);
				System.out.println("Produto cadastrado com sucesso!\n");
				break;
			case 2:
				Servico servicoM = new ServicoMasculino(nome, preco, codigo);
				this.servicos.add(servicoM);
				System.out.println("Produto cadastrado com sucesso!\n");
				break;
			default:
				System.out.println("Operação não entendida");
		}
		
		
	
//		Produto produto = new Produto(nome, preco, categoria, codigo);
//		this.produtos.add(produto);
	}

}
