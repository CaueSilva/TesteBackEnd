package model;

public class ModeloCliente implements Comparable<ModeloCliente> {

	private int idCliente;
	private long cpfCliente;
	private String nomeCliente;
	private boolean ativo;
	private double saldoTotal;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public long getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	@Override
	public int compareTo(ModeloCliente m) {
		if (this.getIdCliente() > m.getIdCliente()) {
			return 1;
		} else if (this.getIdCliente() < m.getIdCliente()) {
			return -1;
		}
		return 0;
	}

}
