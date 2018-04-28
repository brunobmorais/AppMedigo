package com.jp.model;

public class Medico {
    private String nome;
    private String crm;
    private String especialidade;
    private float classificacao;

    public Medico() {

    }

    public Medico(String nome, String crm, String especialidade, float classificacao) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public float getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(float classificacao) {
        this.classificacao = classificacao;
    }
}
