package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.livro;

@WebServlet("/editar_livros")
public class editar_livros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editar_livros() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
    	
    	ArrayList<livro> lista = dao.editar_livros(id);
        request.setAttribute("editarLivros", lista);

        for (int i = 0; i < lista.size(); i++){
            livro livro = lista.get(i);
        }

        request.getRequestDispatcher("/editar_livros.jsp").forward(request, response);
	}

}
