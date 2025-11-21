package com.example.practica14_juanmanuelvillalobosalvarez;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.practica14_juanmanuelvillalobosalvarez.bd.DatabaseHelper;
import java.util.Calendar;

public class Reserva extends AppCompatActivity {

    private TextView tvNombreH, tvFechaS, tvFechaE, montoTextView;
    private Spinner tipoHabitacionSpinner, tipoPagoSpinner;
    private Button btnReservar;

    private String[] tiposHabitacion = {"Dormitorio individual", "Dormitorio matrimonial (2 Pers.)", "Dormitorio compartido (4 Pers.)", "Dormitorio compartido (6 Pers.)"};
    private String[] montosTarjeta = {"50", "100", "45", "38"};
    private String[] montosEfectivo = {"60", "110", "40", "40"};
    private String[] tiposPago = {"Tarjeta", "Efectivo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        tvNombreH = findViewById(R.id.tv_NombreH);
        tvFechaE = findViewById(R.id.tv_FechaE);
        tvFechaS = findViewById(R.id.tv_FechaS);
        tipoHabitacionSpinner = findViewById(R.id.s_TipoHab);
        tipoPagoSpinner = findViewById(R.id.spinnerTipoPago);
        montoTextView = findViewById(R.id.tv_monto);
        btnReservar = findViewById(R.id.btn_reservar);

        String nombreUsuario = getIntent().getStringExtra("nombre_usuario");
        if (nombreUsuario != null) {
            tvNombreH.setText(nombreUsuario);
        } else {
            tvNombreH.setText("Usuario no identificado");
        }

        ArrayAdapter<String> habitacionAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                tiposHabitacion
        );

        habitacionAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        tipoHabitacionSpinner.setAdapter(habitacionAdapter);

        tipoHabitacionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                actualizarMonto();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        ArrayAdapter<String> pagoAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                tiposPago
        );

        pagoAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        tipoPagoSpinner.setAdapter(pagoAdapter);

        tipoPagoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                actualizarMonto();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        tvFechaE.setOnClickListener(view -> showDatePickerDialog(tvFechaE));
        tvFechaS.setOnClickListener(view -> showDatePickerDialog(tvFechaS));

        btnReservar.setOnClickListener(view -> {
            String nombreHuesped = tvNombreH.getText().toString();
            String fechaEntrada = tvFechaE.getText().toString();
            String fechaSalida = tvFechaS.getText().toString();
            String tipoHabitacion = tipoHabitacionSpinner.getSelectedItem().toString();
            String tipoPago = tipoPagoSpinner.getSelectedItem().toString();
            String monto = montoTextView.getText().toString();

            if (!nombreHuesped.isEmpty() && !fechaEntrada.isEmpty() && !fechaSalida.isEmpty()) {

                DatabaseHelper databaseHelper = new DatabaseHelper(Reserva.this);
                long id = databaseHelper.agregarReserva(nombreHuesped, fechaEntrada, fechaSalida, tipoHabitacion, tipoPago, monto);

                if (id != -1) {
                    mostrarToast("Reserva Exitosa");
                } else {
                    mostrarToast("Hubo un error al guardar la reserva");
                }

            } else {
                mostrarToast("Por favor, complete todos los datos");
            }
        });
    }

    private void showDatePickerDialog(final TextView textView) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    String fecha = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1;
                    textView.setText(fecha);
                },
                year, month, day);

        datePickerDialog.show();
    }

    private void actualizarMonto() {
        int posicionHabitacion = tipoHabitacionSpinner.getSelectedItemPosition();
        int posicionTipoPago = tipoPagoSpinner.getSelectedItemPosition();

        String monto;

        if (tiposPago[posicionTipoPago].equals("Tarjeta")) {
            monto = montosTarjeta[posicionHabitacion];
        } else {
            monto = montosEfectivo[posicionHabitacion];
        }

        montoTextView.setText("PEN " + monto);
    }

    private void mostrarToast(String mensaje) {
        Toast.makeText(Reserva.this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
