package com.example.practica12_juanmanuelvillalobosalvarez;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1){
            Toast.makeText( this,  "Opción 1", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item2){
            Toast.makeText( this,  "Opción 2", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item3){
            Toast.makeText( this,  "Opción 3", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.compartir) {
            Toast.makeText(this, "Compartir", Toast.LENGTH_SHORT).show();
            return  true;
        }
        if (id == R.id.buscar) {
            Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();
            return  true;
        } return super.onOptionsItemSelected(item);
    }
}