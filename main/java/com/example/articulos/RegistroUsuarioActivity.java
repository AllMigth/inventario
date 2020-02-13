package com.example.articulos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.articulos.utilidades.utilidades;

import java.sql.SQLData;

public class RegistroUsuarioActivity extends AppCompatActivity {
    EditText campoId,campoNombre,campoTelefono;

    @Override
    protected void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoId = (EditText) findViewById(R.id.campoId);
        campoNombre = (EditText) findViewById(R.id.campoNombre);
        campoTelefono = (EditText) findViewById(R.id.campoTelefono);
    }
    public void onClick(View view){
        registrarUsuarios();
    }

    private void registrarUsuarios() {
        //abriendo la conexion
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"db_usuarios",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(utilidades.CAMPO_ID, campoId.getText().toString());
        values.put(utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(utilidades.CAMPO_TELEFONO, campoTelefono.getText().toString());

        //insertando los datos a la base

        Long idResultante = db.insert(utilidades.TABLA_USUARIO,utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_LONG);
    }
}
