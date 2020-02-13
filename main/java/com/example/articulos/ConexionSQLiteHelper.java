package com.example.articulos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.articulos.utilidades.utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    //al llamar a ese constructor creamos la base de datos
    //SE LLAMA AL METODO ONCREATE
    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //context = contexto de la app
        // name = nombre de la base de datos
        // version = version de la base de datos
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SE ENCARGA DE GENERAR LAS TABLAS Y SCRIPTS CORRESPONDIENTES DE NUESTRA ENTIDAD
        db.execSQL(utilidades.CREAR_TABLA_USUARIO);//EJECUTANDO LA SENTENCIA SQL PARA CREAR LA TABLA
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
    //VERIFICA SI EXISTE UNA VERSION ANTIGUA DE LA BASE DE DATOS
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
