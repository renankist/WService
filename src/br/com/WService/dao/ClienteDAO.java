package br.com.WService.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.WService.entidade.Cliente;

import java.sql.Connection;

public class ClienteDAO {

	public Cliente getCliente(int id) throws Exception {

		Cliente c = new Cliente();

		Connection conexao = DBConfig.getConnection();

		String sql = "SELECT * FROM cliente WHERE id = " + id;

		PreparedStatement s = conexao.prepareStatement(sql);
		ResultSet rs = s.executeQuery();

		while (rs.next()) {
			c.setId(rs.getInt("id"));
			c.setCelular(rs.getString("celular"));
			c.setEmail(rs.getString("email"));
			c.setIdade(rs.getInt("idade"));
			c.setNome(rs.getString("nome"));
		}

		return c;

	}

	public List<Cliente> getClientes() throws Exception {

		List<Cliente> cs = new ArrayList<>();

		Connection conexao = DBConfig.getConnection();

		String sql = "SELECT * FROM cliente";

		PreparedStatement s = conexao.prepareStatement(sql);
		ResultSet rs = s.executeQuery();

		while (rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getInt("id"));
			c.setCelular(rs.getString("celular"));
			c.setEmail(rs.getString("email"));
			c.setIdade(rs.getInt("idade"));
			c.setNome(rs.getString("nome"));
			cs.add(c);
		}

		return cs;

	}

	public void addCliente(Cliente c) throws ClassNotFoundException, SQLException {

		Connection conexao = DBConfig.getConnection();

		String sql = "insert into cliente(nome, email, celular, idade) values(?,?,?,?)";

		PreparedStatement s = conexao.prepareStatement(sql);
		s.setString(1, c.getNome());
		s.setString(2, c.getEmail());
		s.setString(3, c.getCelular());
		s.setInt(4, c.getIdade());

		s.execute();

	}

	public void editCliente(Cliente c, int id) throws ClassNotFoundException, SQLException {
		Connection conexao = DBConfig.getConnection();

		String sql = "UPDATE cliente set nome = ?, email = ?, celular = ?, idade = ? WHERE id = ? ";

		PreparedStatement s = conexao.prepareStatement(sql);
		s.setString(1, c.getNome());
		s.setString(2, c.getEmail());
		s.setString(3, c.getCelular());
		s.setInt(4, c.getIdade());
		s.setInt(5, id);

		s.execute();

	}

	public void deleteCliente(int  c) throws ClassNotFoundException, SQLException {
		Connection conexao = DBConfig.getConnection();
		
		String sql = "DELETE from cliente where id = ?";
		
		PreparedStatement s = conexao.prepareStatement(sql);
		
		s.setInt(1, c);
		
		s.execute();
	}

}
