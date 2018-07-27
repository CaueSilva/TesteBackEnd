package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DaoCliente;
import model.ModeloCliente;

public class ControleCliente {

	private List<ModeloCliente> listaCliente = new ArrayList<>();
	private DaoCliente daoCliente = new DaoCliente();
	private double media = 0;
	private int cont = 0;

	public void adiciona(ModeloCliente m) {
		daoCliente.adiciona(m);
		if (m.getSaldoTotal() > 560 && m.getIdCliente() > 1500 && m.getIdCliente() < 2700) {
			media += m.getSaldoTotal();
			cont = cont + 1;
		}
	}

	public List<ModeloCliente> busca() {
		listaCliente.clear();
		listaCliente = daoCliente.busca();
		return listaCliente;
	}

	public void media() {
		media = media / cont;
		System.out.println("Média dos saldos de clientes maiores que R$560: " + media);
		media = 0;
	}

}
