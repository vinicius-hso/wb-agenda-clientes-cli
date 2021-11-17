package com.wb.negocio;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;

public class Listar10MenosEmProduto extends Listagem {
    private List<Cliente> clientes;

    public Listar10MenosEmProduto(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void listar() {
        
        Map<Integer, Cliente> myDict = new HashMap<Integer, Cliente>();

        for (Cliente cliente : clientes) {
            int totalProdutos = 0;
            List<Consumo> consumos = cliente.getListaConsumo();
            for (Consumo consumo : consumos) {
                List<Produto> produtos = consumo.getProdutosConsumidos();
                totalProdutos += produtos.size();
            }
            if (totalProdutos != 0) {
                myDict.put(totalProdutos, cliente);
            }
        }

        // Map<Integer, Cliente> sortedMap = new TreeMap<Integer, Cliente>(myDict);
        // System.out.println(sortedMap);
        
        int c = 1;
        if (myDict.size() <= 10) {
            for (Entry<Integer, Cliente> entry : myDict.entrySet()) {
            Integer key = entry.getKey();
            Object val = entry.getValue().nome;
            System.out.println("\n#️⃣  Cliente Nº " + c);
            System.out.println("\n🔸 Nome: " + val);
            System.out.println("🔸 Total de Produtos Consumidos: " + key);
            c++;
            }
        } else {
            for (Entry<Integer, Cliente> entry : myDict.entrySet()) {
                Integer key = entry.getKey();
                Object val = entry.getValue().nome;
                System.out.println("\n#️⃣  Cliente Nº " + c);
                System.out.println("\n🔸 Nome: " + val);
                System.out.println("🔸 Total de Produtos Consumidos: " + key);
                c++;
                if (c > 10) {
                    break;
                }
            }
            
        }
        
    }

    
}
