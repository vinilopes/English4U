package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class Read {

    public ArrayList<WordEN> getWordsEN(int card) {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_ENWORDS + " WHERE cdcard = "+card;
        ArrayList<WordEN> words = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {

            do {
                WordEN word = new WordEN(c.getInt(0));
                word.setNome(c.getString(1));
                word.setTranslate(c.getString(2));
                word.setCdtema(c.getInt(3));
                words.add(word);
            } while (c.moveToNext());
        }

        c.close();
        return words;
    }

    public ArrayList<WordEN> getWordsENReview() {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_ENWORDS + " WHERE finish = 1 ORDER BY numerros DESC LIMIT 5";
        ArrayList<WordEN> words = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {

            do {
                WordEN word = new WordEN(c.getInt(0));
                word.setNome(c.getString(1));
                word.setTranslate(c.getString(2));
                word.setCdtema(c.getInt(3));
                words.add(word);
            } while (c.moveToNext());
        }

        c.close();
        return words;
    }

    public WordEN getWordsENReviewCods(int cod) {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_ENWORDS + " WHERE cod = "+cod;
        WordEN word = new WordEN(cod);
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {

                word.setNome(c.getString(1));
                word.setTranslate(c.getString(2));
                word.setCdtema(c.getInt(3));
                word.setNumErros(c.getInt(5));
        }

        c.close();
        return word;
    }

    public int  getWordENErros(int cod) {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_ENWORDS + " WHERE cod = "+cod;
        ArrayList<WordEN> words = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        c.moveToFirst();
        int num = c.getInt(5);
        c.close();
        return num;
    }

    public ArrayList<WordEN> getWordsENLearned() {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_ENWORDS + " WHERE finish = 1 ORDER BY numerros ASC";
        ArrayList<WordEN> words = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {

            do {
                WordEN word = new WordEN(c.getInt(0));
                word.setNome(c.getString(1));
                word.setTranslate(c.getString(2));
                word.setCdtema(c.getInt(3));
                word.setNumErros(c.getInt(5));
                words.add(word);
            } while (c.moveToNext());
        }

        c.close();
        return words;
    }

    public ArrayList<WordPT> getWordsPT(int theme) {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_PTWORDS + " WHERE cdtheme = "+theme+" ORDER BY RANDOM() LIMIT 5";
        ArrayList<WordPT> words = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {

            do {
                WordPT word = new WordPT(c.getInt(0));
                word.setWord(c.getString(1));
                words.add(word);
            } while (c.moveToNext());
        }

        c.close();
        return words;
    }

    public ArrayList<WordPT> getWordsPTReview() {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_PTWORDS + " WHERE cdtheme = 2 ORDER BY RANDOM() LIMIT 5";
        ArrayList<WordPT> words = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {

            do {
                WordPT word = new WordPT(c.getInt(0));
                word.setWord(c.getString(1));
                words.add(word);
            } while (c.moveToNext());
        }

        c.close();
        return words;
    }

    public int  viewProgress(int card){
        int score = 0;
        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_CARD + " WHERE cod = "+card;
        ArrayList<Card> cards = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            score = c.getInt(2);
        }

        c.close();
        return score;
    }

    public  User getUser(){
        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_USER + " WHERE cod = 0";
        Cursor c = db.rawQuery(query, null);
        User user = new User();
        if (c.moveToFirst()) {
            user.setCod(c.getInt(0));
            user.setName(c.getString(1));
            user.setCoins(c.getInt(2));
        }
        return user;
    }

    public  Card getCardStatus(int cod){
        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_CARD + " WHERE cod = "+cod;
        Cursor c = db.rawQuery(query, null);
        Card card = new Card();
        if (c.moveToFirst()) {
            card.setCod(c.getInt(0));
            card.setName(c.getString(1));
            card.setScore(c.getInt(2));
        }
        return card;
    }

}
