package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;
// import com.wb.modelo.ProdutoFeminino;
// import com.wb.modelo.ProdutoMasculino;
// import com.wb.negocio.ImpressaoCLI;

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
		String tipo = "";
		String categoria = "";
		
		boolean exec = true;
		while (exec) {
			System.out.print("\n🔵 Tipo:\n\n1️⃣  - Produto\n2️⃣  - Serviço\n");
			
			Entrada entradaTipo = new Entrada();
			System.out.print("\n🟡 Informe o tipo: ");
			String operacao = entradaTipo.receberTexto();
			switch (operacao) {
				case "1":
					tipo = "Produto";
					exec = false;
					break;
				case "2":
					tipo = "Serviço";
					exec = false;
					break;
				default:
					System.out.println("\n🚫 Operação inválida!");
			}
		}
		
		System.out.print("\nℹ️  Nome: ");
		String nome = entrada.receberTexto();
		System.out.print("ℹ️  Preço: R$ ");
		Double preco = entrada.receberNumeroDouble();
		System.out.print("ℹ️  Código: ");
		Entrada entradaCod = new Entrada();
		int codigo = entradaCod.receberNumeroInteiro();

		boolean execCategoria = true;
		while (execCategoria) {
			System.out.print("\n🔵 Categoria\n\n1️⃣  - Feminino\n2️⃣  - Masculino\n3️⃣  - Unisex\n");
			Entrada entradaCategoria = new Entrada();
			System.out.print("\n🟡 Informe a  categoria: ");
			String c = entradaCategoria.receberTexto();
			switch (c) {
				case "1":
					categoria = "Feminino";
					execCategoria = false;
					break;
				case "2":
					categoria = "Masculino";
					execCategoria = false;
					break;
				case "3":
					categoria = "Unisex";
					execCategoria = false;
					break;
				default:
					System.out.println("\n🚫 Operação inválida!");
			}
		}
		
		Produto produto = new Produto(nome, preco, categoria, codigo, tipo);
		this.produtos.add(produto);
		ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(produto);
		impressaoProd.imprimir();
		System.out.println("\n✅ Produto/Serviço cadastrado com sucesso!");
	
	}

}
