package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class Read {

    public ArrayList<WordEN> getWordsEN() {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_CARD + " WHERE cdcard = 1";
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

    public ArrayList<WordPT> getWordsPT() {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_PTWORDS + " WHERE cdtheme = 1 ORDER BY RANDOM() LIMIT 5";
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

}
