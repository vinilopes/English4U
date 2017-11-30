package db;

import android.database.sqlite.SQLiteDatabase;

public class Create {
    int x =0;

    public Create(String userName){
        createProfile(userName);
        createCards();

        createWordsEnglishTable(1,
                                "Weather, Fog, Foggy, Snow, Snowy, Light, Cool, Cold, Hot, Warm, Temperature, Sunshine, Overcast, Rain, Rainy, Wind, Windy",
                                "Clima, Neblina, Com Neblina, Neve, Com neve, Claro, Fresco, Frio, Quente, Morno, Temperatura, Sol, Nublado, Chuva, Chuvoso, Vento, Com vento",
                                1);
        createWordsPortugueseTable (1,
                                    "Temperatura, Neve, Castelo, Nevoeiro, Viagem, Chuva, Sapo, Pastel, Lugar, Pesado, Chuva, Sol, Lua, Calor, Frio,  Claro, Luz, Com chuva, com sol, com tempestade, com nuvem, Escuro, luminária, tempo,  Ventania, Frio, morno, abafado, Abafado, Gelo, Certo, Derreter, Arvore, Verão ,Ensolarado, Raio, Por do Sol, Ensolarado, Chuvoso, Gelado, Temporal, Nublado, Sorvete");
    }

    private void createProfile(String name) {
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_USER);
        db.execSQL("CREATE TABLE IF NOT EXISTS User ( cod INTEGER PRIMARY KEY NOT NULL, name TEXT, coins INTEGER)");
        db.execSQL("INSERT INTO User ( cod, name , coins) VALUES(0, '"+name+"', 0) ");
    }

    private void createCards() {
        int i;
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_CARD);
        db.execSQL("CREATE TABLE IF NOT EXISTS Cards ( cod INTEGER PRIMARY KEY NOT NULL, name TEXT, score INTEGER)");
        for (i=1;i<13;i++){
            db.execSQL("INSERT INTO Cards ( cod, name , score) VALUES("+i+", 'card', 0) ");
        }
    }


    public void createWordsEnglishTable(int card, String words,  String translate, int theme) {
        int i;

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_ENWORDS);
        db.execSQL("CREATE TABLE IF NOT EXISTS WordsEN ( cod INTEGER PRIMARY KEY NOT NULL, word TEXT, translate TEXT, cdtema INTEGER,  cdcard INTEGER, numerros INTEGER, finish INTEGER )");

        String words_list[] = words.split(", ");
        String translate_list[] = translate.split(", ");
        for (i=0;i<16;i++){
            db.execSQL("INSERT INTO WordsEN ( cod, word , translate, cdtema, cdcard, numerros, finish)VALUES("+x+",'"+words_list[i]+"','"+translate_list[i]+"', "+theme+", "+card+", 0, 0) ");
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


