package model;

public class livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private double preco;
    private int editoraId;

    public livro(int id, String titulo, String autor, int ano, double preco, int editoraId) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.preco = preco;
        this.editoraId = editoraId;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(int editoraId) {
        this.editoraId = editoraId;
    }
}
