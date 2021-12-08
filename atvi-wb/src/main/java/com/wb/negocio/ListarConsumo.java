package com.wb.negocio;

import java.util.List;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;
// import com.wb.modelo.ProdutoConsumido;

public class ListarConsumo extends Listagem {
    private List<Consumo> consumos;

    public ListarConsumo(List<Consumo> consumos) {
        this.consumos = consumos;
    }

    @Override
    public void listar() {

        if (consumos.isEmpty()) {
            System.out.println("\n🔴 Ainda não há registro de consumo de produtos & serviços!");
        } else {
            System.out.println("\n🗒️ LISTA DE CONSUMOS:");
            int c = 1;
            for (Consumo consumo : consumos) {
                System.out.println("\n#️⃣  Venda Nº " + c);
                c += 1;
                System.out.print("\n🔹 Cliente: " + consumo.getCliente().nome);
                System.out.print("\n🔹 Valor: R$ " + consumo.getPrecoTotal());
                System.out.println("\n🔹 Data: " + consumo.getDataConsumo());
                for (Produto prodCons : consumo.getProdutosConsumidos()) {
                    System.out.print("\n🔸 Produto: " + prodCons.getNome());
                    System.out.println("\n🔸 Preço: R$ " + prodCons.getPreco());
                }
            }
        }
    }
}
