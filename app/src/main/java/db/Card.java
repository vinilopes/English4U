package db;

/**
 * Created by Vinícius Lopes on 28/11/2017.
 */

public class Card {

    private int cod;
    private String name;
    private int score;


    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
