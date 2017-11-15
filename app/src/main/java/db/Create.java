package db;

import android.database.sqlite.SQLiteDatabase;


public class Create {

    public void createTable() {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("CREATE TABLE WordsEN ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cdtema INTEGER)");
        db.execSQL("CREATE TABLE WordsPT ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cdtema INTEGER, cdtranslate INTEGER )");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES(,'Weather',1) ");
        //db.execSQL("INSERT INTO WordsPT ( id, nome, cdtema, cdtranslate)VALUES(,'Clima',1,1) ");
    }


}
