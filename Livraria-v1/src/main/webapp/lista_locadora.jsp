<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.locadora" %>
<%@ page import="java.util.ArrayList" %>
<% 
ArrayList<locadora> lista_locadora = (ArrayList<locadora>) request.getAttribute("listaLocadora");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar locadoras</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to bottom, #2980b9, #6dd5fa);
            color: #fff;
            background-repeat: no-repeat;
            background-size: cover;
            height: 100vh;
        }

        .container {
            padding: 20px;
        }

        .task-card {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            position: relative;
            margin-bottom: 20px;
        }

        .task-card:before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            border-radius: 10px;
            background: linear-gradient(to bottom right, #2c3e50, #3498db);
            opacity: 0.9;
            z-index: -1;
        }

        .task-card h3 {
            color: Black;
            font-size: 24px;
            margin-top: 0;
        }

        .task-card p {
            color: #333;
        }

        .task-card p.status {
            margin-bottom: 10px;
        }

        .countdown {
            font-size: 18px;
            font-weight: bold;
            color: #fff;
            position: absolute;
            bottom: 20px;
            right: 20px;
        }

        .empty-list {
            text-align: center;
            font-weight: bold;
            margin-top: 20px;
        }

        .edit-button,
        .delete-button {
            font-size: 14px;
            font-weight: bold;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .edit-button {
            background-color: #27ae60;
            color: #fff;
            border: none;
            margin-right: 10px;
        }

        .delete-button {
            background-color: #e74c3c;
            color: #fff;
            border: none;
        }
        
        .add-button{
            padding-bottom: 20px;
        }

        .price-tag {
            position: absolute;
            top: 10px;
            right: 10px;
            width: 60px;
            height: 60px;
            background-color: #27ae60;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .price-tag span {
            color: #fff;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Listagem de locadoras</h2>
        <div class="add-button">
            <a href="cadastrar_locadora.jsp" class="btn btn-primary">Cadastrar locadora</a>
        </div>
        <% if (lista_locadora != null && !lista_locadora.isEmpty()) { %>
            <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 row-cols-xl-4">
                <% for (locadora locadora : lista_locadora) { %>
                    <div class="col mb-4">
                        <div class="task-card">
                            <h3><%= locadora.getCnpj() %></h3>
                            <p><%= locadora.getNome() %></p>
                                                        
                            <div class="btn-group" role="group">
                                <form action="editar_locadora" method="get">
                                    <input type="hidden" name="cnpj" value="<%= locadora.getCnpj() %>">
                                    <button type="submit" class="btn btn-primary edit-button">Editar</button>
                                </form>
                                <form action="excluir_locadora" method="post">
                                    <input type="hidden" name="cnpj" value="<%= locadora.getCnpj() %>">
                                    <button type="submit" class="btn btn-danger delete-button">Excluir</button>
                                </form>
                            </div>
                        </div>
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <p class="empty-list">A lista de eventos está vazia.</p>
        <% } %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
