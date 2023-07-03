package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBD {
    
    private static Connection conectar() {
    	Connection con = null;
    	
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Livraria", 
    				"root", "root");
    		return con;
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    	
    }
	

    public static void main(String[] args) {
        try {
        	
        	Connection con = conectar();

            Statement stmt = con.createStatement();
            String insertEditoraSQL = "INSERT INTO Editora (cnpj, nome) VALUES ('87.557.922/0001-82', 'Seguinte')";
            stmt.executeUpdate(insertEditoraSQL);

            String insertLivroSQL = "INSERT INTO Livro (titulo, autor, ano, preco, editora_id) VALUES ('O Dia do Curinga', 'Jostein Gaarder', 1996, 29.99, (SELECT id FROM Editora WHERE nome = 'Seguinte'))";
            stmt.executeUpdate(insertLivroSQL);

            insertLivroSQL = "INSERT INTO Livro (titulo, autor, ano, preco, editora_id) VALUES ('A Revolução dos Bichos', 'George Orwell', 2007, 23.90, (SELECT id FROM Editora WHERE nome = 'Companhia das Letras'))";
            stmt.executeUpdate(insertLivroSQL);

            String selectLivrosSQL = "SELECT Livro.titulo, Livro.autor, Livro.ano, Livro.preco, Editora.nome " +
                    "FROM Livro " +
                    "INNER JOIN Editora ON Livro.editora_id = Editora.id " +
                    "ORDER BY Livro.preco";
            
            Connection con2 = conectar();
            PreparedStatement statement = con2.prepareStatement(selectLivrosSQL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano = rs.getInt("ano");
                float preco = rs.getFloat("preco");
                String editora = rs.getString("nome");

                System.out.println(titulo + ", " + autor + ", " + editora + ", " + ano + ". R$" + preco);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("O comando SQL não pode ser executado!");
        }
    }
}
