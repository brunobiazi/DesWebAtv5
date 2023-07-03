package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/livraria?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "";
    
    private Connection conectar() {
    	Connection con = null;
    	
    	try{
    		Class.forName(driver);
    		con = DriverManager.getConnection(url, user, password);
    		return con;
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    	
    }
    
    public void testeConexao() {
    	try{
    		Connection con = conectar();
    		System.out.println(con);
    		con.close();
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    
    public void inserir_livro(livro livro) {
        try {

        	Connection con = conectar();
        	
            String sql = "INSERT INTO livro (titulo, autor, ano, preco, editora_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, livro.getTitulo());
            statement.setString(2, livro.getAutor());
            statement.setInt(3, livro.getAno());
            statement.setDouble(4, livro.getPreco());
            statement.setInt(5, 4);
            int linhasInseridas = statement.executeUpdate();
            if (linhasInseridas > 0) {
                System.out.println("Livro adicionado com sucesso");
            }
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    
    
    public ArrayList<livro> listar_livros() {
        ArrayList<livro> livro = new ArrayList<>();
        String sql = "SELECT * FROM livro";
        
        try {
            Connection con = conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	int id = resultSet.getInt(1);
                String titulo = resultSet.getString(2);
                String autor = resultSet.getString(3);
                int ano = resultSet.getInt(4);
                double preco = resultSet.getDouble(5);
                int editora_id = resultSet.getInt(6);
                   livro.add( new livro(id, titulo, autor, ano, preco, editora_id));
            	
            }
            
            con.close();
            return livro;
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }
    
    
    public ArrayList<editora> listar_editoras() {
        ArrayList<editora> editora = new ArrayList<>();
        String sql = "SELECT * FROM editora";
        
        try {
            Connection con = conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	int id = resultSet.getInt(1);
                String cnpj = resultSet.getString(2);
                String nome = resultSet.getString(3);
                   editora.add( new editora(id, cnpj, nome));
            	
            }
            
            con.close();
            return editora;
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }
    
    
    public void excluir_livros(String id) {

        // Deletar os dados no banco de dados
        try {
            
        	Connection con = conectar();
        	
            String sql = "DELETE FROM livro WHERE id = " + id;
            PreparedStatement statement = con.prepareStatement(sql);
           
            int linhasExcluidas = statement.executeUpdate();
            if (linhasExcluidas > 0) {
                System.out.println("Livro excluído com sucesso");
            }
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    
    
    public ArrayList<livro> editar_livros(String id_recebido) {
        ArrayList<livro> livro = new ArrayList<>();
        String sql = "SELECT * FROM livro WHERE id = "+id_recebido;
        
        try {
            Connection con = conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	
            	int id = resultSet.getInt(1);
                String titulo = resultSet.getString(2);
                String autor = resultSet.getString(3);
                int ano = resultSet.getInt(4);
                double preco = resultSet.getDouble(5);
                int editora_id = resultSet.getInt(6);
                
                if(id_recebido.equals(id+"")) {
                	livro.add( new livro(id, titulo, autor, ano, preco, editora_id));
                }
            }
            
            con.close();
            return livro;
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }
    
    
    public void update_livro(livro livro, String id) {
        try {
            Connection con = conectar();

            String sql = "UPDATE livro SET titulo = ?, autor = ?, ano = ?, preco = ?, editora_id = ? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, livro.getTitulo());
            statement.setString(2, livro.getAutor());
            statement.setInt(3, livro.getAno());
            statement.setDouble(4, livro.getPreco());
            statement.setInt(5, 4); //mudar o id da editora
            statement.setString(6, id+"");
            
            System.out.println(sql);

            int linhasAtualizadas = statement.executeUpdate();
            if (linhasAtualizadas > 0) {
                System.out.println("Livro editado com sucesso");
            }

            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}

