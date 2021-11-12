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
                System.out.println("\n🔵 Ações:");
                System.out.println("\n1️⃣  - Editar produto");
		        System.out.println("2️⃣  - Deletar produto");
                System.out.println("3️⃣  - Cancelar");
                // System.out.print("\n🟡 Operação desejada: ");
                System.out.print("\n❔ ");
                Entrada novaEntrada = new Entrada();
                int operacao = novaEntrada.receberNumeroInteiro();
                switch (operacao) {
                    case 1:
                        Edicao edicaoProd = new EdicaoProduto(prod);
                        edicaoProd.editar();
                        break;
                    case 2:
                        produtos.remove(produto);
                        System.out.println("\n✅ Produto removido com sucesso!");
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("\n🚫 Operação inválida!\n");
                }
                break;
            }
        }
        if (prod == null) System.out.println("\n❌ Não foi possível encontrar o produto/serviço informado!");      
    }

    
}
