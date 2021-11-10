package com.wb.negocio;

import java.util.Comparator;
import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;

public class ComparadorValorConsumo implements Comparator<Cliente> {

    public int compare(Cliente o1, Cliente o2) {
        return o1.getConsumoTotal().compareTo(o2.getConsumoTotal());
    }

    // private Double valorTotal(List<Consumo> consumos) {
    //     Double valorTotal = 0.0;

    //     return valorTotal;
    // }
    
}