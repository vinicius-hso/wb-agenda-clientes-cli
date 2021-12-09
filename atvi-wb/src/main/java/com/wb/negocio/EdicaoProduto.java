package com.wb.negocio;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class EdicaoProduto extends Edicao {
    private Produto produto;

    public EdicaoProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public void editar() {
        
        System.out.println("\n🖊️  EDITAR PRODUTO/SERVIÇO");
        boolean execucao = true;
        while (execucao) {
            System.out.println("\n🔵 Editar:\n");
            System.out.println("1️⃣  - Tipo");
            System.out.println("2️⃣  - Categoria");
			System.out.println("3️⃣  - Nome");
			System.out.println("4️⃣  - Preço");
			System.out.println("5️⃣  - Código");
            System.out.println("6️⃣  - Sair");
            System.out.print("\n🟡 Qual operação deseja realizar? ");

			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
            switch (operacao) {
                case "1":
                    String tipo = "";
                    boolean exec = true;
                    while (exec) {
                        System.out.println("\n🟡 Tipo: ");
                        System.out.print("\n1️⃣  - Produto\n2️⃣  - Serviço\n");
                        System.out.print("\n🟡 Operação desejada: ");
                        String operacaoGenero = entrada.receberTexto();
                        switch (operacaoGenero) {
                            case "1":
                                tipo = "Produto";
                                exec = false;
                                break;
                            case "2":
                                tipo = "Serviço";
                                exec = false;
                                break;
                            default:
                                System.out.println("\n🚫 Operação inválida!\n");
                        }
                    }
                    produto.setTipo(tipo);
                    System.out.println("\n✅ Tipo editado com sucesso!");
                    break;
                case "2":
                    String categoria = "";
                    boolean execCategoria = true;
                    while (execCategoria) {
                        System.out.println("\n🟡 Categoria: ");
                        System.out.print("\n1️⃣  - Masculino\n2️⃣  - Feminino\n3️⃣  - Unisex\n");
                        System.out.print("\n🟡 Operação desejada: ");
                        
                        String operacaoGenero = entrada.receberTexto();
                        switch (operacaoGenero) {
                            case "1":
                                categoria = "Masculino";
                                execCategoria = false;
                                break;
                            case "2":
                                categoria = "Feminino";
                                execCategoria = false;
                                break;
                            case "3":
                                categoria = "Unisex";
                                execCategoria = false;
                                break;
                            default:
                                System.out.println("\n🚫 Operação inválida!"); }
                    }
                    produto.setCategoria(categoria);
                    System.out.println("\n✅ Categoria editado com sucesso!");
                    break;
                case "3":
                    Entrada entradaNome = new Entrada();
                    System.out.print("\nℹ️  Novo nome: ");
                    String nome = entradaNome.receberTexto();
                    produto.nome = nome;
                    System.out.println("\n✅ Nome editado com sucesso!");
                    break;
                case "4":
                    boolean execPreco = true;
                    while (execPreco) {
                        try {
                            Entrada entradaPreco = new Entrada();
                            System.out.print("\nℹ️  Novo preço: R$ ");
                            String p = entradaPreco.receberTexto();
                            Double preco = Double.parseDouble(p);
                            produto.preco = preco;
                            System.out.println("\n✅ Preço editado com sucesso!");
                            execPreco = false;
                        } catch (Exception e) {
                            System.out.println("\n❌ Preço inválido! Tente novamente.");
                            System.out.println("\n🟡 Utilize PONTO para separar os centavos como no exemplo a seguir: 42.00");
                        }
                    }
                    break;
                case "5":
                    Entrada entradaCod = new Entrada();
                    System.out.print("\nℹ️  Novo código: ");
                    String codigo = entradaCod.receberTexto();
                    produto.codigo = codigo;
                    System.out.println("\n✅ Código editado com sucesso!");
                    break;
                case "6":
                    execucao = false;
                    break;
                default:
                    System.out.println("\n🚫 Operação inválida!");
            }
        }
    }
    
}
