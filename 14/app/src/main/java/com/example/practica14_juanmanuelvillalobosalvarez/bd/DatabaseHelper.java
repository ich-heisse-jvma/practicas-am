package com.example.practica14_juanmanuelvillalobosalvarez.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "atma_hostel";
    private static final int DATABASE_VERSION = 3;

    public static final String TABLE_USERS = "usuarios";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "usuario";
    public static final String COLUMN_PASSWORD = "contrasena";

    public static final String TABLE_RESERVAS = "reservas";
    public static final String COLUMN_RESERVA_ID = "_id";
    public static final String COLUMN_NOMBRE_HUESPED = "nombre_huesped";
    public static final String COLUMN_FECHA_ENTRADA = "fecha_entrada";
    public static final String COLUMN_FECHA_SALIDA = "fecha_salida";
    public static final String COLUMN_TIPO_HABITACION = "tipo_habitacion";
    public static final String COLUMN_TIPO_PAGO = "tipo_pago";
    public static final String COLUMN_MONTO = "monto";

    private static final String DATABASE_CREATE_USERS = "create table "
            + TABLE_USERS + "(" + COLUMN_ID
            + " integer primary key autoincrement," + COLUMN_USERNAME
            + " text not null," + COLUMN_PASSWORD
            + " text not null);";

    private static final String DATABASE_CREATE_RESERVAS = "create table "
            + TABLE_RESERVAS + "(" + COLUMN_RESERVA_ID
            + " integer primary key autoincrement," + COLUMN_NOMBRE_HUESPED
            + " text not null," + COLUMN_FECHA_ENTRADA
            + " text not null," + COLUMN_FECHA_SALIDA
            + " text not null," + COLUMN_TIPO_HABITACION
            + " text not null," + COLUMN_TIPO_PAGO
            + " text not null," + COLUMN_MONTO
            + " text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_USERS);
        database.execSQL(DATABASE_CREATE_RESERVAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESERVAS);
        onCreate(db);
    }

    public long agregarReserva(String nombreHuesped, String fechaEntrada, String fechaSalida,
                               String tipoHabitacion, String tipoPago, String monto) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NOMBRE_HUESPED, nombreHuesped);
        values.put(COLUMN_FECHA_ENTRADA, fechaEntrada);
        values.put(COLUMN_FECHA_SALIDA, fechaSalida);
        values.put(COLUMN_TIPO_HABITACION, tipoHabitacion);
        values.put(COLUMN_TIPO_PAGO, tipoPago);
        values.put(COLUMN_MONTO, monto);

        long id = db.insert(TABLE_RESERVAS, null, values);
        db.close();
        return id;
    }
}