package acgkv.english4u;

import android.app.Activity;
import android.graphics.Color;
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
        TextView text3 = (TextView)  findViewById(R.id.answer3);
        Bundle extras = getIntent().getExtras();
        if(extras.getBoolean("answerStatus")){
            text.setText("Resposta Correta");
            text2.setText("Parabéns");
            text3.setText("");
        }else{
            text.setText("Resposta Errada");
            text2.setText("A resposta correta é ");
            text3.setText(extras.getString("correctWord"));
            text3.setTextColor(Color.parseColor("#2eb872"));
        }
    }
}
