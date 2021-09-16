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
		System.out.println("Início do cadastro do produto");
		System.out.println("Por favor informe o nome do produto:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o preço: R$");
		Double preco = entrada.receberNumeroDouble();
		System.out.println("Por favor informe o código do produto:");
		int codigo = entrada.receberNumeroInteiro();
		System.out.println("Por favor informe o código do produto:");
		String fornecedor = entrada.receberTexto();
		
		System.out.println("Por favor informe a categoria do produto:");
		System.out.println("[1] - Feminino\n[2] - Masculino\n");
		int categoria = entrada.receberNumeroInteiro();
		switch (categoria) {
			case 1:
				Produto produtoF = new ProdutoFeminino(nome, preco, fornecedor, codigo);
				this.produtos.add(produtoF);
				System.out.println("Produto cadastrado com sucesso!\n");
				break;
			case 2:
				Produto produtoM = new ProdutoMasculino(nome, preco, fornecedor, codigo);
				this.produtos.add(produtoM);
				System.out.println("Produto cadastrado com sucesso!\n");
				break;
			default:
				System.out.println("Operação não entendida");
		}
		
		
	
//		Produto produto = new Produto(nome, preco, categoria, codigo);
//		this.produtos.add(produto);
	}

}
