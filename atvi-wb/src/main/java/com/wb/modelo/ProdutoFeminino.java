package com.wb.modelo;

import java.time.LocalDate;

public class ProdutoFeminino extends Produto {
	
	public ProdutoFeminino(String nome, Double preco, String fornecedor, int codigo) {
		this.nome = nome;
		this.preco = preco;
		this.fornecedor = fornecedor;
		this.codigo = codigo;
		this.dataCadastro = LocalDate.now();
		this.categoria = "Feminino";
	}

}