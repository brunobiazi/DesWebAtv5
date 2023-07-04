package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/LocacaoBicicletas?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "root";

    private Connection conectar() {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public Connection obterConexao() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void testeConexao() {
        try {
            Connection con = conectar();
            System.out.println(con);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserir_cliente(cliente cliente) {
        try {

            Connection con = conectar();

            String sql = "INSERT INTO Cliente (email, senha, cpf, nome, telefone, sexo, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, cliente.getEmail());
            statement.setString(2, cliente.getSenha());
            statement.setString(3, cliente.getCpf());
            statement.setString(4, cliente.getNome());
            statement.setString(5, cliente.getTelefone());
            statement.setString(6, cliente.getSexo());
            statement.setString(7, cliente.getData_nascimento());

        

            int linhasInseridas = statement.executeUpdate();
            if (linhasInseridas > 0) {
                System.out.println("cliente adicionado com sucesso");
            }
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<cliente> listar_cliente() {
        ArrayList<cliente> cliente = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try {
            Connection con = conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String email = resultSet.getString(2);
                String senha = resultSet.getString(3);
                String cpf = resultSet.getString(4);
                String nome = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String sexo = resultSet.getString(7);
                String data_nascimento = resultSet.getString(8);

                cliente.add(new cliente(id, email, senha, cpf, nome, telefone, sexo, data_nascimento));
            }

            con.close();
            return cliente;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("An error occurred while retrieving the book list: " + e.getMessage());
            return new ArrayList<>(); 
        }
    }

    public ArrayList<editora> listar_editora() {
        ArrayList<editora> editora = new ArrayList<>();
        String sql = "SELECT * FROM Editora";

        try {
            Connection con = conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String cnpj = resultSet.getString(2);
                String nome = resultSet.getString(3);
                editora.add(new editora(id, cnpj, nome));

            }

            con.close();
            return editora;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    public void excluir_cliente(String id) {

        // Deletar os dados no banco de dados
        try {

            Connection con = conectar();

            String sql = "DELETE FROM Cliente WHERE id = " + id;
            PreparedStatement statement = con.prepareStatement(sql);

            int linhasExcluidas = statement.executeUpdate();
            if (linhasExcluidas > 0) {
                System.out.println("cliente excluído com sucesso");
            }
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<cliente> editar_cliente(String id_recebido) {
        ArrayList<cliente> cliente = new ArrayList<>();
        String sql = "SELECT * FROM Cliente WHERE id = " + id_recebido;

        try {
            Connection con = conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String id = resultSet.getString(1);
                String email = resultSet.getString(2);
                String senha = resultSet.getString(3);
                String cpf = resultSet.getString(4);
                String nome = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String sexo = resultSet.getString(7);
                String data_nascimento = resultSet.getString(8);


                if (id_recebido.equals(id + "")) {
                    cliente.add(new cliente(id, email, senha, cpf, nome, telefone, sexo, data_nascimento));
                }
            }

            con.close();
            return cliente;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    public void update_cliente(cliente cliente, String id) {
        try {
            Connection con = conectar();

            String sql = "UPDATE Cliente SET email = ?, senha = ?, cpf = ?, nome = ?, telefone = ?, sexo = ?, data_nascimento = ? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, cliente.getEmail());
            statement.setString(2, cliente.getSenha());
            statement.setString(3, cliente.getCpf());
            statement.setString(4, cliente.getNome());
            statement.setString(5, cliente.getTelefone());
            statement.setString(6, cliente.getSexo());
            statement.setString(7, cliente.getData_nascimento());
            statement.setString(8, id);


            System.out.println(cliente.getId());

            int linhasAtualizadas = statement.executeUpdate();
            if (linhasAtualizadas > 0) {
                System.out.println("cliente editado com sucesso");
            }

            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
