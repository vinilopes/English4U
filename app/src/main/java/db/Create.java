package db;

import android.database.sqlite.SQLiteDatabase;


public class Create {

    public void createTable() {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS WordsEN ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cdtema INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS WordsPT ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cdtema INTEGER, cdtranslate INTEGER )");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Weather',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Fog',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Foggy',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Snow',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Snowy',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Light',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Cool',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Cold',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Hot',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Warm',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Temperature',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Sunshine',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Overcast',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Rain',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Rainy',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Wind',1) ");
        db.execSQL("INSERT INTO WordsEN ( id, nome , cdtema)VALUES('','Windy',1) ");
        //db.execSQL("INSERT INTO WordsPT ( id, nome, cdtema, cdtranslate)VALUES(,'Clima',1,1) ");
    }


}
