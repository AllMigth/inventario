package com.example.articulos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"db_usuarios",null,1);
    }


    public void onClick(View view) {
        Intent miIntent = new Intent(MainActivity.this, RegistroUsuarioActivity.class);
        startActivity(miIntent);
        /*switch (view.getId()){
            case R.id.btnOpcionRegistro:
                miIntent = new Intent(MainActivity.this, RegistroUsuarioActivity.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }*/
    }
}
