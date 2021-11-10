package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Telefone;

public class EdicaoTelefone extends Edicao{
    private List<Telefone> telefones;

    public EdicaoTelefone(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public void editar() {
        int i = 0;
        for (Telefone telefone : telefones) {
            System.out.println("🔸 [" + i+1 + "] " + "(" + telefone.getDdd() + ") " + telefone.getNumero());
            ++i;
        }
        System.out.print("\n🟡 Qual telefone deseja editar? ");
        Entrada entrada = new Entrada();
        int operacao = entrada.receberNumeroInteiro();
        while (operacao < 1 || operacao > telefones.size()) {
            System.out.println("\n❌ Telefone inválido! Tente novamente.");
            System.out.print("\n🟡 Qual telefone deseja editar? ");
            operacao = entrada.receberNumeroInteiro();
        }
        telefones.remove(operacao-1);
        System.out.print("\nℹ️  DDD: ");
        Entrada novaEntrada = new Entrada();
		String ddd = novaEntrada.receberTexto();
		System.out.print("ℹ️  Número: ");
		String numero = novaEntrada.receberTexto();
		Telefone novoTel = new Telefone(ddd, numero);
        telefones.add(novoTel);
        System.out.println("\n✅ Telefone editado com sucesso!\n");
    }
    
}
