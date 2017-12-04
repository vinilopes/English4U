package db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

//import gm.crudexample.Pessoa;

/**
 * Created by Gilian Marques on 28/09/2017.
 */

public class Update {
/*
    public boolean addPessoa(Pessoa pessoa) {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("UID", pessoa.getUID());
        cv.put("NOME", pessoa.getNome());
        cv.put("IDADE", pessoa.getIdade());
        cv.put("PESO", pessoa.getPeso());
        cv.put("DEFICIENCIA", pessoa.isDeficiente());

        return db.insert(MainDB.TABELA_PESSOA, null, cv) != -1;

    }
*/
    public boolean updateWord(WordEN word) {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("cod", word.getCod());
        cv.put("numerros", word.getNumErros());
        cv.put("finish", word.getFinish());

        String where = "cod = '" + word.getCod() + "'";

        return db.update(MainDB.TB_ENWORDS, cv, where, null) > 0;

    }

    public boolean updateCard(Card card) {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("cod", card.getCod());
        cv.put("name", "card");
        cv.put("score", card.getScore());


        String where = "cod = " + card.getCod();

        return db.update(MainDB.TB_CARD, cv, where, null) > 0;

    }

    public boolean updateUser(User user) {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        int coins = new Read().getUser().getCoins();
        cv.put("cod", user.getCod());
        cv.put("coins", (user.getCoins() + coins ));


        String where = "cod = " + user.getCod();

        return db.update(MainDB.TB_USER, cv, where, null) > 0;

    }

    public boolean updateUser2(User user) {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("cod", user.getCod());
        cv.put("coins", (user.getCoins() ));


        String where = "cod = " + user.getCod();

        return db.update(MainDB.TB_USER, cv, where, null) > 0;

    }


    public boolean CardShop(int cod) {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("cod", cod);
        cv.put("name", "card");
        cv.put("buy", 1);


        String where = "cod = " + cod;

        return db.update(MainDB.TB_CARD, cv, where, null) > 0;

    }

    public boolean Audio(int enable) {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("enable", enable);

        String where = "";

        return db.update(MainDB.TB_CONFIGAUDIO, cv, where, null) > 0;

    }


}
