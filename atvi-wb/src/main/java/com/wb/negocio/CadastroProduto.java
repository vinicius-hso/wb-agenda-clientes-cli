package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;
import com.wb.modelo.ProdutoFeminino;
import com.wb.modelo.ProdutoMasculino;

public class CadastroProduto extends Cadastro {
	private List<Produto> produtos;
	private Entrada entrada;
	
	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\n📦  CADASTRO DE PRODUTO:");
		System.out.println("\n🟡 Informe: ");
		System.out.print("\nℹ️  Nome do produto: ");
		String nome = entrada.receberTexto();
		System.out.print("ℹ️  Preço: R$ ");
		Double preco = entrada.receberNumeroDouble();
		System.out.print("ℹ️  Código do Produto: ");
		int codigo = entrada.receberNumeroInteiro();
		// System.out.print("\nℹ️  Fornecedor:");
		// String fornecedor = entrada.receberTexto();
		
		System.out.print("\n🟡 Categoria do produto\n\n1️⃣  - Feminino\n2️⃣  - Masculino\n");
		int categoria = entrada.receberNumeroInteiro();
		switch (categoria) {
			case 1:
				Produto produtoF = new ProdutoFeminino(nome, preco, codigo);
				this.produtos.add(produtoF);
				System.out.println("\n✅ Produto Cadastrado!\n");
				break;
			case 2:
				Produto produtoM = new ProdutoMasculino(nome, preco, codigo);
				this.produtos.add(produtoM);
				System.out.println("\n✅ Produto Cadastrado!\n");
				break;
			default:
				System.out.println("\n🚫 Operação inválida!\n");
		}
		
		
	
//		Produto produto = new Produto(nome, preco, categoria, codigo);
//		this.produtos.add(produto);
	}

}
