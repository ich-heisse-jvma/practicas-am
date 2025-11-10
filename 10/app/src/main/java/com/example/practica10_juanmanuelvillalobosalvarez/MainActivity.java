package com.example.practica10_juanmanuelvillalobosalvarez;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Seleccion(View view){
        String cadena = getResources().getResourceEntryName(view.getId());
        Toast.makeText(this, "Esta fruta es: "+cadena, Toast.LENGTH_SHORT).show();
    }
}


