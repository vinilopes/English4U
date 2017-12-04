package acgkv.english4u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Button buttonBuyFut = (Button) findViewById(R.id.buy);
        buttonBuyFut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(shop.this, PopUpBuy.class);
                myIntent.putExtra("valor", 60);
                myIntent.putExtra("cod", 11);
                startActivity(myIntent);
            }
        });
    }
}
