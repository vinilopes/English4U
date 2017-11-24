package acgkv.english4u;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import db.Read;
import db.Update;
import db.WordEN;
import db.WordPT;

public class solvecard extends AppCompatActivity {

    Button ok;
    ProgressBar bar;
    WordEN wordsEN;
    WordPT wordsPT;
    Random rand = new Random();
    int numberOfButton;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solvecard);
        getWordsEN(0);
        getWordsPT();



        //CARTÃO2
        ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

             bar = (ProgressBar)   findViewById(R.id.progress);
                bar.setProgress(bar.getProgress() + 10);
               // checkAnswer();
                if(i<16){
                getWordsEN(i++);
                getWordsPT();
                }else{
                //tela de pontuação
                }
            }
        });
    }

    private void checkAnswer() {
        //verifica respota
        new Update().updateWord(wordsEN);
    }



    private void getWordsEN(int card){
        TextView englishWord = (TextView) findViewById(R.id.englishword);
        numberOfButton = rand.nextInt(6);

        String buttonID = "b" + numberOfButton;
        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        Button englishTranslate = ((Button) findViewById(resID));

        ArrayList<WordEN> mWords = new Read().getWordsEN();

        wordsEN = mWords.get(card);
        englishWord.setText(wordsEN.getNome());
        englishTranslate.setText(wordsEN.getTranslate());

    }

    private void getWordsPT(){
        int x;
        int y=0;
        String buttonID;
        TextView englishWord = (TextView) findViewById(R.id.b1);
        ArrayList<WordPT> mWords = new Read().getWordsPT();

        for (x=0; x<6; x++) {


            buttonID = "b" + x;
            if (x != numberOfButton) {
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                Button ptWords = ((Button) findViewById(resID));
                wordsPT = mWords.get(y);
                ptWords.setText(wordsPT.getWord());
                y++;
            }
        }

    }
}
