<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.livro" %>
<%@ page import="java.util.ArrayList" %>
<% 
ArrayList<livro> lista_livros = (ArrayList<livro>) request.getAttribute("editarLivros");

response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar livro</title>
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
  <% if (lista_livros != null) {
              for (livro livro : lista_livros) {
       %>
  <div class="container">
    <h2>Editar Livro</h2>
    <form action="update_livro" method="post">
    <input type="hidden" id="titulo" name="id" value="<%= livro.getId() %>" required>
      <div class="form-group">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" value="<%= livro.getTitulo() %>" required>
      </div>
      <div class="form-group">
        <label for="descricao">Autor:</label>
        <textarea id="descricao" name="autor" rows="4" required><%= livro.getAutor() %></textarea>
      </div>
      <div class="form-group">
        <label for="Ano">Ano:</label>
        <input type="text" id="dataCriacao" name="ano" value="<%= livro.getAno() %>" required>
      </div>
      <div class="form-group">
        <label for="dataConclusao">Preço:</label>
        <input type="number" id="dataConclusao" name="preco" value="<%= livro.getPreco() %>" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Salvar" class="btn">
      </div>
    </form>
  </div>
  <%}} %>
</body>
</html>