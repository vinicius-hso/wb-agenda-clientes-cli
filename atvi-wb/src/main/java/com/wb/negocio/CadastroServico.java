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
		System.out.println("\n💇💅  CADASTRO DE SERVIÇO:");
		System.out.println("\n🟡 Informe: ");
		System.out.print("\nℹ️  Nome do serviço: ");
		String nome = entrada.receberTexto();
		System.out.print("ℹ️  Preço: R$ ");
		Double preco = entrada.receberNumeroDouble();
		System.out.print("ℹ️  Código do Produto: ");
		int codigo = entrada.receberNumeroInteiro();
		
		System.out.print("\n🟡 Categoria do produto\n\n1️⃣  - Feminino\n2️⃣  - Masculino\n");
		int categoria = entrada.receberNumeroInteiro();
		switch (categoria) {
			case 1:
				Servico servicoF = new ServicoFeminino(nome, preco, codigo);
				this.servicos.add(servicoF);
				System.out.println("\n✅ Produto Cadastrado!\n");
				break;
			case 2:
				Servico servicoM = new ServicoMasculino(nome, preco, codigo);
				this.servicos.add(servicoM);
				System.out.println("\n✅ Serviço Cadastrado!\n");
				break;
			default:
				System.out.println("\n🚫 Operação inválida!\n");
		}
		
	}

}
