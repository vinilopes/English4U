package db;

import android.database.sqlite.SQLiteDatabase;

public class Create {
    int x =0;

    public Create(){

        createWordsEnglishTable(1,
                                "Weather, Fog, Foggy, Snow, Snowy, Light, Cool, Cold, Hot, Warm, Temperature, Sunshine, Overcast, Rain, Rainy, Wind, Windy",
                                "Clima, Neblina, Com Neblina, Neve, Com neve, Claro, Fresco, Frio, Quente, Morno, Temperatura, Sol, Nublado, Chuva, Chuvoso, Vento, Com vento",
                                1);
        createWordsPortugueseTable (1,
                                    "Temperatura, Neve, Castelo, Nevoeiro, Viagem, Chuva, Sapo, Pastel, Lugar, Pesado, Chuva, Sol, Lua, Calor, Frio,  Claro, Luz, Com chuva, com sol, com tempestade, com nuvem, Escuro, luminária, tempo,  Ventania, Frio, morno, abafado, Abafado, Gelo, Certo, Derreter, Arvore, Verão ,Ensolarado, Raio, Por do Sol, Ensolarado, Chuvoso, Gelado, Temporal, Nublado, Sorvete");
    }


    public void createWordsEnglishTable(int card, String words,  String translate, int theme) {
        int i;

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_CARD);
        db.execSQL("CREATE TABLE IF NOT EXISTS WordsEN ( cod INTEGER PRIMARY KEY NOT NULL, word TEXT, translate TEXT, cdtema INTEGER,  cdcard INTEGER, numerros INTEGER )");

        String words_list[] = words.split(", ");
        String translate_list[] = translate.split(", ");
        for (i=0;i<16;i++){
            db.execSQL("INSERT INTO WordsEN ( cod, word , translate, cdtema, cdcard, numerros)VALUES("+x+",'"+words_list[i]+"','"+translate_list[i]+"', "+theme+", "+card+", 0) ");
            x++;
        }
    }

    public void createWordsPortugueseTable(int theme, String words) {
        int i;

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_PTWORDS);
        db.execSQL("CREATE TABLE IF NOT EXISTS WordsPT ( cdtheme INTEGER, word TEXT)");

        String words_list[] = words.split(", ");
        for (i=0;i<16;i++){
            db.execSQL("INSERT INTO WordsPT ( cdtheme, word)VALUES("+theme+", '"+words_list[i]+"') ");
        }
    }
}


