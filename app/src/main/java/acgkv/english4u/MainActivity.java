package acgkv.english4u;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import db.Create;
import db.Read;


public class MainActivity extends AppCompatActivity {
    Button buttonVocabulary, buttonCard1, buttonCard2, buttonCard3, buttonCard4, buttonCard5, buttonCard6, buttonCard7, buttonCard8, buttonCard9, buttonCard10, buttonCard11, buttonCard12;
    Button buttonReview;
    Button [] buttonCard = new Button[14];
    Button buttonShop;
    Button buttonConfig;
    int  x;
    int [] index = new int[14];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();

        //CRIAÇÃO DO BD
        try {
            if (extras.getInt("running") == 1) {
                new Create(extras.getString("username"));
            }
        }catch (Throwable e){

        }
        //DADOS DO USER
        TextView user = (TextView) findViewById(R.id.username);
        user.setText(new Read().getUser().getName());
        TextView coins = (TextView) findViewById(R.id.coins);
        coins.setText(String.valueOf(new Read().getUser().getCoins()));

        //CARDS
        cardGeneretor();
        buttonCard1 = (Button) findViewById(R.id.card1);
        buttonCard1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 1 );
                startActivity(myIntent);
            }
        });

        buttonCard2 = (Button) findViewById(R.id.card2);
        buttonCard2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 2 );
                startActivity(myIntent);
            }
        });

        buttonCard3 = (Button) findViewById(R.id.card3);
        buttonCard3.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 3 );
                startActivity(myIntent);
            }
        });

        buttonCard4 = (Button) findViewById(R.id.card4);
        buttonCard4.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 4 );
                startActivity(myIntent);
            }
        });

        buttonCard5 = (Button) findViewById(R.id.card5);
        buttonCard5.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 5 );
                startActivity(myIntent);
            }
        });

        buttonCard6 = (Button) findViewById(R.id.card6);
        buttonCard6.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 6 );
                startActivity(myIntent);
            }
        });

        buttonCard7 = (Button) findViewById(R.id.card7);
        buttonCard7.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 7 );
                startActivity(myIntent);
            }
        });

        buttonCard8 = (Button) findViewById(R.id.card8);
        buttonCard8.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 8 );
                startActivity(myIntent);
            }
        });

        buttonCard9 = (Button) findViewById(R.id.card9);
        buttonCard9.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 9 );
                startActivity(myIntent);
            }
        });

        buttonCard10 = (Button) findViewById(R.id.card10);
        buttonCard10.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, solvecard.class);
                myIntent.putExtra("card", 10 );
                startActivity(myIntent);
            }
        });


        //CONFIG
        buttonConfig = (Button) findViewById(R.id.config);
        buttonConfig.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        PopUpConfig.class);
                startActivity(myIntent);
            }
        });

        buttonVocabulary = (Button) findViewById(R.id.vocabulary);
        //VOCABULÁRIO
        buttonVocabulary.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        vocabulary.class);
                startActivity(myIntent);
            }
        });

        //REVISAO
        buttonReview = (Button) findViewById(R.id.review);
        buttonReview.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        review.class);
                startActivity(myIntent);
            }
        });

        //SHOP
        buttonShop = (Button) findViewById(R.id.shop);
        buttonShop.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        shop.class);
                startActivity(myIntent);
            }
        });
        enableButtons();
    }

    private void enableButtons() {
        int scoreB1 = new Read().viewProgress(Integer.parseInt(buttonCard1.getText().toString()));
        int scoreB2 = new Read().viewProgress(Integer.parseInt(buttonCard2.getText().toString()));
        int scoreB3 = new Read().viewProgress(Integer.parseInt(buttonCard3.getText().toString()));
        int scoreB4 = new Read().viewProgress(Integer.parseInt(buttonCard4.getText().toString()));
        int scoreB5 = new Read().viewProgress(Integer.parseInt(buttonCard5.getText().toString()));
        int scoreB6 = new Read().viewProgress(Integer.parseInt(buttonCard6.getText().toString()));
        int scoreB7 = new Read().viewProgress(Integer.parseInt(buttonCard7.getText().toString()));
        int scoreB8 = new Read().viewProgress(Integer.parseInt(buttonCard8.getText().toString()));
        int scoreB9 = new Read().viewProgress(Integer.parseInt(buttonCard9.getText().toString()));
        int scoreB10 = new Read().viewProgress(Integer.parseInt(buttonCard10.getText().toString()));
        Button review = (Button) findViewById(R.id.review);
        buttonCard1.setEnabled(true);
        buttonCard2.setEnabled(false);
        buttonCard3.setEnabled(false);
        buttonCard4.setEnabled(false);
        buttonCard5.setEnabled(false);
        buttonCard6.setEnabled(false);
        buttonCard7.setEnabled(false);
        buttonCard8.setEnabled(false);
        buttonCard9.setEnabled(false);
        buttonCard10.setEnabled(false);
        review.setEnabled(false);

        if(scoreB1 != 0 ) {
            buttonCard2.setEnabled(true);
            buttonCard3.setEnabled(true);
            review.setEnabled(true);
        }
        if(scoreB2 !=0 && scoreB3 != 0){
            buttonCard4.setEnabled(true);
        }
        if(scoreB4 != 0){
            buttonCard5.setEnabled(true);
            buttonCard6.setEnabled(true);
            buttonCard7.setEnabled(true);
        }
        if(scoreB5 != 0 && scoreB6 != 0 && scoreB7 != 0){
            buttonCard8.setEnabled(true);
            buttonCard9.setEnabled(true);
        }
        if(scoreB8 != 0 && scoreB9 != 0){
            buttonCard10.setEnabled(true);
        }


    }

    private  void  cardGeneretor(){
        int score;
        LinearLayout bar1, bar2, bar3;


        for (x=1;x<11;x++) {
            int idCard = getResources().getIdentifier("card" + x, "id", getPackageName());

            score = new Read().getCardStatus(x).getScore();
            int idBar1 = getResources().getIdentifier("bar1_"+x, "id", getPackageName());
            int idBar2 = getResources().getIdentifier("bar2_"+x, "id", getPackageName());
            int idBar3 = getResources().getIdentifier("bar3_"+x, "id", getPackageName());
            bar1 = (LinearLayout) findViewById(idBar1);
            bar2 = (LinearLayout) findViewById(idBar2);
            bar3 = (LinearLayout) findViewById(idBar3);
            bar1.setBackgroundColor(Color.parseColor("#476268"));
            bar2.setBackgroundColor(Color.parseColor("#476268"));
            bar3.setBackgroundColor(Color.parseColor("#476268"));
            if(score>0){
                switch (score){
                    case 1:
                        bar1.setBackgroundColor(Color.parseColor("#55a44e"));
                        break;
                    case 2:
                        bar1.setBackgroundColor(Color.parseColor("#55a44e"));
                        bar2.setBackgroundColor(Color.parseColor("#55a44e"));
                        break;
                    case 3:
                        bar1.setBackgroundColor(Color.parseColor("#55a44e"));
                        bar2.setBackgroundColor(Color.parseColor("#55a44e"));
                        bar3.setBackgroundColor(Color.parseColor("#55a44e"));
                        break;
                }
            }else{
                int idStarsBar = getResources().getIdentifier("starsBar"+x, "id", getPackageName());
                LinearLayout starsBar = (LinearLayout) findViewById(idStarsBar);
                starsBar.setVisibility(View.INVISIBLE);
            }

        }

    }
}
