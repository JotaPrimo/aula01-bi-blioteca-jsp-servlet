package com.jotasantos.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jotasantos.controller.util.ManipulacaoData;
import com.jotasantos.dao.util.Conexao;
import com.jotasantos.modelo.Usuario;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/publica")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		try {
			switch (acao) {
			case "novo":
				this.novoUsuario(request, response);
				break;
				
			case "inserir":
				this.gravarUsuario(request, response);
				break;

			default:
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/public/public-novo-usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	

	protected void gravarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {	
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String nascimento = request.getParameter("dataNascimento");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		ManipulacaoData manipulacaoData = new ManipulacaoData();
		Date dataNascimento = manipulacaoData.converterStringData(nascimento);
		
		Usuario usuario = new Usuario(nome, cpf, dataNascimento, email, senha, login, true);
		System.out.println(usuario);
	}
	
	

}
