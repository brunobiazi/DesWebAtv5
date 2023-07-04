package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.editora;

@WebServlet("/listar_editoras")
public class listar_editoras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DAO dao = new DAO();
    
    public listar_editoras() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
    	ArrayList<editora> lista = dao.listar_editora();
        request.setAttribute("listarEditoras", lista);

        for (int i = 0; i < lista.size(); i++){
            editora editora = lista.get(i);
        }

        request.getRequestDispatcher("/cadastrar_livro.jsp").forward(request, response);
    }


}
