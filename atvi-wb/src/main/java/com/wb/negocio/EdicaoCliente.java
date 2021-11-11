package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Telefone;

public class EdicaoCliente extends Edicao{
    private Cliente cliente;

    public EdicaoCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void editar() {
        System.out.println("\n🖊️  EDITAR CLIENTE");
        boolean execucao = true;
        while (execucao) {
            System.out.println("\n🔵 Editar:\n");
			System.out.println("1️⃣  - Nome");
			System.out.println("2️⃣  - Nome Social");
			System.out.println("3️⃣  - CPF");
			System.out.println("4️⃣  - Gênero");
			System.out.println("5️⃣  - Telefone");
            System.out.println("6️⃣  - Sair");
            System.out.print("\n🟡 Qual operação deseja realizar? ");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();
            switch (operacao) {
                case 1:
                    Entrada entradaNome = new Entrada();
                    System.out.print("\nℹ️  Novo nome: ");
                    String nome = entradaNome.receberTexto();
                    cliente.nome = nome;
                    System.out.println("\n✅ Nome editado com sucesso!\n");
                    break;
                case 2:
                    Entrada entradaNomeSocial = new Entrada();
                    System.out.print("\nℹ️  Novo nome social: ");
                    String nomeSocial = entradaNomeSocial.receberTexto();
                    cliente.nomeSocial = nomeSocial;
                    System.out.println("\n✅ Nome social editado com sucesso!\n");
                    break;
                case 3:
                    entrada = new Entrada();
                    System.out.print("\nℹ️  CPF: ");
                    String valor = entrada.receberTexto();
                    System.out.print("ℹ️  Data de Emissão CPF [dd/mm/yyyy]: ");
                    String data = entrada.receberTexto();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataEmissao = LocalDate.parse(data, formato);
                    CPF cpf = new CPF(dataEmissao, valor);
                    cliente.setCpf(cpf);
                    System.out.println("\n✅ CPF editado com sucesso!");
                    break;
                case 4:
                    String g = "";
                    boolean exec = true;
                    while (exec) {
                        System.out.println("\n🟡 Gênero: ");
                        System.out.print("\n1️⃣  - Masculino\n2️⃣  - Feminino\n3️⃣  - Outro\n");
                        System.out.print("\n🟡 Operação desejada: ");
                        int operacaoGenero = entrada.receberNumeroInteiro();
                        switch (operacaoGenero) {
                            case 1:
                                g = "M";
                                exec = false;
                                break;
                            case 2:
                                g = "F";
                                exec = false;
                                break;
                            case 3:
                                g = "T";
                                exec = false;
                                break;
                            default:
                                break;
                        }
                    }
                    cliente.setGenero(g);
                    System.out.println("\n✅ Gênero editado com sucesso!");
                    break;
                case 5:
                    boolean execEdicaoTel = true;
                    while (execEdicaoTel) {
                        System.out.println("\n🔵 Ações:\n");
                        System.out.println("1️⃣  - Editar telefone");
                        System.out.println("2️⃣  - Adicionar telefone");
                        System.out.println("3️⃣  - Apagar telefone");
                        System.out.println("4️⃣  - Voltar");
                        System.out.print("\n🟡 Qual operação deseja realizar? ");
                        Entrada entradaEdicaoTel = new Entrada();
                        int operacaoTel = entradaEdicaoTel.receberNumeroInteiro(); 
                        switch (operacaoTel) {
                            case 1:
                                Edicao edicaoTel = new EdicaoTelefone(cliente.getTelefones());
                                edicaoTel.editar();
                                break;
                            case 2:
                                Cadastro cadastroTel = new CadastroTelefone(cliente.getTelefones());
                                cadastroTel.cadastrar();
                                break;
                            case 3:
                                int i = 0;
                                System.out.println("\n📞 Telefones:\n");
                                for (Telefone telefone : cliente.getTelefones()) {
                                    System.out.println("🔸 [" + Integer.sum(i,1) + "] " + "(" + telefone.getDdd() + ") " + telefone.getNumero());
                                    ++i;
                                }
                                System.out.print("\n🟡 Qual telefone deseja deletar? ");
                                Entrada entradaDelTel = new Entrada();
                                int operacaoDelTel = entradaDelTel.receberNumeroInteiro();
                                while (operacaoDelTel < 1 || operacaoDelTel > cliente.getTelefones().size()) {
                                    System.out.println("\n❌ Telefone inválido! Tente novamente.");
                                    System.out.print("\n🟡 Qual telefone deseja deletar? ");
                                    operacaoDelTel = entrada.receberNumeroInteiro();
                                }
                                cliente.getTelefones().remove(operacaoDelTel-1);
                                System.out.println("\n✅ Telefone deletado com sucesso!");
                                break;
                            case 4:
                                execEdicaoTel = false;
                                break;
                            default:
                                System.out.println("\n🚫 Operação inválida!\n");
                        }
                    }
                    break;
                case 6:
                    execucao = false;
                    break;
                default:
                    System.out.println("\n🚫 Operação inválida!\n");
            }
        }
    }
    
}
