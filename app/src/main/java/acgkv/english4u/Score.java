package acgkv.english4u;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import db.Card;
import db.Read;
import db.Update;
import db.User;
import db.WordEN;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int [] result = new int[15];
        int contPonits = 0;
        int numReward, z;
        Card card = new Card();
        User user = new User();
        WordEN wordEN = new WordEN(1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Button buttonContinue = (Button) findViewById(R.id.cont);
        TextView stars = (TextView) findViewById(R.id.stars);
        TextView reward = (TextView) findViewById(R.id.reward);
        Bundle extras = getIntent().getExtras();
        result = extras.getIntArray("result");
        int cardPhase = extras.getInt("card");
        ImageButton star1 = (ImageButton) findViewById(R.id.star1);
        ImageButton star2 = (ImageButton) findViewById(R.id.star2);
        ImageButton star3 = (ImageButton) findViewById(R.id.star3);

        int p;
        for (int i=0; i<16; i++){
            if(cardPhase != 1){
                z = 16;
                p = (cardPhase -1);
            }else {
                z = 0;
                p = 0;
            }
            wordEN.setFinish(1);
            wordEN.setCod(((p * z)+i));
            if(result[i]==1){
                contPonits++;
                wordEN.setNumErros(0);
                if(new Read().getWordENErros(((p * z)+i)) == 0){
                    wordEN.setNumErros(0);
                }else{
                    wordEN.setNumErros(((new Read().getWordENErros(((p * z)+i))) - 1));
                }
            }else{
                if(new Read().getWordENErros(((p * z)+i)) < 3){
                    wordEN.setNumErros(((new Read().getWordENErros(((p * z)+i))) + 1));
                }
            }
            new Update().updateWord(wordEN);
        }
        int previusScore = new Read().getCardStatus(cardPhase).getScore();
        card.setScore(previusScore);
        user.setCod(0);
        star1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
        star2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
        star3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
        reward.setText("Sem recompensa");
        if(contPonits>0 && contPonits < 10){
            if(previusScore < 1) {
                card.setScore(1);
                user.setCoins(5);
                reward.setText("5 Moedas");
            }else{
                reward.setText("Obtido");
            }
            star1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_on));
            star2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
            star3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
        }
        if(contPonits>9 && contPonits < 15){
            if(previusScore < 2) {
                card.setScore(2);
                user.setCoins(10);
                reward.setText("10 Moedas");
            }else{
                reward.setText("Obtido");
            }
            star1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_on));
            star2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_on));
            star3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
        }
        if(contPonits>14){
            if(previusScore < 3) {
                card.setScore(3);
                user.setCoins(20);
                reward.setText("20 Moedas");
            }else {
                reward.setText("Obtido");
            }
            star1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_on));
            star2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_on));
            star3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_on));
        }

        card.setCod( extras.getInt("card"));

        new Update().updateCard(card);
        new Update().updateUser(user);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Score.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
