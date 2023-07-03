package model;

public class editora {
    private int id;
    private String cnpj;
    private String nome;

    public editora(int id, String cnpj, String nome) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
