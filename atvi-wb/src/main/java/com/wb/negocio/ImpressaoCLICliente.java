package com.wb.negocio;

import com.wb.modelo.Cliente;
import com.wb.modelo.Telefone;

public class ImpressaoCLICliente implements ImpressaoCLI {
    Cliente cliente;
    
    public ImpressaoCLICliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void imprimir() {
        System.out.println("\n🔸 Nome: " + cliente.nome);
        System.out.println("🔸 Nome social: " + cliente.nomeSocial);
        System.out.println("🔸 CPF: " + cliente.getCpf().getValor());
        System.out.println("🔸 Gênero: " + cliente.getGenero());
        for(Telefone t : cliente.getTelefones()) {
            System.out.println("🔸 Telefone: " + '(' + t.getDdd() + ')' + ' ' + t.getNumero());
        }
        if (cliente.getConsumoTotal() == null) {
            System.out.println("🔹 Consumo total: R$ 0.00"); 
        } else {
            System.out.println("🔹 Consumo total: R$ " + cliente.getConsumoTotal()); 
        }
        
    }
}
