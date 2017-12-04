package acgkv.english4u;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import db.MainDB;
import db.Update;
import db.User;
import db.Read;

public class PopUpBuy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_buy);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.6), (int)(height*.3));

        Bundle extras = getIntent().getExtras();
        final int valor = extras.getInt("valor");
        final int cod = extras.getInt("cod");

        Button buttonCancel = (Button) findViewById(R.id.cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(PopUpBuy.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

        Button buttonBuy = (Button) findViewById(R.id.buycard);
        final User coinsUser = new Read().getUser();
        if(coinsUser.getCoins() >= valor && (new Read().getCardStatus(11).getBuy() == 0)){
            buttonBuy.setEnabled(true);
        }else{
            buttonBuy.setEnabled(false);
        }
        buttonBuy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                coinsUser.setCoins((coinsUser.getCoins() - valor));
                new Update().updateUser2(coinsUser);
                new Update().CardShop(cod);
                // Start NewActivity.class
                Intent myIntent = new Intent(PopUpBuy.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}

