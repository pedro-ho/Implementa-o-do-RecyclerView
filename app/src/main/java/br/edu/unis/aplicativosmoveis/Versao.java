package br.edu.unis.aplicativosmoveis;

public class Versao {

    private String versao;
    private String nome;
    private String ano;
    private int backgroundColor;

    public Versao(String versao, String nome, String ano, int backgroundColor) {
        this.versao = versao;
        this.nome = nome;
        this.ano = ano;
        this.backgroundColor = backgroundColor;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
