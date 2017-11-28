package acgkv.english4u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button buttonContinue = (Button) findViewById(R.id.config);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Score.this,
                        MainActivity.class);
                myIntent.putExtra("points", points);
                myIntent.putExtra("score", score);
                startActivity(myIntent);
            }
        });
    }
}
