package db;

import java.util.Random;

import java.util.Random;


public class WordEN {


    public WordEN(int cod) {
        this.cod = cod;
    }

    private int cod;
    private String nome;
    private String translate;
    private int cdtema;
    private int numErros;
    private int finish;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCdtema() {
        return cdtema;
    }

    public void setCdtema(int cdtema) {
        this.cdtema = cdtema;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTranslate() {
        return translate;
    }

    public int getNumErros() {
        return numErros;
    }

    public void setNumErros(int numErros) {
        this.numErros = numErros;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }
}
