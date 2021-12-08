package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;

public class CadastroCpf extends Cadastro {
    private Cliente cliente;
    // private CPF cpf;;
	private Entrada entrada;

    public CadastroCpf(Cliente cliente) {
        this.cliente = cliente;
        // this.cpf = cpf;
        this.entrada = new Entrada();
    }

    @Override
    public void cadastrar() {
        System.out.println("\n🗄️ CADASTRO DE CPF");
        System.out.print("\nℹ️  CPF: ");
		String valorRg = entrada.receberTexto();
		System.out.print("ℹ️  Data de Emissão CPF [dd/mm/yyyy]: ");
		String dataRg = entrada.receberTexto();
		DateTimeFormatter formatoRg = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissaoRg = LocalDate.parse(dataRg, formatoRg);
		CPF cpf = new CPF(dataEmissaoRg, valorRg);
		this.cliente.setCpf(cpf);
		System.out.println("\n✅ CPF cadastrado com sucesso!\n");
        
    }
    
}
