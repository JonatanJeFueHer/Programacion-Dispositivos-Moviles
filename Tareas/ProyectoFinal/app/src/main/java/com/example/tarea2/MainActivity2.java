package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView ListViewPersonal;
    ArrayList<String> listaInformacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    //Método para boton regresa y registrar nuevo.
    public void regresarYRegistrar (View view){
        Intent regresarYRegistrar = new Intent(this, MainActivity.class);
        startActivity(regresarYRegistrar);
    }
}