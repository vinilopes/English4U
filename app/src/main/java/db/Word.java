package db;

import java.util.Random;

import java.util.Random;


public class Word {


    public Word(String ID) {
        this.ID = ID;
    }

    private final String ID;
    private String nome;
    private int cdtema;

    public String getID() {
        return ID;
    }


    public static String criarUID() {
        return "@Word:" + System.currentTimeMillis() + new Random().nextDouble();
    }

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
}
