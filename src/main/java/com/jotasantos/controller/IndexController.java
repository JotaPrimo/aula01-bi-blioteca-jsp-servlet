package com.jotasantos.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jotasantos.dao.util.Conexao;

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

			default:
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
		
		Connection conexaooJDBC = Conexao.getConexao();
		
		if(conexaooJDBC != null) {
			System.out.println("SIM");
		}else {
			System.out.println("Deu merda");
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/public/public-novo-usuario.jsp");
		dispatcher.forward(request, response);
	}

}
