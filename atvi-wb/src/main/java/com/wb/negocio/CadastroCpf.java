package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;

public class CadastroCpf extends Cadastro {
    private Cliente cliente;
	private Entrada entrada;

    public CadastroCpf(Cliente cliente) {
        this.cliente = cliente;
        this.entrada = new Entrada();
    }

    @Override
    public void cadastrar() {
        System.out.println("\n🗄️ CADASTRO DE CPF");
        System.out.print("\nℹ️  CPF: ");
		String valorRg = entrada.receberTexto();
		
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("ℹ️  Data de Emissão CPF [dd/mm/yyyy]: ");
		        String dataRg = entrada.receberTexto();
		        DateTimeFormatter formatoRg = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataEmissaoRg = LocalDate.parse(dataRg, formatoRg);
                CPF cpf = new CPF(dataEmissaoRg, valorRg);
		        this.cliente.setCpf(cpf);
		        System.out.println("\n✅ CPF cadastrado com sucesso!");
                isValid = true;
            }
            catch(Exception e) {
                System.out.println("\n🚫 Data de emissão de CPF inválida!");
                System.out.println("\n🟡 Utilize o padrão sugerido como exemplo a seguir: 01/01/2021\n");
            }
        }
    }
    
}
