package acgkv.english4u;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;



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
    }
}
