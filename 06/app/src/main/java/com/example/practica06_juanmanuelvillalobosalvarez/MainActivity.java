package com.example.practica06_juanmanuelvillalobosalvarez;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private String nombres [] = {"Jorge", "Juan", "Ruben", "Adrian", "Maritza", "Samuel", "Maria", "Jair", "Elton", "David"};
    private String edades [] = {"18", "20", "21", "19", "24", "18", "18", "20", "22", "23"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);
        lv1 = (ListView)findViewById(R.id.lv1);

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, R.layout.list_items_david, nombres);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // 'i' es el índice de la fila clickeada. Se usa para acceder a la edad correspondiente.
                tv1.setText("La edad de " + lv1.getItemAtPosition(i) + " es " + edades[i] + " años");
            }
        });

    }
}