package acgkv.english4u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import db.Card;
import db.Read;
import db.Update;
import db.User;
import db.WordEN;

public class reviewscore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int [] result;
        int [] cods;
        WordEN wordEN = new WordEN(1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewscore);
        Button buttonContinue = (Button) findViewById(R.id.cont);
        Bundle extras = getIntent().getExtras();
        result = extras.getIntArray("result");
        cods = extras.getIntArray("cods");

        for (int i=0; i<5; i++){
            WordEN word = new Read().getWordsENReviewCods(cods[i]);
            word.setFinish(1);
            if(result[i]==1){
                word.setNumErros(0);
                if(word.getNumErros() == 0){
                    word.setNumErros(0);
                }else{
                    word.setNumErros((word.getNumErros() - 1));
                }
            }else{
                word.setNumErros((word.getNumErros() + 1));
            }
            new Update().updateWord(word);
        }

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(reviewscore.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}

