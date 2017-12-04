package acgkv.english4u;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import db.MainDB;
import db.Read;
import db.Update;


public class PopUpConfig extends Activity{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getActionBar().hide();
        setContentView(R.layout.popupconfig);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.6), (int)(height*.3));

       Button buttonReset = (Button) findViewById(R.id.reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
                db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_USER);
                db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_CARD);
                db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_ENWORDS);
                db.execSQL("DROP TABLE IF EXISTS " + MainDB.TB_PTWORDS);
                // Start NewActivity.class
                Intent myIntent = new Intent(PopUpConfig.this, NameFrame.class);
                startActivity(myIntent);
            }
        });

        Switch buttonAudio = (Switch) findViewById(R.id.switchaudio);
        final int en = new Read().audioEnable();
        if( en == 1 ){
            buttonAudio.setChecked(true);
        }else{
            buttonAudio.setChecked(false);
        }
        buttonAudio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(en == 1){
                    new Update().Audio(0);
                }else {
                    new Update().Audio(1);
                }

            }
        });
    }
}
