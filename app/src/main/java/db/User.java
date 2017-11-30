package db;

/**
 * Created by Vinícius Lopes on 29/11/2017.
 */

public class User {
    private int cod;
    private String name;
    private int coins;

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

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
