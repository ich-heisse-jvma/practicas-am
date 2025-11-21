package com.example.practica14_juanmanuelvillalobosalvarez;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaCarga extends AppCompatActivity {

    private static final int TIEMPO_CARGA = 10000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        // carga antes de pasar a la siguiente actividad.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( PantallaCarga.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, TIEMPO_CARGA);
    }
}