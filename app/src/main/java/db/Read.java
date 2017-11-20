package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class Read {

    public ArrayList<Word> getPessoas() {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TB_CARD + " WHERE cdcard = 1";
        ArrayList<Word> words = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {

            do {
                Word word = new Word(c.getString(0));
                word.setNome(c.getString(1));
                word.setCdtema(c.getInt(1));
                words.add(word);
            } while (c.moveToNext());
        }

        c.close();
        return words;
    }

}
