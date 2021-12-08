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
        System.out.println("\n📞 Telefones:\n");
        for (Telefone telefone : telefones) {
            System.out.println("🔸 [" + Integer.sum(i,1) + "] " + "(" + telefone.getDdd() + ") " + telefone.getNumero());
            ++i;
        }
        System.out.print("\n🟡 Qual telefone deseja editar?");
        Entrada entrada = new Entrada();

        boolean flag = true;
        while (flag) {
            String operacao = entrada.receberTexto();
            if (operacao != null && operacao.matches("[0-9.]+")) {
                int op = Integer.parseInt(operacao);
                if (op > telefones.size() || op ==  0) {
                    System.out.println("\n❌ Telefone inválido! Tente novamente.");
                    System.out.print("\n🟡 Qual Telefone deseja editar? ");
                } else {
                    telefones.remove(op-1);
                    flag = false;
                }
            } else {
                System.out.println("\n❌ Telefone inválido! Tente novamente.");
                System.out.print("\n🟡 Qual Telefone deseja editar? ");
            }
        }

        Cadastro cadastroTel = new CadastroTelefone(telefones);
		cadastroTel.cadastrar();

        System.out.println("\n✅ Telefone editado com sucesso!");
    }
}
