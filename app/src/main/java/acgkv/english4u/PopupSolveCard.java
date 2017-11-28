package acgkv.english4u;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;


public class PopupSolveCard extends Activity{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getActionBar().hide();
        setContentView(R.layout.activity_popupsolvecard);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9), (int)(height*.15));

        TextView text = (TextView)  findViewById(R.id.answer);
        TextView text2 = (TextView)  findViewById(R.id.answer2);
        Bundle extras = getIntent().getExtras();
        if(extras.getBoolean("answerStatus")){
            text.setText("Resposta Correta");
            text2.setText("Parabéns");
        }else{
            text.setText("Resposta Errada");
            text2.setText("A resposta correta é "+extras.getString("correctWord"));
        }
    }
}
