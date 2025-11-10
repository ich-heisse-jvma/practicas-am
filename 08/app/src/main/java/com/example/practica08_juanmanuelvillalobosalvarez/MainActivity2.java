package com.example.practica08_juanmanuelvillalobosalvarez;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = (TextView)findViewById(R.id.textView);

        String dato = getIntent().getStringExtra( "dato");
        tv1.setText("Hola " + dato);
    }

    //Método para el botón Regresar
    public void Regresar(View view){
        Intent i = new Intent( this, MainActivity.class);
        startActivity(i);
    }
}