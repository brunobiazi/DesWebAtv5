package controller;

import java.sql.Connection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.cliente;

@WebServlet("/inserir_cliente")
public class inserir_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	cliente cliente = new cliente(null, null, null, null, null, null, null, null);

	public inserir_cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
		Connection con = dao.obterConexao();

		if (con != null) {
			cliente.setEmail(request.getParameter("email"));
			cliente.setSenha(request.getParameter("senha"));
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setNome(request.getParameter("nome"));
			cliente.setTelefone(request.getParameter("telefone"));
			cliente.setSexo(request.getParameter("sexo"));
			cliente.setData_nascimento(request.getParameter("data_nascimento"));

			
 
			dao.inserir_cliente(cliente);
			response.sendRedirect("http://localhost:8080/listar_cliente");
		} else {
			System.out.println("nem te conto");
		}

	}

}
