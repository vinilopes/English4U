package acgkv.english4u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class solvecard extends AppCompatActivity {

    Button ok;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solvecard);


        //CARTÃO2
        ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

             bar = (ProgressBar)   findViewById(R.id.progress);
                bar.setProgress(bar.getProgress() + 10);
            }
        });
    }
}
