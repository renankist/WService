package br.com.WService.soap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.jws.WebService;

import br.com.WService.dao.DBConfig;
import br.com.WService.entidade.Produto;

@WebService(endpointInterface = "br.com.WService.soap.ProdutoServer")
public class ProdutoServerImp implements ProdutoServer {

	@Override
	public Produto getProduto(int id) {
		Produto c = new Produto();

		try {

			Connection conexao = DBConfig.getConnection();

			String sql = "SELECT * FROM produto WHERE id = " + id;

			PreparedStatement s = conexao.prepareStatement(sql);

			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setDescricao(rs.getString("descricao"));
				c.setValor(rs.getDouble("valor"));
				c.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public String deleteProduto(int id) {
		String msg = "";

		try {
			Connection conexao;
			conexao = DBConfig.getConnection();
			String sql = "DELETE from produto where id = ?";
			PreparedStatement s = conexao.prepareStatement(sql);
			s.setInt(1, id);
			s.execute();
			msg = "Produto removido com sucesso!";
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "Erro ao remover produto!";
		}

		return msg;
	}

	@Override
	public Produto[] getProdutos() {
		Collection<Produto> cs = new ArrayList<Produto>();

		Connection conexao;
		try {
			conexao = DBConfig.getConnection();

			String sql = "SELECT * FROM produto";

			PreparedStatement s = conexao.prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				Produto c = new Produto();
				c.setId(rs.getInt("id"));
				c.setId(rs.getInt("id"));
				c.setDescricao(rs.getString("descricao"));
				c.setValor(rs.getDouble("valor"));
				c.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
				cs.add(c);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cs.toArray(new Produto[0]);
	}

	@Override
	public String editProduto(int id, String descricao, double valor, int quantidade_estoque) {
		String msg = "Erro ao editar produto.";
		Connection conexao;

		Produto p = new Produto();	
		p.setId(id);
		p.setDescricao(descricao);
		p.setQuantidade_estoque(quantidade_estoque);
		p.setValor(valor);

		try {
			conexao = DBConfig.getConnection();

			String sql = "UPDATE produto set descricao = ?, valor = ?, quantidade_estoque = ? WHERE id = ? ";

			PreparedStatement s = conexao.prepareStatement(sql);
			s.setString(1, p.getDescricao());
			s.setDouble(2, p.getValor());
			s.setInt(3, p.getQuantidade_estoque());
			s.setInt(4, id);

			s.execute();
			msg = "Produto editado com sucesso.";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String addProduto(String descricao, double valor, int quantidade_estoque) {

		Produto p = new Produto();
		
		p.setDescricao(descricao);
		p.setQuantidade_estoque(quantidade_estoque);
		p.setValor(valor);
		String msg = "Erro ao adicionar produto.";
		Connection conexao;

		try {
			conexao = DBConfig.getConnection();

			String sql = "insert into produto(descricao, valor, quantidade_estoque) values(?,?,?)";

			PreparedStatement s = conexao.prepareStatement(sql);

			s.setString(1, p.getDescricao());
			s.setDouble(2, p.getValor());
			s.setInt(3, p.getQuantidade_estoque());

			s.execute();

			msg = "Produto adicionado com sucesso.";

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;
	}

}
