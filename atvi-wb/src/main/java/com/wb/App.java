package com.wb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;
import com.wb.negocio.Busca;
import com.wb.negocio.BuscaCliente;
import com.wb.negocio.BuscaProduto;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroConsumo;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarConsumo;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosProdutos;

public class App {
	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		boolean execucao = true;

		//* PRRODUTOS
		Produto p1 = new Produto("Clareador", 18.99, "Feminino", "0", "Produto");
		empresa.getProdutos().add(p1);
		Produto p2 = new Produto("Água oxigenada", 2.99, "Feminino", "1", "Produto");
		empresa.getProdutos().add(p2);
		Produto p3 = new Produto("Pó descolorante", 24.69, "Feminino", "2", "Produto");
		empresa.getProdutos().add(p3);
		Produto p4 = new Produto("Tonalizante", 32.09, "Feminino", "3", "Produto");
		empresa.getProdutos().add(p4);
		Produto p5 = new Produto("Coloração", 30.79, "Feminino", "4", "Produto");
		empresa.getProdutos().add(p5);
		Produto p6 = new Produto("Sabonete em barra", 2.89, "Masculino", "5", "Produto");
		empresa.getProdutos().add(p6);
		Produto p7 = new Produto("Protetor solar facial", 33.33, "Masculino", "6", "Produto");
		empresa.getProdutos().add(p7);
		Produto p8 = new Produto("Pomada modeladora", 10.49, "Masculino", "7", "Produto");
		empresa.getProdutos().add(p8);
		Produto p9 = new Produto("Loção autobronzeadora", 29.29, "Masculino", "8", "Produto");
		empresa.getProdutos().add(p9);
		Produto p10 = new Produto("Óleo para barba", 21.49, "Masculino", "10", "Produto");
		empresa.getProdutos().add(p10);
		
		Produto p11 = new Produto("Corte", 195.00, "Feminino", "11", "Serviço");
		empresa.getProdutos().add(p11);
		Produto p12 = new Produto("Pintura", 281.00, "Feminino", "12", "Serviço");
		empresa.getProdutos().add(p12);
		Produto p13 = new Produto("Manicure comum", 30.00, "Feminino", "13", "Serviço");
		empresa.getProdutos().add(p13);
		Produto p14 = new Produto("Pedicure comum", 32.00, "Feminino", "14", "Serviço");
		empresa.getProdutos().add(p14);
		Produto p15 = new Produto("Sobrancelha", 25.00, "Feminino", "15", "Serviço");
		empresa.getProdutos().add(p15);
		Produto p16 = new Produto("Depilação de axila", 16.00, "Feminino", "16", "Serviço");
		empresa.getProdutos().add(p16);
		Produto p17 = new Produto("Depilação de buço", 15.00, "Feminino", "17", "Serviço");
		empresa.getProdutos().add(p17);
		Produto p18 = new Produto("Depilação meia perna", 25.00, "Feminino", "18", "Serviço");
		empresa.getProdutos().add(p18);
		Produto p19 = new Produto("Corte", 145.00, "Masculino", "19", "Serviço");
		empresa.getProdutos().add(p19);
		Produto p20 = new Produto("Barba e bigode", 40.00, "Masculino", "20", "Serviço");
		empresa.getProdutos().add(p20);

		Produto p21 = new Produto("Remoção de rugas", 200.00, "Unisex", "21", "Serviço");
		empresa.getProdutos().add(p21);
		Produto p22 = new Produto("Remoção de manchas na pele", 150.00, "Unisex", "22", "Serviço");
		empresa.getProdutos().add(p22);
		Produto p23 = new Produto("Aplicação de botox", 299.00, "Unisex", "23", "Serviço");
		empresa.getProdutos().add(p23);
		Produto p24 = new Produto("Tratamento para emagrecimento e redução de medidas", 200.00, "Unisex", "24", "Serviço");
		empresa.getProdutos().add(p24);

