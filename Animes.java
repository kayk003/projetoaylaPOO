package br.ufpb.dcx.animes;

import java.util.Objects;

public class Animes {

    private String nome;
    private String pais;
    private int ano;

    public Animes(String nome, String pais, int ano){

        this.nome = nome;
        this.pais = pais;
        this.ano = ano;
    }
    public Animes(){
        this("","", 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animes animes = (Animes) o;

        if (ano != animes.ano) return false;
        if (!Objects.equals(nome, animes.nome)) return false;
        return Objects.equals(pais, animes.pais);
    }

    public String toString(){
        return "Anime de nome: "+this.nome+", que fica no país: "+this.pais+", lançado no ano de: "+this.ano;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        result = 31 * result + ano;
        return result;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getPais(){
        return pais;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }










}
