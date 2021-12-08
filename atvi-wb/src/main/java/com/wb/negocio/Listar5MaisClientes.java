package com.wb.negocio;

import java.util.Collections;
import java.util.List;


import com.wb.modelo.Cliente;

public class Listar5MaisClientes extends Listagem {
    private List<Cliente> clientes;
    private ImpressaoCLI impressao;

    public Listar5MaisClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
	public void listar() {
        Collections.sort(clientes, new ComparadorValorConsumo());
        Collections.reverse(clientes);

        for (int i = 0; i < 5; ++i) {
            if (clientes.get(i).getConsumoTotal() == 0) {
                System.out.println("\n🟠 Apenas " + i++ + " clientes consumiram nosos produtos e serviços!"); 
                break;
            } else {
                System.out.println("\n#️⃣  Cliente Nº " + Integer.sum(i, 1));
                this.impressao = new ImpressaoCLICliente(clientes.get(i));
                impressao.imprimir();
            }
            
        }
    }

}
