
package br.senac.pi;

public class LinhaTabelaProdutos {
    private int id;
    private String nome;
    private double preco;
    private String fabricante;
    private String categoria;

    public LinhaTabelaProdutos(int id, String nome, double preco, String fabricante, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.fabricante = fabricante;
        this.categoria = categoria;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
      
}