		//* CLIENTES
		// //* #1
		List<Telefone> tels1 = new ArrayList<Telefone>();
		String d1 = "01/01/2001";
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao1 = LocalDate.parse(d1, f1);
		CPF cpf1 = new CPF(dataEmissao1, "12345678901");
		Telefone tel1 = new Telefone("12", "987654321");
		tels1.add(tel1);
		List<RG> rgs1 = new ArrayList<RG>();
		RG rg1 = new RG(dataEmissao1, "98765432101");
		rgs1.add(rg1);
		Cliente c1 = new Cliente("Amanda Gomes", "Amanda", "Feminino", cpf1);
		c1.setRgs(rgs1);
		c1.setTels(tels1);
		empresa.getClientes().add(c1);
		// //* #2
		List<Telefone> tels2 = new ArrayList<Telefone>();
		String d2 = "02/01/2001";
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao2 = LocalDate.parse(d2, f2);
		CPF cpf2 = new CPF(dataEmissao2, "12345678902");
		Telefone tel2 = new Telefone("12", "987654322");
		tels2.add(tel2);
		List<RG> rgs2 = new ArrayList<RG>();
		RG rg2 = new RG(dataEmissao2, "98765432102");
		rgs2.add(rg2);
		Cliente c2 = new Cliente("Bruna Hernandez", "Bruna", "Feminino", cpf2);
		c2.setRgs(rgs2);
		c2.setTels(tels2);
		empresa.getClientes().add(c2);
		// //* #3
		List<Telefone> tels3 = new ArrayList<Telefone>();
		String d3 = "03/01/2001";
		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao3 = LocalDate.parse(d3, f3);
		CPF cpf3 = new CPF(dataEmissao3, "12345678903");
		Telefone tel3 = new Telefone("12", "987654323");
		tels3.add(tel3);
		List<RG> rgs3 = new ArrayList<RG>();
		RG rg3 = new RG(dataEmissao3, "98765432103");
		rgs3.add(rg3);
		Cliente c3 = new Cliente("Carla Ivone", "Carla", "Feminino", cpf3);
		c3.setRgs(rgs3);
		c3.setTels(tels3);
		empresa.getClientes().add(c3);
		// //* #4
		List<Telefone> tels4 = new ArrayList<Telefone>();
		String d4 = "04/01/2001";
		DateTimeFormatter f4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao4 = LocalDate.parse(d4, f4);
		CPF cpf4 = new CPF(dataEmissao4, "12345678904");
		Telefone tel4 = new Telefone("12", "987654324");
		tels4.add(tel4);
		List<RG> rgs4 = new ArrayList<RG>();
		RG rg4 = new RG(dataEmissao4, "98765432104");
		rgs4.add(rg4);
		Cliente c4 = new Cliente("Daniela Johnson", "Dani", "Feminino", cpf4);
		c4.setRgs(rgs4);
		c4.setTels(tels4);
		empresa.getClientes().add(c4);
		// //* #5
		List<Telefone> tels5 = new ArrayList<Telefone>();
		String d5 = "05/01/2001";
		DateTimeFormatter f5 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao5 = LocalDate.parse(d5, f5);
		CPF cpf5 = new CPF(dataEmissao5, "12345678905");
		Telefone tel5 = new Telefone("12", "987654325");
		tels5.add(tel5);
		List<RG> rgs5 = new ArrayList<RG>();
		RG rg5 = new RG(dataEmissao5, "98765432105");
		rgs5.add(rg5);
		Cliente c5 = new Cliente("Ester Kruzinsky", "Ester", "Feminino", cpf5);
		c5.setRgs(rgs5);
		c5.setTels(tels5);
		empresa.getClientes().add(c5);
		// //* #6
		List<Telefone> tels6 = new ArrayList<Telefone>();
		String d6 = "06/01/2001";
		DateTimeFormatter f6 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao6 = LocalDate.parse(d6, f6);
		CPF cpf6 = new CPF(dataEmissao6, "12345678906");
		Telefone tel6 = new Telefone("12", "987654326");
		tels6.add(tel6);
		List<RG> rgs6 = new ArrayList<RG>();
		RG rg6 = new RG(dataEmissao6, "98765432106");
		rgs6.add(rg6);
		Cliente c6 = new Cliente("Fabia Lima", "Fabia", "Feminino", cpf6);
		c6.setRgs(rgs6);
		c6.setTels(tels6);
		empresa.getClientes().add(c6);
		// //* #7
		List<Telefone> tels7 = new ArrayList<Telefone>();
		String d7 = "07/01/2001";
		DateTimeFormatter f7 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao7 = LocalDate.parse(d7, f7);
		CPF cpf7 = new CPF(dataEmissao7, "12345678907");
		Telefone tel7 = new Telefone("12", "987654327");
		tels7.add(tel7);
		List<RG> rgs7 = new ArrayList<RG>();
		RG rg7 = new RG(dataEmissao7, "98765432107");
		rgs7.add(rg7);
		Cliente c7 = new Cliente("Gabrielle Magalhães", "Ester", "Feminino", cpf7);
		c7.setRgs(rgs7);
		c7.setTels(tels7);
		empresa.getClientes().add(c7);
		// //* #8
		List<Telefone> tels8 = new ArrayList<Telefone>();
		String d8 = "08/01/2001";
		DateTimeFormatter f8 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao8 = LocalDate.parse(d8, f8);
		CPF cpf8 = new CPF(dataEmissao8, "12345678908");
		Telefone tel8 = new Telefone("12", "987654328");
		tels8.add(tel8);
		List<RG> rgs8 = new ArrayList<RG>();
		RG rg8 = new RG(dataEmissao8, "98765432108");
		rgs8.add(rg8);
		Cliente c8 = new Cliente("Hellen Nogueira", "Hellen", "Feminino", cpf8);
		c8.setRgs(rgs8);
		c8.setTels(tels8);
		empresa.getClientes().add(c8);
		// //* #9
		List<Telefone> tels9 = new ArrayList<Telefone>();
		String d9 = "09/01/2001";
		DateTimeFormatter f9 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao9 = LocalDate.parse(d9, f9);
		CPF cpf9 = new CPF(dataEmissao9, "12345678909");
		Telefone tel9 = new Telefone("12", "987654329");
		tels9.add(tel9);
		List<RG> rgs9 = new ArrayList<RG>();
		RG rg9 = new RG(dataEmissao9, "98765432109");
		rgs9.add(rg9);
		Cliente c9 = new Cliente("Irene Oliveira", "Irene", "Feminino", cpf9);
		c9.setRgs(rgs9);
		c9.setTels(tels9);
		empresa.getClientes().add(c9);
		// //* #10
		List<Telefone> tels10 = new ArrayList<Telefone>();
		String d10 = "10/01/2001";
		DateTimeFormatter f10 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao10 = LocalDate.parse(d10, f10);
		CPF cpf10 = new CPF(dataEmissao10, "12345678910");
		Telefone tel10 = new Telefone("12", "987654310");
		tels10.add(tel10);
		List<RG> rgs10 = new ArrayList<RG>();
		RG rg10 = new RG(dataEmissao10, "98765432110");
		rgs10.add(rg10);
		Cliente c10 = new Cliente("Julia Pereira", "Ju", "Feminino", cpf10);
		c10.setRgs(rgs10);
		c10.setTels(tels10);
		empresa.getClientes().add(c10);
		// //* #11
		List<Telefone> tels11 = new ArrayList<Telefone>();
		String d11 = "11/01/2001";
		DateTimeFormatter f11 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao11 = LocalDate.parse(d11, f11);
		CPF cpf11 = new CPF(dataEmissao11, "12345678911");
		Telefone tel11 = new Telefone("12", "987654311");
		tels11.add(tel11);
		List<RG> rgs11 = new ArrayList<RG>();
		RG rg11 = new RG(dataEmissao11, "98765432111");
		rgs11.add(rg11);
		Cliente c11 = new Cliente("Kleber Rodrigues", "Kleber", "Masculino", cpf11);
		c11.setRgs(rgs11);
		c11.setTels(tels11);
		empresa.getClientes().add(c11);
		// //* #12
		List<Telefone> tels12 = new ArrayList<Telefone>();
		String d12 = "12/01/2001";
		DateTimeFormatter f12 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao12 = LocalDate.parse(d12, f12);
		CPF cpf12 = new CPF(dataEmissao12, "12345678912");
		Telefone tel12 = new Telefone("12", "987654312");
		tels12.add(tel12);
		List<RG> rgs12 = new ArrayList<RG>();
		RG rg12 = new RG(dataEmissao12, "98765432112");
		rgs12.add(rg12);
		Cliente c12 = new Cliente("Lucas Rory", "Kleber", "Masculino", cpf12);
		c12.setRgs(rgs12);
		c12.setTels(tels12);
		empresa.getClientes().add(c12);
		// //* #13
		List<Telefone> tels13 = new ArrayList<Telefone>();
		String d13 = "13/01/2001";
		DateTimeFormatter f13 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao13 = LocalDate.parse(d13, f13);
		CPF cpf13 = new CPF(dataEmissao13, "12345678913");
		Telefone tel13 = new Telefone("12", "987654313");
		tels13.add(tel13);
		List<RG> rgs13 = new ArrayList<RG>();
		RG rg13 = new RG(dataEmissao13, "98765432113");
		rgs13.add(rg13);
		Cliente c13 = new Cliente("Marcelo Silva", "Marcelo", "Masculino", cpf13);
		c13.setRgs(rgs13);
		c13.setTels(tels13);
		empresa.getClientes().add(c13);
		// //* #14
		List<Telefone> tels14 = new ArrayList<Telefone>();
		String d14 = "14/01/2001";
		DateTimeFormatter f14 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao14 = LocalDate.parse(d14, f14);
		CPF cpf14 = new CPF(dataEmissao14, "12345678914");
		Telefone tel14 = new Telefone("12", "987654314");
		tels14.add(tel14);
		List<RG> rgs14 = new ArrayList<RG>();
		RG rg14 = new RG(dataEmissao14, "98765432114");
		rgs14.add(rg14);
		Cliente c14 = new Cliente("Nelson Teotônio", "Nelson", "Masculino", cpf14);
		c14.setRgs(rgs14);
		c14.setTels(tels14);
		empresa.getClientes().add(c14);
		// //* #15
		List<Telefone> tels15 = new ArrayList<Telefone>();
		String d15 = "15/01/2001";
		DateTimeFormatter f15 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao15 = LocalDate.parse(d15, f15);
		CPF cpf15 = new CPF(dataEmissao15, "12345678915");
		Telefone tel15 = new Telefone("12", "987654315");
		tels15.add(tel15);
		List<RG> rgs15 = new ArrayList<RG>();
		RG rg15 = new RG(dataEmissao15, "98765432115");
		rgs15.add(rg15);
		Cliente c15 = new Cliente("Otávio Albuquerque", "Otávio", "Masculino", cpf15);
		c15.setRgs(rgs15);
		c15.setTels(tels15);
		empresa.getClientes().add(c15);
		// //* #16
		List<Telefone> tels16 = new ArrayList<Telefone>();
		String d16 = "16/01/2001";
		DateTimeFormatter f16 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao16 = LocalDate.parse(d16, f16);
		CPF cpf16 = new CPF(dataEmissao16, "12345678916");
		Telefone tel16 = new Telefone("12", "987654316");
		tels16.add(tel16);
		List<RG> rgs16 = new ArrayList<RG>();
		RG rg16 = new RG(dataEmissao16, "98765432116");
		rgs16.add(rg16);
		Cliente c16 = new Cliente("Pedro Bueno", "Otávio", "Masculino", cpf16);
		c16.setRgs(rgs16);
		c16.setTels(tels16);
		empresa.getClientes().add(c16);
		// //* #17
		List<Telefone> tels17 = new ArrayList<Telefone>();
		String d17 = "17/01/2001";
		DateTimeFormatter f17 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao17 = LocalDate.parse(d17, f17);
		CPF cpf17 = new CPF(dataEmissao17, "12345678917");
		Telefone tel17 = new Telefone("12", "987654317");
		tels17.add(tel17);
		List<RG> rgs17 = new ArrayList<RG>();
		RG rg17 = new RG(dataEmissao17, "98765432117");
		rgs17.add(rg17);
		Cliente c17 = new Cliente("Roberto Carlos", "Rob", "Masculino", cpf17);
		c17.setRgs(rgs17);
		c17.setTels(tels17);
		empresa.getClientes().add(c17);
		// //* #18
		List<Telefone> tels18 = new ArrayList<Telefone>();
		String d18 = "18/01/2001";
		DateTimeFormatter f18 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao18 = LocalDate.parse(d18, f18);
		CPF cpf18 = new CPF(dataEmissao18, "12345678918");
		Telefone tel18 = new Telefone("12", "987654318");
		tels18.add(tel18);
		List<RG> rgs18 = new ArrayList<RG>();
		RG rg18 = new RG(dataEmissao18, "98765432118");
		rgs18.add(rg18);
		Cliente c18 = new Cliente("Sandro Dionísio", "Sandro", "Masculino", cpf18);
		c18.setRgs(rgs18);
		c18.setTels(tels18);
		empresa.getClientes().add(c18);
		// //* #19
		List<Telefone> tels19 = new ArrayList<Telefone>();
		String d19 = "19/01/2001";
		DateTimeFormatter f19 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao19 = LocalDate.parse(d19, f19);
		CPF cpf19 = new CPF(dataEmissao19, "12345678919");
		Telefone tel19 = new Telefone("12", "987654319");
		tels19.add(tel19);
		List<RG> rgs19 = new ArrayList<RG>();
		RG rg19 = new RG(dataEmissao19, "98765432119");
		rgs19.add(rg19);
		Cliente c19 = new Cliente("Túlio Faria", "Túlio", "Masculino", cpf19);
		c19.setRgs(rgs19);
		c19.setTels(tels19);
		empresa.getClientes().add(c19);
		// //* #20
		List<Telefone> tels20 = new ArrayList<Telefone>();
		String d20 = "20/01/2001";
		DateTimeFormatter f20 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao20 = LocalDate.parse(d20, f20);
		CPF cpf20 = new CPF(dataEmissao20, "12345678920");
		Telefone tel20 = new Telefone("12", "987654320");
		tels20.add(tel20);
		List<RG> rgs20 = new ArrayList<RG>();
		RG rg20 = new RG(dataEmissao20, "98765432120");
		rgs20.add(rg20);
		Cliente c20 = new Cliente("Ulisses Guimarães", "Ulisses", "Masculino", cpf20);
		c20.setRgs(rgs20);
		c20.setTels(tels20);
		empresa.getClientes().add(c20);
		// //* #21
		List<Telefone> tels21 = new ArrayList<Telefone>();
		String d21 = "21/01/2001";
		DateTimeFormatter f21 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao21 = LocalDate.parse(d21, f21);
		CPF cpf21 = new CPF(dataEmissao21, "12345678921");
		Telefone tel21 = new Telefone("12", "987654321");
		tels21.add(tel21);
		List<RG> rgs21 = new ArrayList<RG>();
		RG rg21 = new RG(dataEmissao21, "98765432121");
		rgs21.add(rg21);
		Cliente c21 = new Cliente("Vinícius Henrique", "Vinnie", "Masculino", cpf21);
		c21.setRgs(rgs21);
		c21.setTels(tels21);
		empresa.getClientes().add(c21);
		// //* #22
		List<Telefone> tels22 = new ArrayList<Telefone>();
		String d22 = "22/01/2001";
		DateTimeFormatter f22 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao22 = LocalDate.parse(d22, f22);
		CPF cpf22 = new CPF(dataEmissao22, "12345678922");
		Telefone tel22 = new Telefone("12", "987654322");
		tels22.add(tel22);
		List<RG> rgs22 = new ArrayList<RG>();
		RG rg22 = new RG(dataEmissao22, "98765432122");
		rgs22.add(rg22);
		Cliente c22 = new Cliente("Arnaldo Batista", "Arnaldo", "Masculino", cpf22);
		c22.setRgs(rgs22);
		c22.setTels(tels22);
		empresa.getClientes().add(c22);
		// //* #23
		List<Telefone> tels23 = new ArrayList<Telefone>();
		String d23 = "23/01/2001";
		DateTimeFormatter f23 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao23 = LocalDate.parse(d23, f23);
		CPF cpf23 = new CPF(dataEmissao23, "12345678923");
		Telefone tel23 = new Telefone("12", "987654323");
		tels23.add(tel23);
		List<RG> rgs23 = new ArrayList<RG>();
		RG rg23 = new RG(dataEmissao23, "98765432123");
		rgs23.add(rg23);
		Cliente c23 = new Cliente("Bruno Castro", "Bruno", "Masculino", cpf23);
		c23.setRgs(rgs23);
		c23.setTels(tels23);
		empresa.getClientes().add(c23);
		// //* #24
		List<Telefone> tels24 = new ArrayList<Telefone>();
		String d24 = "24/01/2001";
		DateTimeFormatter f24 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao24 = LocalDate.parse(d24, f24);
		CPF cpf24 = new CPF(dataEmissao24, "12345678924");
		Telefone tel24 = new Telefone("12", "987654324");
		tels24.add(tel24);
		List<RG> rgs24 = new ArrayList<RG>();
		RG rg24 = new RG(dataEmissao24, "98765432124");
		rgs24.add(rg24);
		Cliente c24 = new Cliente("Carlos Durval", "Carlos", "Masculino", cpf24);
		c24.setRgs(rgs24);
		c24.setTels(tels24);
		empresa.getClientes().add(c24);
		// //* #25
		List<Telefone> tels25 = new ArrayList<Telefone>();
		String d25 = "25/01/2001";
		DateTimeFormatter f25 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao25 = LocalDate.parse(d25, f25);
		CPF cpf25 = new CPF(dataEmissao25, "12345678925");
		Telefone tel25 = new Telefone("12", "987654325");
		tels25.add(tel25);
		List<RG> rgs25 = new ArrayList<RG>();
		RG rg25 = new RG(dataEmissao25, "98765432125");
		rgs25.add(rg25);
		Cliente c25 = new Cliente("Daniel Estevam", "Daniel", "Masculino", cpf25);
		c25.setRgs(rgs25);
		c25.setTels(tels25);
		empresa.getClientes().add(c25);
		// //* #26
		List<Telefone> tels26 = new ArrayList<Telefone>();
		String d26 = "26/01/2001";
		DateTimeFormatter f26 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao26 = LocalDate.parse(d26, f26);
		CPF cpf26 = new CPF(dataEmissao26, "12345678926");
		Telefone tel26 = new Telefone("12", "987654326");
		tels26.add(tel26);
		List<RG> rgs26 = new ArrayList<RG>();
		RG rg26 = new RG(dataEmissao26, "98765432126");
		rgs26.add(rg26);
		Cliente c26 = new Cliente("Eliezer Faria", "Eliezer", "Masculino", cpf26);
		c26.setRgs(rgs26);
		c26.setTels(tels26);
		empresa.getClientes().add(c26);
		// //* #27
		List<Telefone> tels27 = new ArrayList<Telefone>();
		String d27 = "27/01/2001";
		DateTimeFormatter f27 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao27 = LocalDate.parse(d27, f27);
		CPF cpf27 = new CPF(dataEmissao27, "12345678927");
		Telefone tel27 = new Telefone("12", "987654327");
		tels27.add(tel27);
		List<RG> rgs27 = new ArrayList<RG>();
		RG rg27 = new RG(dataEmissao27, "98765432127");
		rgs27.add(rg27);
		Cliente c27 = new Cliente("Fábio Garcia", "Fábio", "Masculino", cpf27);
		c27.setRgs(rgs27);
		c27.setTels(tels27);
		empresa.getClientes().add(c27);
		// //* #28
		List<Telefone> tels28 = new ArrayList<Telefone>();
		String d28 = "28/01/2001";
		DateTimeFormatter f28 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao28 = LocalDate.parse(d28, f28);
		CPF cpf28 = new CPF(dataEmissao28, "12345678928");
		Telefone tel28 = new Telefone("12", "987654328");
		tels28.add(tel28);
		List<RG> rgs28 = new ArrayList<RG>();
		RG rg28 = new RG(dataEmissao28, "98765432128");
		rgs28.add(rg28);
		Cliente c28 = new Cliente("Gustavo Henrique", "Gustavo", "Masculino", cpf28);
		c28.setRgs(rgs28);
		c28.setTels(tels28);
		empresa.getClientes().add(c28);
		// //* #29
		List<Telefone> tels29 = new ArrayList<Telefone>();
		String d29 = "29/01/2001";
		DateTimeFormatter f29 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao29 = LocalDate.parse(d29, f29);
		CPF cpf29 = new CPF(dataEmissao29, "12345678929");
		Telefone tel29 = new Telefone("12", "987654329");
		tels29.add(tel29);
		List<RG> rgs29 = new ArrayList<RG>();
		RG rg29 = new RG(dataEmissao29, "98765432129");
		rgs29.add(rg29);
		Cliente c29 = new Cliente("Herlon Júnior", "Herlon", "Masculino", cpf29);
		c29.setRgs(rgs29);
		c29.setTels(tels29);
		empresa.getClientes().add(c29);
		// //* #30
		List<Telefone> tels30 = new ArrayList<Telefone>();
		String d30 = "30/01/2001";
		DateTimeFormatter f30 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao30 = LocalDate.parse(d30, f30);
		CPF cpf30 = new CPF(dataEmissao30, "12345678930");
		Telefone tel30 = new Telefone("12", "987654330");
		tels30.add(tel30);
		List<RG> rgs30 = new ArrayList<RG>();
		RG rg30 = new RG(dataEmissao30, "98765432130");
		rgs30.add(rg30);
		Cliente c30 = new Cliente("Joaquim Lemos", "Joaquim", "Masculino", cpf30);
		c30.setRgs(rgs30);
		c30.setTels(tels30);
		empresa.getClientes().add(c30);


