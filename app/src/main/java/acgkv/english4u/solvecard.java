package acgkv.english4u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import db.Read;
import db.Word;

public class solvecard extends AppCompatActivity {

    Button ok;
    ProgressBar bar;
    Word words;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solvecard);
        getWords(0);



        //CARTÃO2
        ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

             bar = (ProgressBar)   findViewById(R.id.progress);
                bar.setProgress(bar.getProgress() + 10);
                getWords(i++);
            }
        });
    }

    private void getWords(int card){
        TextView englishWord = (TextView) findViewById(R.id.englishword);
        ArrayList<Word> mWords = new Read().getPessoas();

        words = mWords.get(card);
        englishWord.setText(words.getNome());

    }
}
