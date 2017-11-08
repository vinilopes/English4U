package acgkv.english4u;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {
    Button buttonVocabulary;
    Button buttonReview;
    Button buttonCard;
    Button buttonShop;
    Button buttonConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //CARTÃO
        buttonCard = (Button) findViewById(R.id.card);
        buttonCard.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        solvecard.class);
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
    }
}
