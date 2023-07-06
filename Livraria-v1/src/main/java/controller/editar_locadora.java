package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.cliente;

@WebServlet("/editar_cliente")
public class editar_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editar_cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
    	
    	ArrayList<cliente> lista = dao.editar_cliente(id);
        request.setAttribute("editarCliente", lista);

        for (int i = 0; i < lista.size(); i++){
            cliente cliente = lista.get(i);
        }

        request.getRequestDispatcher("/editar_cliente.jsp").forward(request, response);
	}

}
