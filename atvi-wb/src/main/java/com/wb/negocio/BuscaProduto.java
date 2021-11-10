package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class BuscaProduto extends Busca{
    private List<Produto> produtos;

    public BuscaProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public void buscar() {
        
        System.out.println("\n🔎📦  BUSCAR PRODUTO");
        System.out.print("\n🟡 Insira o código: ");
        Produto p = null;
        Entrada entrada = new Entrada();
        String cod = entrada.receberTexto();

        // for (Cliente cli : clientes) {
        //     if (cli.getCpf().getValor().equals(cpf)) {
        //         c = cli;
        //         impressao = new ImpressaoCLICliente(c);
        //         impressao.imprimir();
        //         System.out.println("\n🔵 Ações:");
        //         System.out.println("\n1️⃣  - Editar cliente");
		//         System.out.println("2️⃣  - Deletar cliente");
        //         System.out.println("3️⃣  - Cancelar");
        //         System.out.print("\n🟡 Operação desejada: ");
        //         Entrada novaEntrada = new Entrada();
        //         int operacao = novaEntrada.receberNumeroInteiro();
        //         switch (operacao) {
        //             case 1:
        //                 Edicao edicaoCliente = new EdicaoCliente(cli);
        //                 edicaoCliente.editar();
        //                 break;
        //             case 2:
        //                 clientes.remove(cli);
        //                 System.out.println("\n✅ Cliente removido com sucesso!\n");
        //                 break;
        //             case 3:
        //                 break;
        //             default:
        //                 System.out.println("\n🚫 Operação inválida!\n");
        //         }
        //         break;
        //     }
        // }

        // if (c == null) System.out.println("\n❌ Não foi possível encontrar o cliente informado!");
        
    }

    
}
