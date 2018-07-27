package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.ModeloCliente;

public class DaoCliente {
	
	private Connection con;
	
	public void adiciona(ModeloCliente cliente) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("INSERT INTO tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total)"
					+ " VALUE (?,?,?,?,?)");
			p.setInt(1, cliente.getIdCliente());
			p.setLong(2, cliente.getCpfCliente());
			p.setString(3, cliente.getNomeCliente());
			p.setBoolean(4, cliente.isAtivo());
			p.setDouble(5, cliente.getSaldoTotal());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ModeloCliente> busca(){
		Conexao c = new Conexao();
		List<ModeloCliente> lista = new ArrayList<>();
		con = c.abrir();
		PreparedStatement p;
		ResultSet rs;
		try {
			p = con.prepareStatement("SELECT * FROM tb_customer_account");
			rs = p.executeQuery();
			while(rs.next()) {
				if(rs.getInt("id_customer") > 1500 && rs.getInt("id_customer") < 2700 && rs.getDouble("vl_total") > 560) {
					ModeloCliente m = new ModeloCliente();
					m.setIdCliente(rs.getInt("id_customer"));
					m.setCpfCliente(rs.getLong("cpf_cnpj"));
					m.setNomeCliente(rs.getString("nm_customer"));
					m.setAtivo(rs.getBoolean("is_active"));
					m.setSaldoTotal(rs.getDouble("vl_total"));
					lista.add(m);
				}
			}
			con.close();
			p.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
