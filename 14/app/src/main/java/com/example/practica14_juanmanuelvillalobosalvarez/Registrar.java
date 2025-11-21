package com.example.practica14_juanmanuelvillalobosalvarez;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practica14_juanmanuelvillalobosalvarez.bd.DatabaseHelper;

public class Registrar extends AppCompatActivity {

    private EditText etUsuario, etContraseña, etRepetirContraseña;
    private Button btnRegistrar;
    private Button btnRegresar;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        dbHelper = new DatabaseHelper(this);

        etUsuario = findViewById(R.id.EditT_usuario);
        etContraseña = findViewById(R.id.EditT_password);
        etRepetirContraseña = findViewById(R.id.EditT_repetir_password);
        btnRegistrar = findViewById(R.id.btn_registrar);
        btnRegresar = findViewById(R.id.btn_regresar);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                // Cierra la actividad actual y regresa a la actividad anterior
            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String contraseña = etContraseña.getText().toString();
                String repetirContraseña = etRepetirContraseña.getText().toString();
                // Validar si el usuario o la contraseña están vacíos
                if (usuario.isEmpty() || contraseña.isEmpty()) {
                    Toast.makeText(Registrar.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!contraseña.equals(repetirContraseña)) {
                    Toast.makeText(Registrar.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.COLUMN_USERNAME, usuario);
                values.put(DatabaseHelper.COLUMN_PASSWORD, contraseña);

                // Inserta los nuevos datos de usuario
                long result = db.insert(DatabaseHelper.TABLE_USERS, null, values);

                if (result != -1) {
                    Toast.makeText(Registrar.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Registrar.this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}