package org.example.model;

public class Loja {
    private int numeroLoja;
    private String razaoSocial;
    private String nomeFantasia;
    private String nomeCidade;
    private String cnpj;
    private String endereco;

    //agora vamos criar os metodos publicos para acesso das variaveis
    public int getNumeroLoja(){
        return this.numeroLoja;
    }
    public void setNumeroLoja(int numeroLoja){
        this.numeroLoja = numeroLoja;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
