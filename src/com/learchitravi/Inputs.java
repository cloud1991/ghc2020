package com.learchitravi;

import java.util.List;

public class Inputs {

    private int totaleLibri;
    private int totLibrerie;
    private int tempoMassimo;

    private int[] punteggioLibri;

    private List<Libreria> librerie;

    public int getTotaleLibri() {
        return totaleLibri;
    }

    public void setTotaleLibri(int totaleLibri) {
        this.totaleLibri = totaleLibri;
    }

    public int getTotLibrerie() {
        return totLibrerie;
    }

    public void setTotLibrerie(int totLibrerie) {
        this.totLibrerie = totLibrerie;
    }

    public int getTempoMassimo() {
        return tempoMassimo;
    }

    public void setTempoMassimo(int tempoMassimo) {
        this.tempoMassimo = tempoMassimo;
    }

    public int[] getPunteggioLibri() {
        return punteggioLibri;
    }

    public void setPunteggioLibri(int[] punteggioLibri) {
        this.punteggioLibri = punteggioLibri;
    }

    public List<Libreria> getLibrerie() {
        return librerie;
    }

    public void setLibrerie(List<Libreria> librerie) {
        this.librerie = librerie;
    }
}
