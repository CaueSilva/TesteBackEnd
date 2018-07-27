package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controller.ControleCliente;
import model.ModeloCliente;

public class ViewCliente {

	private ControleCliente controle = new ControleCliente();
	private ModeloCliente m1 = new ModeloCliente();
	private ModeloCliente m2 = new ModeloCliente();
	private ModeloCliente m3 = new ModeloCliente();
	private ModeloCliente m4 = new ModeloCliente();
	private ModeloCliente m5 = new ModeloCliente();

	public static void main(String[] args) {
		new ViewCliente();
	}

	public ViewCliente() {

		m1.setIdCliente((int) (Math.random() * 2700));
		m1.setCpfCliente(1111111111);
		m1.setNomeCliente("Cliente 1");
		m1.setAtivo(true);
		m1.setSaldoTotal(958.52);
		controle.adiciona(m1);

		m2.setIdCliente((int) (Math.random() * 2700));
		m2.setCpfCliente(222222222);
		m2.setNomeCliente("Cliente 2");
		m2.setAtivo(false);
		m2.setSaldoTotal(152.88);
		controle.adiciona(m2);

		m3.setIdCliente((int) (Math.random() * 2700));
		m3.setCpfCliente(333333333);
		m3.setNomeCliente("Cliente 3");
		m3.setAtivo(true);
		m3.setSaldoTotal(3495.34);
		controle.adiciona(m3);

		m4.setIdCliente((int) (Math.random() * 2700));
		m4.setCpfCliente(444444444);
		m4.setNomeCliente("Cliente 4");
		m4.setAtivo(false);
		m4.setSaldoTotal(652.20);
		controle.adiciona(m4);

		m5.setIdCliente((int) (Math.random() * 2700));
		m5.setCpfCliente(555555555);
		m5.setNomeCliente("Cliente 5");
		m5.setAtivo(true);
		m5.setSaldoTotal(96.57);
		controle.adiciona(m5);
		
		controle.media();

		List<ModeloCliente> lista = new ArrayList<>();
		lista = controle.busca();
		if (!lista.isEmpty()) {
			Collections.sort(lista);
			System.out.println("TAMANHO DA LISTA: "+lista.size());
			for (int i = 0; i < lista.size(); i++) {
				ModeloCliente c = lista.get(i);
				System.out.println("ID Cliente: " + c.getIdCliente());
				System.out.println("CPF/CNPJ: " + c.getCpfCliente());
				System.out.println("Nome: " + c.getNomeCliente());
				if (c.isAtivo()) {
					System.out.println("Ativo: Sim");
				} else {
					System.out.println("Ativo: Não");
				}
				System.out.println("Saldo: " + c.getSaldoTotal());
			}
		} else {
			System.out.println("A busca não retornou resultados.");
		}
	}
}
