package com.wb.negocio;

import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class ImpressaoCLICliente implements ImpressaoCLI {
    Cliente cliente;
    
    public ImpressaoCLICliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void imprimir() {
        System.out.println("\nð¸ Nome: " + cliente.nome);
        System.out.println("ð¸ Nome social: " + cliente.nomeSocial);
        System.out.println("ð¸ GÃªnero: " + cliente.getGenero());
        System.out.println("ð¸ CPF: " + cliente.getCpf().getValor());
        
        for(RG rg : cliente.getRgs()) {
            System.out.println("ð¸ RG: " + rg.getValor());
        }
        for(Telefone t : cliente.getTelefones()) {
            System.out.println("ð¸ Telefone: " + '(' + t.getDdd() + ')' + ' ' + t.getNumero());
        }
        if (cliente.getConsumoTotal() == null) {
            System.out.println("ð¹ Consumo total: R$ 0.00"); 
        } else {
            System.out.println("ð¹ Consumo total: R$ " + cliente.getConsumoTotal()); 
        }
        
    }
}
