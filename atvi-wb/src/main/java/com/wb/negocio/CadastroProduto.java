package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;
// import com.wb.modelo.ProdutoFeminino;
// import com.wb.modelo.ProdutoMasculino;
import com.wb.negocio.ImpressaoCLI;

public class CadastroProduto extends Cadastro {
	private List<Produto> produtos;
	private Entrada entrada;
	
	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\n📦  CADASTRO DE PRODUTO & SERVIÇOS");
		System.out.println("\n🟡 Informe: ");
		System.out.print("\n🟡 Tipo\n\n1️⃣  - Produto\n2️⃣  - Serviço\n");

		String tipo = "";
		Entrada entradaTipo = new Entrada();
		System.out.print("\n❔ ");
		int operacao = entradaTipo.receberNumeroInteiro();
		
		switch (operacao) {
			case 1:
				tipo = "Produto";
				break;
			case 2:
				tipo = "Serviço";
				break;
			default:
				System.out.println("\n🚫 Operação inválida!\n");
		}
		System.out.print("\nℹ️  Nome: ");
		String nome = entrada.receberTexto();
		System.out.print("ℹ️  Preço: R$ ");
		Double preco = entrada.receberNumeroDouble();
		System.out.print("ℹ️  Código: ");
		Entrada entradaCod = new Entrada();
		int codigo = entradaCod.receberNumeroInteiro();
		System.out.print("\n🟡 Categoria\n\n1️⃣  - Feminino\n2️⃣  - Masculino\n3️⃣  - Unisex\n");
		Entrada entradaCategoria = new Entrada();
		System.out.print("\n❔ ");
		int c = entradaCategoria.receberNumeroInteiro();
		String categoria = "";

		switch (c) {
			case 1:
				categoria = "Feminino";
				// Produto produtoF = new Produto(nome, preco, categoria, codigo, tipo);
				// this.produtos.add(produtoF);
				// ImpressaoCLI impressaoProdF = new ImpressaoCLIProduto(produtoF);
				// impressaoProdF.imprimir();
				break;
			case 2:
				categoria = "Masculino";
				// Produto produtoM = new Produto(nome, preco, categoria, codigo, tipo);
				// this.produtos.add(produtoM);
				// ImpressaoCLI impressaoProdM = new ImpressaoCLIProduto(produtoM);
				// impressaoProdM.imprimir();
				break;
			case 3:
				categoria = "Unisex";
				// Produto produtoU = new Produto(nome, preco, categoria, codigo, tipo);
				// this.produtos.add(produtoU);
				// ImpressaoCLI impressaoProdU = new ImpressaoCLIProduto(produtoU);
				// impressaoProdU.imprimir();
				break;
			default:
				System.out.println("\n🚫 Operação inválida!\n");
		}

		Produto produto = new Produto(nome, preco, categoria, codigo, tipo);
		this.produtos.add(produto);
		ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(produto);
		impressaoProd.imprimir();
		System.out.println("\n✅ Produto/Serviço cadastrado com sucesso!");
		
		// switch (categoria) {
		// 	case 1:
		// 		Produto produtoF = new ProdutoFeminino(nome, preco, codigo, tipo);
		// 		this.produtos.add(produtoF);
		// 		ImpressaoCLI impressaoProdF = new ImpressaoCLIProduto(produtoF);
		// 		impressaoProdF.imprimir();
		// 		System.out.println("\n✅ Produto Cadastrado!");
		// 		break;
		// 	case 2:
		// 		Produto produtoM = new ProdutoMasculino(nome, preco, codigo, tipo);
		// 		this.produtos.add(produtoM);
		// 		ImpressaoCLI impressaoProdM = new ImpressaoCLIProduto(produtoM);
		// 		impressaoProdM.imprimir();
		// 		System.out.println("\n✅ Produto Cadastrado!");
		// 		break;
		// 	default:
		// 		System.out.println("\n🚫 Operação inválida!\n");
		// }

//		Produto produto = new Produto(nome, preco, categoria, codigo);
//		this.produtos.add(produto);
	}

}
