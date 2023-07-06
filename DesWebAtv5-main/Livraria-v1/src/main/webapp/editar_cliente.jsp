<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.cliente" %>
<%@ page import="java.util.ArrayList" %>
<% 
ArrayList<cliente> lista_cliente = (ArrayList<cliente>) request.getAttribute("editarCliente");

response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Cliente</title>
<style>
    body {
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 97vh;
    }

    .container {
      width: 400px;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      background-color: #f2f2f2;
      margin: 0 auto;
    }

    h2 {
      text-align: center;
    }

    .form-group {
      margin-bottom: 10px;
    }

    .form-group label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }

    .form-group input,
    .form-group textarea {
      width: 100%;
      padding: 5px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }

    .form-group .btn {
      width: 100%;
      padding: 10px;
      border: none;
      border-radius: 3px;
      background-color: #4CAF50;
      color: #fff;
      cursor: pointer;
    }
  </style>
</head>
<body>
  
  <% if (lista_cliente != null) {
              for (cliente cliente : lista_cliente) {
       %>
  <div class="container">
    <h2>Editar cliente</h2>
    <form action="update_cliente" method="post">
    <input type="hidden" id="id" name="id" value="<%= cliente.getId() %>" required>
      <div class="form-group">
        <label for="email"><%= cliente.getEmail() %></label>
        <input type="text" id="email" name="email" value="<%= cliente.getEmail() %>" required>
      </div>
      <div class="form-group">
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" value="<%= cliente.getSenha() %>" required>
      </div>
      <div class="form-group">
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" value="<%= cliente.getCpf() %>" required>
      </div>
      <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%= cliente.getNome() %>" required>
      </div>
      <div class="form-group">
        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" value="<%= cliente.getTelefone() %>" required>
      </div>
      <div class="form-group">
        <label for="sexo">Sexo:</label>
        <input type="text" id="sexo" name="sexo" value="<%= cliente.getSexo() %>" required>
      </div>
      <div class="form-group">
        <label for="data_nascimento">Data de Nascimento:</label>
        <input type="text" id="data_nascimento" name="data_nascimento" value="<%= cliente.getData_nascimento() %>" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Salvar" class="btn">
      </div>
    </form>
  </div>
  <%}} %>
</body>
</html>