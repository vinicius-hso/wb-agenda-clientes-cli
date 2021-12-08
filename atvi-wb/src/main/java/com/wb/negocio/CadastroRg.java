package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.RG;

public class CadastroRg extends Cadastro {
    private List<RG> rgs;
	private Entrada entrada;

    public CadastroRg(List<RG> rgs) {
        this.rgs = rgs;
        this.entrada = new Entrada();
    }

    @Override
    public void cadastrar() {
        System.out.println("\n🗄️ CADASTRO DE RG");
        System.out.print("\nℹ️  RG: ");
		String valorRg = entrada.receberTexto();
		System.out.print("ℹ️  Data de Emissão RG [dd/mm/yyyy]: ");
		String dataRg = entrada.receberTexto();
		DateTimeFormatter formatoRg = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissaoRg = LocalDate.parse(dataRg, formatoRg);
		RG rg = new RG(dataEmissaoRg, valorRg);
		this.rgs.add(rg);
		System.out.println("\n✅ RG cadastrado com sucesso!\n");
        
    }
    
}
