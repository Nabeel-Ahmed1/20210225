package com.example.learning_alphabets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] alphabets={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",};
    int[] alphabetImage={R.drawable.aa,R.drawable.ab,R.drawable.ac,R.drawable.ad,R.drawable.ae,R.drawable.af,R.drawable.ag,R.drawable.ah,R.drawable.ai,R.drawable.aj,R.drawable.ak,R.drawable.al,R.drawable.am,R.drawable.an,R.drawable.ao,R.drawable.ap,R.drawable.aq,R.drawable.ar,R.drawable.as,R.drawable.at,R.drawable.au,R.drawable.av,R.drawable.aw,R.drawable.ax,R.drawable.ay,R.drawable.az};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.grid_view);
        MainAdapter adapter=new MainAdapter(MainActivity.this,alphabets,alphabetImage);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),"You Clicked "+alphabets[+ position],Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),alphabetActivity.class);
                intent.putExtra("name",alphabets[position]);
                startActivity(intent);
            }
        });
    }
}