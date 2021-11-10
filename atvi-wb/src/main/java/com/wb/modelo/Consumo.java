package com.wb.modelo;

import java.time.LocalDate;
import java.util.List;

public class Consumo {
    // private List<Produto> produtos;
	// private List<Servico> servicos;
    // private Cliente cliente;

    private List<ProdutoConsumido> produtosConsumidos;
    private Double precoTotal;
    private LocalDate dataConsumo;
    private String nomeCliente;
    private CPF cpfCliente;

    public Consumo(){

    }
    
    public Consumo(List<ProdutoConsumido> produtosConsumidos, Double precoTotal,
            String nomeCliente, CPF cpfCliente) {
        // this.produtos = produtos;
        // this.servicos = servicos;
        this.produtosConsumidos = produtosConsumidos;
        this.precoTotal = precoTotal;
        this.nomeCliente = nomeCliente;
        this.dataConsumo = LocalDate.now();
        this.cpfCliente = cpfCliente;
    }

    // public List<Produto> getProdutos() {
    //     return produtos;
    // }

    // public void setProdutos(List<Produto> produtos) {
    //     this.produtos = produtos;
    // }

    // public List<Servico> getServicos() {
    //     return servicos;
    // }

    // public void setServicos(List<Servico> servicos) {
    //     this.servicos = servicos;
    // }

    public List<ProdutoConsumido> getProdutosConsumidos() {
        return produtosConsumidos;
    }

    public void setProdutosConsumidos(List<ProdutoConsumido> produtosConsumidos) {
        this.produtosConsumidos = produtosConsumidos;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public LocalDate getDataConsumo() {
        return dataConsumo;
    }

    public void setDataConsumo(LocalDate dataConsumo) {
        this.dataConsumo = dataConsumo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public CPF getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(CPF cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    
}
