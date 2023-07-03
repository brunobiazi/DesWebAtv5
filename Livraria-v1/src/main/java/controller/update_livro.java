package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.livro;

@WebServlet("/update_livro")
public class update_livro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	livro livro = new livro(0, null, null, 0, 0, 0);
    DAO dao = new DAO();
	
    public update_livro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		livro.setTitulo(request.getParameter("titulo"));
		livro.setAutor(request.getParameter("autor"));
		livro.setAno(Integer.parseInt( request.getParameter("ano")));
		livro.setPreco(Double.parseDouble( request.getParameter("preco")));
        
        dao.update_livro(livro, id);
        response.sendRedirect("http://localhost:8080/Livraria/listar_livros");
	}


}
