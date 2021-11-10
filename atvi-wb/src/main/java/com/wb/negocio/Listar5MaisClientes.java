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
        if (clientes.size() > 5) {
            for (int i = 0; i < 5; ++i) {
                System.out.println("\n#️⃣ Cliente Nº " + i+1);
                this.impressao = new ImpressaoCLICliente(clientes.get(i));
                impressao.imprimir();
            }
        } else {
            int c = 1;
            for(Cliente cliente : clientes) {
                System.out.println("\n#️⃣ Cliente Nº " + c);
                this.impressao = new ImpressaoCLICliente(cliente);
                impressao.imprimir();
                c+=1;
            }
        }
    }

}