		while (execucao) {
			System.out.println("\n🌎 💅 🏢 GRUPO WORLD BEAUTY 🏢 💅 🌎\n");
			System.out.println("👋 Bem-vindo a nosso sistema");
			System.out.println("\n🔵 OPERAÇÕES\n");
			System.out.println("1️⃣  - Clientes");
			System.out.println("2️⃣  - Produtos & Serviços");
			System.out.println("3️⃣  - Consumos");
			System.out.println("4️⃣  - Sair");
			System.out.print("\n🟡 Qual operação deseja realizar? ");

			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
			
			switch (operacao) {
				case "1":
					boolean execCliente = true;
					while (execCliente) {
						System.out.println("\n👤  CLIENTES\n");
						System.out.println("1️⃣  - Cadastrar cliente");
						System.out.println("2️⃣  - Listar clientes");
						System.out.println("3️⃣  - Buscar cliente");
						System.out.println("4️⃣  - Cancelar");
						System.out.print("\n🟡 Qual operação deseja realizar? ");

						Entrada entradaCliente = new Entrada();
						String opCliente = entradaCliente.receberTexto();
						switch (opCliente) {
							case "1":
								Cadastro cadastro = new CadastroCliente(empresa.getClientes());
								cadastro.cadastrar();
								execCliente = false;
								break;
							case "2":
								Listagem listagem = new ListarTodosClientes(empresa.getClientes());
								listagem.listar();
								execCliente = false;
								break;
							case "3":
								Busca busca = new BuscaCliente(empresa.getClientes());
								busca.buscar();
								execCliente = false;
								break;
							case "4":
								execCliente = false;
								break;
							default:
								System.out.println("\n🚫 Operação inválida!");
						}
					}
					break;
				case "2":
					boolean execProds = true;
					while (execProds) {
						System.out.println("\n📦  PRODUTOS & SERVIÇOS\n");
						System.out.println("1️⃣  - Cadastrar Produto/Serviço");
						System.out.println("2️⃣  - Listar Produtos/Serviços");
						System.out.println("3️⃣  - Buscar Produto/Serviço");
						System.out.println("4️⃣  - Voltar");
						System.out.print("\n🟡 Qual operação deseja realizar? ");

						Entrada entradaProd = new Entrada();
						String opProd = entradaProd.receberTexto();
						switch (opProd) {
							case "1":
								Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
								cadastroProduto.cadastrar();
								execProds = false;
								break;
							case "2":
								Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos(), empresa.getConsumos());
								listagemProdutos.listar();
								execProds = false;
								break;
							case "3":
								Busca buscaProduto = new BuscaProduto(empresa.getProdutos());
								buscaProduto.buscar();
								execProds = false;
								break;
							case "4":
								execProds = false;
								break;
							default:
								System.out.println("\n🚫 Operação inválida!");
						}
					}
					break;
				case "3":
					boolean execConsumo = true;
					while (execConsumo) {
						System.out.println("\n📦  CONSUMOS\n");
						System.out.println("1️⃣  - Registrar consumo");
						System.out.println("2️⃣  - Listar consumo");
						System.out.println("3️⃣  - Voltar");
						System.out.print("\n🟡 Qual operação deseja realizar? ");
						Entrada entradaConsumo = new Entrada();
						String operacaoConsumo = entradaConsumo.receberTexto();
						switch (operacaoConsumo) {
							case "1":
								Cadastro cadastroConsumo = new CadastroConsumo(empresa.getConsumos(), empresa.getClientes(), empresa.getProdutos());
								cadastroConsumo.cadastrar();
								execConsumo = false;
								break;
							case "2":
								Listagem listarConsumo = new ListarConsumo(empresa.getConsumos());
								listarConsumo.listar();
								execConsumo = false;
								break;
							case "3":
								execConsumo = false;
								break;
							default:
								System.out.println("\n🚫 Operação inválida!");
						}
					}
					break;
				case "4":
					execucao = false;
					System.out.println("\n👋 Até mais!\n");
					break;
				default:
					System.out.println("\n🚫 Operação inválida!");
			}
		}
	}
}