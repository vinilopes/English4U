package acgkv.english4u;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import db.Read;
import db.Update;
import db.WordEN;
import db.WordPT;

public class solvecard extends AppCompatActivity {

    Button ok;
    Button  selectorsb0, selectorsb1, selectorsb2, selectorsb3, selectorsb4, selectorsb5;
    ProgressBar bar;
    WordEN wordsEN;
    WordPT wordsPT;
    Random rand = new Random();
    boolean isCorrect;
    boolean isPressed;
    int numberOfButton, card;
    String textButton;
    int i = 1;
    int [] results = new int [17];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solvecard);
        Bundle extras = getIntent().getExtras();
        card = extras.getInt("card");
        getWordsEN(0, card);
        getWordsPT();
        disableSend();
        buttonsNormalizeAll();
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.yes);

        /*BUTONS SELECT*/

        selectorsb0 = (Button) findViewById(R.id.b0 );
        selectorsb0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enableSend();
                selectorsb0.setBackgroundColor(Color.parseColor("#008B8B"));
                textButton = selectorsb0.getText().toString();
                buttonsNormalize(0);
            }
        });

        selectorsb1 = (Button) findViewById(R.id.b1);
        selectorsb1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    enableSend();
                    selectorsb1.setBackgroundColor(Color.parseColor("#008B8B"));
                    textButton = selectorsb1.getText().toString();
                    buttonsNormalize(1);
                }
        });

        selectorsb2 = (Button) findViewById(R.id.b2);
        selectorsb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enableSend();
                selectorsb2.setBackgroundColor(Color.parseColor("#008B8B"));
                textButton = selectorsb2.getText().toString();
                 buttonsNormalize(2);
            }
        });

        selectorsb3 = (Button) findViewById(R.id.b3);
        selectorsb3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enableSend();
                selectorsb3.setBackgroundColor(Color.parseColor("#008B8B"));
                textButton = selectorsb3.getText().toString();
                 buttonsNormalize(3);
            }
        });

        selectorsb4 = (Button) findViewById(R.id.b4);
        selectorsb4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enableSend();
                selectorsb4.setBackgroundColor(Color.parseColor("#008B8B"));
                textButton = selectorsb4.getText().toString();
                 buttonsNormalize(4);
            }
        });
        selectorsb5 = (Button) findViewById(R.id.b5);
        selectorsb5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enableSend();
                selectorsb5.setBackgroundColor(Color.parseColor("#008B8B"));
                textButton = selectorsb5.getText().toString();
                 buttonsNormalize(5);
            }
        });

        //Botao OK
        ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                if(isPressed) {
                    isCorrect =  (textButton.equals(wordsEN.getTranslate()));
                    disableSend();
                    Intent myIntent = new Intent(solvecard.this, PopupSolveCard.class);
                    myIntent.putExtra("answerStatus", isCorrect);
                    myIntent.putExtra("correctWord", wordsEN.getTranslate());
                    startActivity(myIntent);
                    int idStatus = getResources().getIdentifier("s" + i, "id", getPackageName());
                    LinearLayout status = (LinearLayout) findViewById(idStatus);
                    if(isCorrect){
                        status.setBackgroundColor(Color.parseColor("#2AC531") );
                        results[(i-1)] = 1;
                        mp.start();
                    }else{
                        status.setBackgroundColor(Color.parseColor("#C70039") );
                        results[(i-1)] = 0;
                    }
                    buttonsNormalize(67);
                }
                if(i<16){

                    getWordsEN(i++, card);
                    getWordsPT();
                }else{
                    Intent myIntent = new Intent(solvecard.this, Score.class);
                    myIntent.putExtra("result", results);
                    myIntent.putExtra("card", card);
                    startActivity(myIntent);
                }
            }
        });
    }


    private void enableSend(){
        isPressed = true;
        ok = (Button) findViewById(R.id.ok);
        ok.setEnabled(true);
    }

    private void disableSend(){
        isPressed = false;
        ok = (Button) findViewById(R.id.ok);
        ok.setEnabled(false);
    }

    private void checkAnswer() {
        //verifica respota
        new Update().updateWord(wordsEN);
    }

    private void buttonsNormalize(int numButton ) {
        Button[] button = new Button[6];
        for (int i = 0; i < 6; i++) {
            int id = getResources().getIdentifier("b" + i, "id", getPackageName());
            button[i] = (Button) findViewById(id);
        }
        for (int i = 0; i < 6; i++) {
          if(i != numButton) {
              button[i].setBackgroundColor(Color.BLACK);
          }
        }
    }

    private void buttonsNormalizeAll( ) {
        Button[] button = new Button[6];
        for (int i = 0; i < 6; i++) {
            int id = getResources().getIdentifier("b" + i, "id", getPackageName());
            button[i] = (Button) findViewById(id);
        }
        for (int i = 0; i < 6; i++) {
                button[i].setBackgroundColor(Color.BLACK);
        }
    }
    private void getWordsEN(int card, int card_real){
        TextView englishWord = (TextView) findViewById(R.id.englishword);
        numberOfButton = rand.nextInt(6);

        String buttonID = "b" + numberOfButton;
        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        Button englishTranslate = ((Button) findViewById(resID));

        ArrayList<WordEN> mWords = new Read().getWordsEN(card_real);

        wordsEN = mWords.get(card);
        englishWord.setText(wordsEN.getNome());
        englishTranslate.setText(wordsEN.getTranslate());

    }

    private void getWordsPT(){
        int x;
        int y=0;
        String buttonID;
        ArrayList<WordPT> mWords = new Read().getWordsPT(card);

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
