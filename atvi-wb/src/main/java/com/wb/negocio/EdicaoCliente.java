package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
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
            System.out.println("3️⃣  - Gênero");
            System.out.println("4️⃣  - CPF");
            System.out.println("5️⃣  - RG");
            System.out.println("6️⃣  - Telefone");
            System.out.println("7️⃣  - Sair");
            System.out.print("\n🟡 Qual operação deseja realizar? ");

			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
            switch (operacao) {
                case "1":
                    Entrada entradaNome = new Entrada();
                    System.out.print("\nℹ️  Novo nome: ");
                    String nome = entradaNome.receberTexto();
                    cliente.nome = nome;
                    System.out.println("\n✅ Nome editado com sucesso!");
                    break;
                case "2":
                    Entrada entradaNomeSocial = new Entrada();
                    System.out.print("\nℹ️  Novo nome social: ");
                    String nomeSocial = entradaNomeSocial.receberTexto();
                    cliente.nomeSocial = nomeSocial;
                    System.out.println("\n✅ Nome social editado com sucesso!");
                    break;
                case "3":
                    String g = "";
                    boolean exec = true;
                    while (exec) {
                        System.out.println("\n🟡 Gênero: ");
                        System.out.print("\n1️⃣  - Masculino\n2️⃣  - Feminino\n3️⃣  - Outro\n");
                        System.out.print("\n🟡 Operação desejada: ");
                        String operacaoGenero = entrada.receberTexto();
                        switch (operacaoGenero) {
                            case "1":
                                g = "M";
                                exec = false;
                                break;
                            case "2":
                                g = "F";
                                exec = false;
                                break;
                            case "3":
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
                case "4":
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
                case "5":
                    boolean execEdicaoRg = true;
                    while (execEdicaoRg) {
                        System.out.println("\n🔵 Ações:\n");
                        System.out.println("1️⃣  - Editar RG");
                        System.out.println("2️⃣  - Adicionar RG");
                        System.out.println("3️⃣  - Apagar RG");
                        System.out.println("4️⃣  - Voltar");
                        System.out.print("\n🟡 Qual operação deseja realizar? ");
                        Entrada entradaEdicaoRg = new Entrada();
                        String operacaoRg = entradaEdicaoRg.receberTexto(); 
                        switch (operacaoRg) {
                            case "1":
                                Edicao edicaoRg = new EdicaoRg(cliente.getRgs());
                                edicaoRg.editar();
                                break;
                            case "2":
                                Cadastro cadastroRg = new CadastroRg(cliente.getRgs());
                                cadastroRg.cadastrar();
                                break;
                            case "3":
                                int i = 0;
                                System.out.println("\n📞 RGs:\n");
                                for (RG rg : cliente.getRgs()) {
                                    System.out.println("🔸 [" + Integer.sum(i,1) + "] " + rg.getValor());
                                    ++i;
                                }
                                System.out.print("\n🟡 Qual RG deseja deletar? ");
                                Entrada entradaDelRg = new Entrada();

                                boolean flag = true;
                                while (flag) {
                                    String operacaoDelRg = entradaDelRg.receberTexto();
                                    if (operacaoDelRg != null && operacaoDelRg.matches("[0-9.]+")) {
                                        int op = Integer.parseInt(operacaoDelRg);
                                        if (op > cliente.getRgs().size() || op == 0) {
                                            System.out.println("\n❌ RG inválido! Tente novamente.");
                                            System.out.print("\n🟡 Qual RG deseja deletar? ");
                                        } else {
                                            cliente.getRgs().remove(op-1);
                                            System.out.println("\n✅ RG deletado com sucesso!");
                                            flag = false;
                                        }
                                    } else {
                                        System.out.println("\n❌ RG inválido! Tente novamente.");
                                        System.out.print("\n🟡 Qual RG deseja deletar?");
                                    }
                                }
                                break;
                            case "4":
                                execEdicaoRg = false;
                                break;
                            default:
                                System.out.println("\n🚫 Operação inválida!");
                        }
                    }
                    break;
                case "6":
                    boolean execEdicaoTel = true;
                    while (execEdicaoTel) {
                        System.out.println("\n🔵 Ações:\n");
                        System.out.println("1️⃣  - Editar telefone");
                        System.out.println("2️⃣  - Adicionar telefone");
                        System.out.println("3️⃣  - Apagar telefone");
                        System.out.println("4️⃣  - Voltar");
                        System.out.print("\n🟡 Qual operação deseja realizar? ");
                        Entrada entradaEdicaoTel = new Entrada();
                        String operacaoTel = entradaEdicaoTel.receberTexto(); 
                        switch (operacaoTel) {
                            case "1":
                                Edicao edicaoTel = new EdicaoTelefone(cliente.getTelefones());
                                edicaoTel.editar();
                                break;
                            case "2":
                                Cadastro cadastroTel = new CadastroTelefone(cliente.getTelefones());
                                cadastroTel.cadastrar();
                                System.out.println("\n✅ Telefone cadastrado com sucesso!");
                                break;
                            case "3":
                                int i = 0;
                                System.out.println("\n📞 Telefones:\n");
                                for (Telefone telefone : cliente.getTelefones()) {
                                    System.out.println("🔸 [" + Integer.sum(i,1) + "] " + "(" + telefone.getDdd() + ") " + telefone.getNumero());
                                    ++i;
                                }
                                System.out.print("\n🟡 Qual telefone deseja deletar? ");
                                Entrada entradaDelTel = new Entrada();

                                boolean flagTel = true;
                                while (flagTel) {
                                    String operacaoDelTel = entradaDelTel.receberTexto();
                                    if (operacaoDelTel != null && operacaoDelTel.matches("[0-9.]+")) {
                                        int op = Integer.parseInt(operacaoDelTel);
                                        if (op > cliente.getTelefones().size() || op == 0) {
                                            System.out.println("\n❌ Telefone inválido! Tente novamente.");
                                            System.out.print("\n🟡 Qual telefone deseja deletar? ");
                                        } else {
                                            cliente.getTelefones().remove(op-1);
                                            System.out.println("\n✅ Telefone deletado com sucesso!");
                                            flagTel = false;
                                        }
                                    } else {
                                        System.out.println("\n❌ Telefone inválido! Tente novamente.");
                                        System.out.print("\n🟡 Qual telefone deseja deletar? ");
                                    }
                                }
                                break;
                            case "4":
                                execEdicaoTel = false;
                                break;
                            default:
                                System.out.println("\n🚫 Operação inválida!");
                        }
                    }
                    break;
                case "7":
                    execucao = false;
                    break;
                default:
                    System.out.println("\n🚫 Operação inválida!");
            }
        }
    }
    
}
