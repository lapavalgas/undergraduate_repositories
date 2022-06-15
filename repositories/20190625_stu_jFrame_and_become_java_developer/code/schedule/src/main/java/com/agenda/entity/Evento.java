package com.agenda.entity;

public class Evento {

    private int id_evento;
    private String title, resumo;

    public Evento() {
    }

    public void CcadastraEvento(String title, String resumo) {
        this.title = title;
        this.resumo = resumo;
    }

    public void CarregaEvento(int id_evento, String title, String resumo) {
        this.id_evento = id_evento;
        this.title = title;
        this.resumo = resumo;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String toString() {
        return "" + title;
    }

}
