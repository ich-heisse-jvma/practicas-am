package com.example.practica02_juanmanuelvillalobosalvarez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView IdTxtv_1, IdTxtv_2;
    Button IdBtn_1, IdBtn_2, IdBtn_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IdTxtv_1 = (TextView) findViewById(R.id.IdTxtv_1);
        IdTxtv_2 = (TextView) findViewById(R.id.IdTxtv_2);

        IdBtn_1 = (Button) findViewById(R.id.IdBtn_1);
        IdBtn_2 = (Button) findViewById(R.id.IdBtn_2);
        IdBtn_3 = (Button) findViewById(R.id.IdBtn_3);

        IdBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdTxtv_1.setText("APLICACIONES ");
            }
        });

        IdBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdTxtv_2.setText("MOVILES");
            }
        });

        IdBtn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StrTexto_1 = IdTxtv_1.getText().toString();
                String StrTexto_2 = IdTxtv_2.getText().toString();

                Toast.makeText(getBaseContext(), "Texto: " + StrTexto_1 + " @ " + StrTexto_2, Toast.LENGTH_SHORT).show();
                IdTxtv_1.setText(" ");
                IdTxtv_2.setText(" ");
            }
        });
    }
};