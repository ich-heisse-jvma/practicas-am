package com.example.practica07_juanmanuelvillalobosalvarez;

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
    public void MensajeIESTP(View view) {
        Toast.makeText( this,  "IESTP TRUJILLO", Toast.LENGTH_SHORT).show();
    }
    public void MensajeDPW(View view) {
        Toast.makeText( this,  "DISEÑO Y PROGRAMACIÓN WEB", Toast.LENGTH_SHORT).show();
    }
    public void MensajeAM(View view) {
        Toast.makeText( this,  "APLICACIONES MOVILES", Toast.LENGTH_SHORT).show();
    }
    public void MensajeDOC(View view) {
        Toast.makeText( this,  "Ing Néstor David Hilario Castro", Toast.LENGTH_SHORT).show();
    }
}