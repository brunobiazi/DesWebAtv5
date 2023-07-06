<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.editora" %>
<%@ page import="java.util.ArrayList" %>
<% 
ArrayList<editora> listar_editoras = (ArrayList<editora>) request.getAttribute("listarEditoras");

response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar livro</title>
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
  
  <div class="container">
    <h2>Cadastrar Livro</h2>
    <form action="inserir_livro" method="post">
      <div class="form-group">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" value="" required>
      </div>
      <div class="form-group">
        <label for="descricao">Autor:</label>
        <textarea id="descricao" name="autor" rows="4" required></textarea>
      </div>
      <div class="form-group">
        <label for="Ano">Ano:</label>
        <input type="text" id="dataCriacao" name="ano" value="" required>
      </div>
      <div class="form-group">
        <label for="dataConclusao">Preço:</label>
        <input type="number" id="dataConclusao" name="preco" value="" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Salvar" class="btn">
      </div>           
    </form>
  </div>
</body>
</html>