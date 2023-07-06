package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.cliente;

    @WebServlet("/excluir_cliente")
    public class excluir_cliente extends HttpServlet {
    	private static final long serialVersionUID = 1L;
           
    	DAO dao = new DAO();
    	cliente livro = new cliente(null, null, null, null, null, null, null, null);

    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.getWriter().append("doGET ").append(request.getContextPath());
    	}


    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.getWriter().append("doPOST ").append(request.getContextPath());
            dao.excluir_cliente(request.getParameter("id"));
            response.sendRedirect("http://localhost:8080/listar_cliente");
    	} 
    
}

