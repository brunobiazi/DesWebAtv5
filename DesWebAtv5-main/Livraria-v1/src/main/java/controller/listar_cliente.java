package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.cliente;

@WebServlet("/listar_cliente")
public class listar_cliente extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public listar_cliente() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        Connection con = null;

        try {
            con = dao.obterConexao();
            dao.testeConexao();

            if (con != null) {
                ArrayList<cliente> lista = dao.listar_cliente();
                request.setAttribute("listaCliente", lista);
                
                if (lista != null){
                    for (int i = 0; i < lista.size(); i++) {
                        cliente cliente = lista.get(i);
                    }
                } else {
                    System.out.println("lista é nulo");
                }
                
            } else {
                System.out.println("Erro ao estabelecer conexão com o banco de dados");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu uma exceção: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println("Erro ao fechar conexão com o banco de dados: " + e.getMessage());
                    e.printStackTrace();
                    e.getCause();
                }
            }
        }

        request.getRequestDispatcher("/lista.jsp").forward(request, response);
    }
}
