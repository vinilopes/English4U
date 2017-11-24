package db;

public class WordPT {


    public WordPT(int cod) {
        this.cdtheme = cod;
    }

    private int cdtheme;
    private String word;

    public int getCdtheme() {
        return cdtheme;
    }

    public void setCdtheme(int cdtheme) {
        this.cdtheme = cdtheme;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}