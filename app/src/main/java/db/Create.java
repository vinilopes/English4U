package db;

import android.database.sqlite.SQLiteDatabase;

public class Create {
    int x =0;

    public Create(String userName){
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_USER);
        db.execSQL("CREATE TABLE IF NOT EXISTS User ( cod INTEGER PRIMARY KEY NOT NULL, name TEXT, coins INTEGER)");
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_CARD);
        db.execSQL("CREATE TABLE IF NOT EXISTS Cards ( cod INTEGER PRIMARY KEY NOT NULL, name TEXT, score INTEGER)");
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_ENWORDS);
        db.execSQL("CREATE TABLE IF NOT EXISTS WordsEN ( cod INTEGER PRIMARY KEY NOT NULL, word TEXT, translate TEXT, cdtema INTEGER,  cdcard INTEGER, numerros INTEGER, finish INTEGER )");
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_PTWORDS);
        db.execSQL("CREATE TABLE IF NOT EXISTS WordsPT ( cdtheme INTEGER, word TEXT)");


        createProfile(userName);
        createCards();

        createWordsEnglishTable(1,
                                "Weather, Fog, Foggy, Snow, Snowy, Light, Cool, Cold, Hot, Warm, Temperature, Sunshine, Overcast, Rain, Rainy, Wind",
                                "Clima, Neblina, Com Neblina, Neve, Com neve, Claro, Fresco, Frio, Quente, Morno, Temperatura, Sol, Nublado, Chuva, Chuvoso, Vento",
                                1);
        createWordsPortugueseTable (1,
                                    "Temperatura, Neve, Castelo, Nevoeiro, Viagem, Chuva, Sapo, Pastel, Lugar, Pesado, Chuva, Sol, Lua, Calor, Frio,  Claro, Luz, Com chuva, com sol, com tempestade, com nuvem, Escuro, luminária, tempo,  Ventania, Frio, morno, abafado, Abafado, Gelo, Certo, Derreter, Arvore, Verão ,Ensolarado, Raio, Por do Sol, Ensolarado, Chuvoso, Gelado, Temporal, Nublado, Sorvete");
        createWordsEnglishTable(2,
                                "Trip, Away, Terrific, Fantastic, To Travel, To Enjoy, Place, Famous, Hotel, GasLike, Picture, Camping, Fishing, Picnic, Castle, Bonfire",
                                "Viagem, Longe, Magnifico, Fantastico, Viajar, Gostar, Lugar, Famoso, Hotel, Gasolina,  Foto, Acampar, Pescar, Piquenique, Castelo, Fogueira",
                                2);
        createWordsPortugueseTable (2,
                                    "Férias, Tempo, Terra, Feriado, Posto, Família, Almoçar, Pastelaria, Pescar, Pegar, Olhar, Gostar, Olá, Casa, Show, Pintura, Planta, Poster, Fotográfo, Slide");
        createWordsEnglishTable(3,
                                "Creative, Selfish, Humble, Useless, Careless, Moody, Greedy, Honest, Dishonest, Curious, Fussy, Proud, Coward, Understanding, Charming, Reliable",
                                "Creativo, Egoísta, Humilde, Inútil, Descuidado, Mal-humorado, Ganancioso, Honesto, Desonesto, Curioso, Exigente, Orgulhoso, Covarde, Compreensivo, Charmoso, Confiável",
                                3);
        createWordsPortugueseTable (3,
                                      "Legal, Confiável, Confiante, Divertidamente, População, Chato, Terrível, Calor, Metido, Convencido, Determinação, Perfeito, Perfeição, Bonito, Natural, Sorriso, Alegre, Encantador, Exigencia, Errado, Aparência,  Ótimo, Felicidade, Feliz, Final,  Belo, Gentileza, Desconfiante, Motivador, Amigável, Comportado, Bondoso, Briguento, Burro, Cafona, Idiota, Cansado, Carente, Carinhoso, Caro, Baixo");
        createWordsEnglishTable(4,
                                "Recipe, Roast, Oven, Sauce, Pan, Frying Pan, Baking Pan, Bowl, Soup, Boil, Fry, Grill, Chop, Grate, Plate, Fork",
                                "Receita, Assado, Forno, Molho, Panela, Frigideira, Assadeira, Tigela, Sopa, Ferver, Fritar,  Grelhar, Picar, Ralar, Prato, Garfo",
                                4);
        createWordsPortugueseTable (4,
                                "Descascar, Fatiar, Despejar, Assadeira, Pote, Bater, Derramar, Coletar, Misturar, Mixer, Cozinhar, Olhar, Verificar, Macarrão, Carne, Observar, Encontrar, Colher, Garfo, Faca, Tabuleiro, Tábua, Testar, Derreter, Gelatina, Bolo, Suco, Jogar, Vegetais, Legumes, Prato, Legal, Bonito, Ótimo, Queijo, Banana, Delicioso, Íncrivel, Pão, Céu, Tem, Possuir, Queimado, Queimar, Mergulhar, Fatiado, Cortado, Coelho, Molhado, Previsão");
        createWordsEnglishTable(5,
                                "Favor, Promise, Cigarrete, Garbage, Bag, Suitcase, Briefcase, Backpack, Groceries, Keep, Pass, Smoke, Carry, Throw Away, Please, Sneaker ",
                                "Favor, Promessa, Cigarro, Lixo, Bolsa, Mala, Maleta, Mochila, Mantimentos, Manter, Passar, Fumar, Carregar, Jogar Fora, Por Favor, Tênis",
                                5);
        createWordsPortugueseTable (5,
                                "Agora, Já, Teste, Pedir, Desejar, Quero, Querer, Obter, Comprar, Supermercado, Fora, Lixo, Fumaça, Segurar, Lixadeira, Perfume, Camisa, Falsa, Falsidade, Meta, Sujeira, Fumei, Compre, Possuir, Desejar,  Procurar, Assistir, Reclamar, Sim, Jeito, Nenhum, Nunca, Fé, Show, Desista");
        createWordsEnglishTable(6,
                                "Directions, Library, Bookstore, Drugstore, Supermarket, Gas Station, Travel Agency, Newsstand, Museum, Church, Night Club, Building, Block, House, Police Station, City Hall",
                                "Direções, Biblioteca, Livraria, Farmácia, Supermercado, Posto de Gasolina, Agencia de Turismo, Banca de Jornal, Museu, Igreja, CasaNoturna, Prédio, Quarteirão, Casa, Delegacia, Prefeitura ",
                                6);
        createWordsPortugueseTable (6,
                                "Panificadora, Hotel, Motel, Apartamento, Casa, Hotelaria, Chapéu, Clube, Luta, Esquerda, Direita, Correios, Trabalho, Loja, Noite, Esquina, Semafáro, Leva, Lavanderia, Padaria, Como, Restaurante, Praia, Festival, Licença, Oposto, Hospital, Maternidade, Por, Em, Volta, Ajuda, Taxi, Gasolina, Gás, Natural, Sim, Rua, Avenida");
        createWordsEnglishTable(7,
                                "Swimming, Handbool, Bowling, Boxing, Judo, Aerobics, Pool, Yoga, Soccer, Running, Exercise, Game, Team, Player, Football, Basketball",
                                "Natação, Handebol, Boliche, Boxe, Judo, Aeróbicos, Sinuca, Yoga, Futebol, Corrida, Exercícios, Jogo, Time, Jogador, Futebol Americano, Basquete ",
                                7);
        createWordsPortugueseTable (7,
                                "Caminhada, Piscina, Bola, Academia, Peso, Levantamento, Acordar, Pescar, Demonstrar, Andar, Seleção, Gol, Boleiro, America, Cesta, Jogatina, Secador, Exercitar, Corredor, Corrida, Carro,  Formula, Esportista, Volei, Passe, Rua, Boxeador, Boné, Mãos, Biclicleta, Demonstração, Platéia");
        createWordsEnglishTable(8,
                                "Soap Opera, News, Program, Show, Pop, Rap, Classical, Thriller, Comedy, Action, Horror, Chess, Checkers, Funny, Interesting, Exciting",
                                "Novela, Noticiário, Programa, Programa, Pop, Rap, Clássico, Suspenso, Comédia, Ação, Terror, Xadrez, Damas, Engraçado, Interessante, Emocionante",
                                8);
        createWordsPortugueseTable (8,
                                "Opera, Sopa, Popular, Classificação, Programação, Música, Divertidamente, Horror, Queijo, Cheque, Checar, Fanatíco, Interesse, Exitante, Extâse, Chato, Mesmo, Igual, Sertanejo, Funk, Diversão, Cansado, Futebol, Carro, Axé, Samba, Pagode, Filme, Cinema, Jogador, Gente, Pessoas, Corrida, Oportunidade, Jornal");
        createWordsEnglishTable(9,
                                "Main, Meal, Barbecue, Snack, Appetizer, Dessert, Course, Vegetable, Dressing, Seasoning, Sugar, Sweetener, Salt, Pepper, Taste, Delicious",
                                "Principal, Refeição, Churrasco, Lanche, Entrada, Sobremesa, Prato(Refeição), Legume, Tempero(Salada), Tempero, Açucar, Adoçante, Sal, Pimenta, Sabor, Delicioso",
                                9);
        createWordsPortugueseTable (9,
                                "Principio, Mel, Barba, Saco, Sacola, Aperitivo, Apartamento, Curso, Deserto, Certo, Dever, Verde, Mesa, Vestido, Dragão, Temporada, Doceria, Panificadora, Pastel, Hamburguer, Pepino, Pastelaria, Arroz, Feijão, Pão, Alface, Salada, Horrível, Péssimo, Gostoso, Gostosa, Pizza, Bom, Ruim, Batata, Banana, Café, Sopa, Refrigerante, Agua ");
        createWordsEnglishTable(10,
                                "Head, Face, Mouth, Tooth, Lip, Tongue, Nose, Ear, Neck, Arm, Hand, Foot, Leg, Nail, Injury, Wound",
                                "Cabeça, Rosto, Boca, Dente, Lábio, Língua, Nariz, Orelha, Pescoço, Braço, Mão, Pé, Perna, Unha, Lesão, Machucado",
                                10);
        createWordsPortugueseTable (10,
                                "Testa, Abraço, Dedo, Prego, Magoar, Doer, Gente, Acidente, Olhos, Faca, Arma, Batom, Fada, Futebol, Nata, Injúria, Imaginação, Perfeição, Sorriso, Barba, Bigode, Mundo, Pensamento, Quebrar, Madeira, Joelho, Canela, Cirurgia, Corte, Queimadura, Preto, Branco, Calça, Sapato, Cicatriz");

    }

    private void createProfile(String name) {

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        db.execSQL("INSERT INTO User ( cod, name , coins) VALUES(0, '"+name+"', 0) ");
    }

    private void createCards() {
        int i;

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        for (i=1;i<13;i++){
            db.execSQL("INSERT INTO Cards ( cod, name , score) VALUES("+i+", 'card', 0) ");
        }
    }


    public void createWordsEnglishTable(int card, String words,  String translate, int theme) {
        int i;

        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
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
        String words_list[] = words.split(", ");
        for (i=0;i<16;i++){
            db.execSQL("INSERT INTO WordsPT ( cdtheme, word)VALUES("+theme+", '"+words_list[i]+"') ");
        }
    }
}


