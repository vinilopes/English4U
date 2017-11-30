package acgkv.english4u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameFrame extends AppCompatActivity {

    Button saveName;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_frame);

        saveName = (Button) findViewById(R.id.saveName);
        saveName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                name = (EditText) findViewById(R.id.editTextNome) ;
                // Start NewActivity.class
                Intent myIntent = new Intent(NameFrame.this, MainActivity.class);
                myIntent.putExtra("username", name.getText().toString());
                myIntent.putExtra("running", 1);
                startActivity(myIntent);
            }
        });
    }




}
