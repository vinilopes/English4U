package acgkv.english4u;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import db.MainDB;


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
    }
}
