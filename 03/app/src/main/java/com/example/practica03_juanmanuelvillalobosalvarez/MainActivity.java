package com.example.practica03_juanmanuelvillalobosalvarez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_valor1, et_valor2;
    private RadioButton rb_su, rb_res, rb_pro, rb_div;
    private TextView tv_resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valor1 = (EditText) findViewById(R.id.txt_Valor1);
        et_valor2 = (EditText) findViewById(R.id.txt_Valor2);
        rb_su = (RadioButton) findViewById(R.id.rb_suma);
        rb_res = (RadioButton) findViewById(R.id.rb_resta);
        rb_pro = (RadioButton) findViewById(R.id.rb_producto);
        rb_div = (RadioButton) findViewById(R.id.rb_division);
        tv_resul = (TextView) findViewById(R.id.tv_resultado);
    }

    //metodo para el boton
    public void Calcular(View view) {
        String valor1_String = et_valor1.getText().toString();
        String valor2_String = et_valor2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        if (rb_su.isChecked() == true) {
            int suma = valor1_int + valor2_int;
            String Resultado = String.valueOf(suma);
            tv_resul.setText(Resultado);
        } else if (rb_res.isChecked() == true) {
            int resta = valor1_int - valor2_int;
            String Resultado = String.valueOf(resta);
            tv_resul.setText(Resultado);
        } else if (rb_pro.isChecked() == true) {
            int multiplicacion = valor1_int * valor2_int;
            String Resultado = String.valueOf(multiplicacion);
            tv_resul.setText(Resultado);
        } else if (rb_div.isChecked() == true) {
            if (valor2_int != 0) {
                int division = valor1_int / valor2_int;
                String Resultado = String.valueOf(division);
                tv_resul.setText(Resultado);
            } else {
                Toast.makeText(this, "El segundo valor debe ser diferente de cero", Toast.LENGTH_LONG).show();
            }
        }
    }
}