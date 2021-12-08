package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class BuscaProduto extends Busca {
    private List<Produto> produtos;

    public BuscaProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public void buscar() {
        
        System.out.println("\n🔎📦  BUSCAR PRODUTO/SERVIÇO");
        System.out.print("\n🟡 Insira o código: ");
        Produto prod = null;
        Entrada entrada = new Entrada();
        int cod = entrada.receberNumeroInteiro();

        for (Produto produto : produtos) {
            if (produto.getCodigo() == cod) {
                prod = produto;
                ImpressaoCLI impProd = new ImpressaoCLIProduto(prod);
                impProd.imprimir();

                boolean exec = true;
                while (exec) {
                    System.out.println("\n🔵 Operações:");
                    System.out.println("\n1️⃣  - Editar produto");
                    System.out.println("2️⃣  - Deletar produto");
                    System.out.println("3️⃣  - Cancelar");
                    System.out.print("\n🟡 Operação desejada: ");
                    
                    Entrada novaEntrada = new Entrada();
                    String operacao = novaEntrada.receberTexto();
                    switch (operacao) {
                        case "1":
                            Edicao edicaoProd = new EdicaoProduto(prod);
                            edicaoProd.editar();
                            exec = false;
                            break;
                        case "2":
                            produtos.remove(produto);
                            System.out.println("\n✅ Produto removido com sucesso!");
                            exec = false;
                            break;
                        case "3":
                            exec = false;
                            break;
                        default:
                            System.out.println("\n🚫 Operação inválida!");
                    }
                }
                
                // break;
            }
        }
        if (prod == null) System.out.println("\n❌ Não foi possível encontrar o produto/serviço informado!");      
    }

    
}
