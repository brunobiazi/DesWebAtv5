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

@WebServlet("/listar_livros")
public class listar_livros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DAO dao = new DAO();
    
    public listar_livros() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

    	
    	ArrayList<livro> lista = dao.listar_livros();
        request.setAttribute("listaLivros", lista);

        for (int i = 0; i < lista.size(); i++){
            livro livro = lista.get(i);
        }

        request.getRequestDispatcher("/lista.jsp").forward(request, response);
    }


}
