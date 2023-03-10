package com.jotasantos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jotasantos.dao.util.Conexao;
import com.jotasantos.modelo.Usuario;


public class UsuarioDAO {
	
private Connection connection;
	
	private void conectar() throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	public Usuario inserirUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO usuario (nome, cpf, data_nascimento, email, password, login, ativo)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";		    
		
		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getCpf());
		Date nascimento = new Date(usuario.getDataNascimento().getTime());
		statement.setDate(3, nascimento);
		statement.setString(4, usuario.getEmail());
		statement.setString(5, usuario.getPassword());
		statement.setString(6, usuario.getLogin());
		statement.setBoolean(7, usuario.isAtivo());
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = -1;
		
		if(resultSet.next())
			id = resultSet.getInt(1);		
		statement.close();

		desconectar();
		
		usuario.setId(id);
		return usuario;
	}


}
