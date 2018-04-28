package com.jp.model;


import java.sql.Date;

public class Consulta {
    private Medico medico;
    private Date data;
    private float confirmacao;

    public Consulta() {
        medico = new Medico();
    }

    public Consulta(Medico medico, Date data, float confirmacao) {
        this.medico = medico;
        this.data = data;
        this.confirmacao = confirmacao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(float confirmacao) {
        this.confirmacao = confirmacao;
    }
}
