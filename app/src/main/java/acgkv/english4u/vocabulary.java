package acgkv.english4u;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import db.Read;
import db.WordEN;

public class vocabulary extends AppCompatActivity {
    ArrayList<WordEN> mWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        ListView listView = (ListView) findViewById(R.id.listview);
         mWords = new Read().getWordsENLearned();

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mWords.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            convertView = getLayoutInflater().inflate(R.layout.list, null);

            TextView text = convertView.findViewById(R.id.wordlearned);
            LinearLayout b1 =  convertView.findViewById(R.id.b1);
            LinearLayout b2 =  convertView.findViewById(R.id.b2);
            LinearLayout b3 =  convertView.findViewById(R.id.b3);
            WordEN wordsEN = mWords.get(position);
            text.setText(wordsEN.getNome());
            if(wordsEN.getNumErros() == 0){
                b1.setBackgroundColor(Color.parseColor("#55a44e"));
                b2.setBackgroundColor(Color.parseColor("#55a44e"));
                b3.setBackgroundColor(Color.parseColor("#55a44e"));
            }
            if(wordsEN.getNumErros() == 1){
                b1.setBackgroundColor(Color.parseColor("#ffcd00"));
                b2.setBackgroundColor(Color.parseColor("#ffcd00"));
                b3.setBackgroundColor(Color.parseColor("#476268"));
            }
            if(wordsEN.getNumErros() > 1){
                b1.setBackgroundColor(Color.parseColor("#ee2b47"));
                b2.setBackgroundColor(Color.parseColor("#476268"));
                b3.setBackgroundColor(Color.parseColor("#476268"));
            }

            return convertView;
        }
    }
}
