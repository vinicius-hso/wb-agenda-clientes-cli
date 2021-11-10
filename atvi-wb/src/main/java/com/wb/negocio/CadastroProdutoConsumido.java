package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.ProdutoConsumido;

public class CadastroProdutoConsumido extends Cadastro{
    private List<ProdutoConsumido> produtosConsumidos;
	private Entrada entrada;

    public CadastroProdutoConsumido(List<ProdutoConsumido> produtosConsumidos) {
		this.produtosConsumidos = produtosConsumidos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\n🎁 ADICIONAR PRODUTO: ");
		System.out.print("\nℹ️  Produto: ");
		entrada = new Entrada();
		String produto = entrada.receberTexto();
		System.out.print("ℹ️  Preço: ");
		entrada = new Entrada();
		Double preco = entrada.receberNumeroDouble();
		ProdutoConsumido prod = new ProdutoConsumido(produto, preco);
		this.produtosConsumidos.add(prod);
		System.out.println("\n✅ Produto adicionado!\n");
	}
}
