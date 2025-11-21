package com.example.practica14_juanmanuelvillalobosalvarez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica14_juanmanuelvillalobosalvarez.bd.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnRegistrar;
    private EditText etUsuario, etContraseña;
    private Button btnIniciarSesion;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrar = findViewById(R.id.btn_registrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistro = new Intent(MainActivity.this, Registrar.class);
                MainActivity.this.startActivity(intentRegistro);
            }
        });

        dbHelper = new DatabaseHelper(this);

        etUsuario = findViewById(R.id.et_usuario);
        etContraseña = findViewById(R.id.et_contrasena);
        btnIniciarSesion = findViewById(R.id.btn_iniciar);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String contraseña = etContraseña.getText().toString();

                SQLiteDatabase db = dbHelper.getReadableDatabase();

                String[] projection = {
                        DatabaseHelper.COLUMN_ID,
                        DatabaseHelper.COLUMN_USERNAME,
                        DatabaseHelper.COLUMN_PASSWORD
                };

                String selection = DatabaseHelper.COLUMN_USERNAME + " = ?" + " AND " + DatabaseHelper.COLUMN_PASSWORD + " = ?";
                String[] selectionArgs = {usuario, contraseña};


                Cursor cursor = db.query(
                        DatabaseHelper.TABLE_USERS,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null
                );

                if (cursor != null && cursor.getCount() > 0) {
                    // Si el cursor tiene resultados, el usuario y la contraseña coinciden
                    // Navega a la actividad de reserva enviando el nombre de usuario
                    cursor.moveToFirst();

                    String nombreUsuario = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_USERNAME));
                    cursor.close();
                    db.close();

                    Intent intent = new Intent(MainActivity.this, Reserva.class);
                    intent.putExtra("nombre_usuario", nombreUsuario);
                    startActivity(intent);

                } else {
                    // Si el cursor está vacío, las credenciales no coinciden
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}