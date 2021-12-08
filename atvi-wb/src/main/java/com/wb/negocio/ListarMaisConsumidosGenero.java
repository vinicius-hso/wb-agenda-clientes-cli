package com.wb.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wb.io.Entrada;
import com.wb.modelo.Consumo;
import com.wb.modelo.ConsumoProduto;
import com.wb.modelo.Produto;

public class ListarMaisConsumidosGenero extends Listagem {
    private List<Produto> produtos;
    private List<Consumo> consumos;

    public ListarMaisConsumidosGenero(List<Produto> produtos, List<Consumo> consumos) {
        this.produtos = produtos;
        this.consumos = consumos;
    }

    @Override
    public void listar() {

        String categoria = "Unisex";
        boolean exec = true;

        while (exec) {
            System.out.println("\n📦  MAIS CONSUMIDOS\n");
            System.out.println("1️⃣  - Por gênero Masculino");
            System.out.println("2️⃣  - Por gênero Feminino");
            System.out.println("3️⃣  - Todos");
            // System.out.println("4️⃣  - Cancelar");
            System.out.print("\n🟡 Qual operação deseja realizar? ");

            Entrada entradaProd = new Entrada();
            String opProd = entradaProd.receberTexto();
            switch (opProd) {
                case "1":
                    categoria = "Masculino";
                    exec = false;
                    break;
                case "2":
                    categoria = "Feminino";
                    exec = false;
                    break;
                case "3":
                    categoria = "Unisex";
                    exec = false;
                    break;
                // case "4":
                //     exec = false;
                //     break;
                default:
                    System.out.println("\n🚫 Operação inválida!");
            }
        }
        
        Map<Produto, Integer> myDict = new HashMap<Produto, Integer>();

        for (Produto produto : produtos) {
            int total = 0;
            myDict.put(produto, total);
        }
        
        for (Consumo consumo : consumos) {
            List<Produto> produtos = consumo.getProdutosConsumidos();
            for (Produto produto : produtos) {
                if (produto.getCategoria() == categoria) {
                    myDict.merge(produto, 1, (a,b) -> a+b);
                }
            }
        }

        Set<Produto> prodKeys = myDict.keySet();
        List<ConsumoProduto> consumosProdutos = new ArrayList<ConsumoProduto>();

        for(Produto produto : prodKeys) {
            if (produto.getCategoria() == categoria && myDict.get(produto) > 0) {
                int consumo = myDict.get(produto);
                ConsumoProduto consProd = new ConsumoProduto(consumo,  produto.nome);
                consumosProdutos.add(consProd);
            }
        }
        
        Collections.sort(consumosProdutos);

        if (consumosProdutos.isEmpty()) {
            System.out.println("\n🔴 Ainda não há registro de consumo de produtos & serviços!");
        } else {
            int c = 1;
            for(ConsumoProduto cP : consumosProdutos) {
                    System.out.println("\n#️⃣  Produto Nº " + c);
                    System.out.println("\n🔸 Produto/Serviço: " + cP.nome);
                    System.out.println("🔸 Total de Produtos Consumidos: " + cP.qntConsumo);
                    c++;
            }
        }
    }
    
}
