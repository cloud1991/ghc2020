package com.learchitravi;

import java.util.ArrayList;
import java.util.List;

public class Libreria implements Comparable<Libreria>{

    private int idLibreria;

    private int numeroLibri;
    private int signUp;
    private int numeroLibriAlGiorno;

    private Integer[] idLibri;

    private int scoreTotLibri;
    private float score;

    private int libriDaMandare;
    private List<Integer> idLibriDaMandare;

    public Libreria() {
        idLibriDaMandare = new ArrayList<>();
    }

    public int getIdLibreria() {
        return idLibreria;
    }

    public void setIdLibreria(int idLibreria) {
        this.idLibreria = idLibreria;
    }

    public int getNumeroLibri() {
        return numeroLibri;
    }

    public void setNumeroLibri(int numeroLibri) {
        this.numeroLibri = numeroLibri;
    }

    public int getSignUp() {
        return signUp;
    }

    public void setSignUp(int signUp) {
        this.signUp = signUp;
    }

    public int getNumeroLibriAlGiorno() {
        return numeroLibriAlGiorno;
    }

    public void setNumeroLibriAlGiorno(int numeroLibriAlGiorno) {
        this.numeroLibriAlGiorno = numeroLibriAlGiorno;
    }

    public Integer[] getIdLibri() {
        return idLibri;
    }

    public void setIdLibri(Integer[] idLibri) {
        this.idLibri = idLibri;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getScoreTotLibri() {
        return scoreTotLibri;
    }

    public void setScoreTotLibri(int scoreTotLibri) {
        this.scoreTotLibri = scoreTotLibri;
    }

    public int getLibriDaMandare() {
        return libriDaMandare;
    }

    public void setLibriDaMandare(int libriDaMandare) {
        this.libriDaMandare = libriDaMandare;
    }

    public List<Integer> getIdLibriDaMandare() {
        return idLibriDaMandare;
    }

    public void setIdLibriDaMandare(List<Integer> idLibriDaMandare) {
        this.idLibriDaMandare = idLibriDaMandare;
    }

    public float calcolaScore(int totLibri) {
        float s = 0;

        float alpha = 1;
        float beta = 100f;

        s = (1 * beta * numeroLibriAlGiorno * numeroLibri*numeroLibri) / (1 *  ( alpha * signUp*signUp*signUp ));

        //System.out.println(idLibreria + " - " + signUp);

        return s;
    }

    @Override
    public int compareTo(Libreria o) {
        return (int) - Math.signum(this.score - o.getScore());
    }

}
