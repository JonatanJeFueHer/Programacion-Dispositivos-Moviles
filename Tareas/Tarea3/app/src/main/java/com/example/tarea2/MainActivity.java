package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método para mostrar y ocultar el menu.
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuacciones, menu);
        return true;
    }
    //Método que asigna las funciones correspondientes a los items del menu acciones.
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.item1) {
            Toast.makeText(this, "Buscando Usuario", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.item2){
            Toast.makeText(this, "Eliminando Usuario", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.item3){
            Toast.makeText(this, "Numerando a los usuarios del sistema", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.ajustes) {
            Toast.makeText(this, "Abrir ajustes", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.compartir) {
            Toast.makeText(this, "Compartiendo", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Método del boton registrar.
    public void registrar (View view){
        Intent registrar = new Intent(this, MainActivity2.class);
        startActivity(registrar);
    }
}