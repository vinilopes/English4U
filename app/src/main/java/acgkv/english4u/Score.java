package acgkv.english4u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import db.Card;
import db.Read;
import db.Update;
import db.User;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int [] result = new int[15];
        int contPonits = 0;
        int numReward;
        Card card = new Card();
        User user = new User();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Button buttonContinue = (Button) findViewById(R.id.cont);
        TextView stars = (TextView) findViewById(R.id.stars);
        TextView reward = (TextView) findViewById(R.id.reward);
        Bundle extras = getIntent().getExtras();
        result = extras.getIntArray("result");
        int cardPhase = extras.getInt("card");


        for (int i=1; i<17; i++){
            if(result[i]==1){
                contPonits++;

            }else{

            }
        }
        card.setScore(0);
        user.setCod(0);
        stars.setText("Sem Estrelas");
        reward.setText("Sem recompensa");
        int previusScore = new Read().getCardStatus(cardPhase).getScore();
        if(contPonits>0 && contPonits < 10 ){
            if(previusScore < 1) {
                card.setScore(1);
                user.setCoins(5);
                stars.setText("1 Estrela");
                reward.setText("5 Moedas");
            }else{
                stars.setText("1 Estrelas");
                reward.setText("Obtido");
            }
        }
        if(contPonits>9 && contPonits < 15){
            if(previusScore < 2) {
                card.setScore(2);
                user.setCoins(5);
                stars.setText("2 Estrelas");
                reward.setText("10 Moedas");
            }else{
                stars.setText("2 Estrelas");
                reward.setText("Obtido");
            }
        }
        if(contPonits>14){
            if(previusScore < 3) {
                card.setScore(3);
                user.setCoins(10);
                stars.setText("3 Estrelas");
                reward.setText("20 Moedas");
            }else {
                stars.setText("3 Estrelas");
                reward.setText("Obtido");
            }
        }

        card.setCod( extras.getInt("card"));

        new Update().updateCard(card);
        new Update().updateUser(user);
       //new Update().updateWordsEN();
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Score.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
