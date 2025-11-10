package com.example.practica08_juanmanuelvillalobosalvarez;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.editTextTextPersonName);
    }

    public void Enviar(View view) {
        Intent i = new Intent( this, MainActivity2 .class);
        i.putExtra("dato", et1.getText().toString());
        startActivity(i);
    }
}