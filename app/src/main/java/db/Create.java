package db;

import android.database.sqlite.SQLiteDatabase;

import java.io.Console;


public class Create {


    public Create(){
        createWordsEnglishTable(1,
                                "Weather, Fog, Foggy, Snow, Snowy, Light, Cool, Cold, Hot, Warm, Temperature, Sunshine, Overcast, Rain, Rainy, Wind, Windy",
                                "Clima, Neblina, Com Neblina, Neve, Com neve, Claro, Fresco, Frio, Quente, Morno, Temperatura, Sol, Nublado, Chuva, Chuvoso, Vento, Com vento",
                                1);
    }


    public void createWordsEnglishTable(int card, String words,  String translate, int theme) {
        int x;


        //db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_CARD);
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS WordsEN ( cod INTEGER PRIMARY KEY NOT NULL, nome TEXT, cdtema,  cdcard INTEGER, numerros)");


        for (x=0;x<16;x++){
            db.execSQL("INSERT INTO WordsEN ( cod, nome , cdtema, cdcard)VALUES(1,'Weather',1, 1) ");
        }


        //db.execSQL("INSERT INTO WordsPT ( cod, nome, cdtema, cdcard, cdtranslate)VALUES(,'Clima',1, 1,1, 1) ");
    }

}


