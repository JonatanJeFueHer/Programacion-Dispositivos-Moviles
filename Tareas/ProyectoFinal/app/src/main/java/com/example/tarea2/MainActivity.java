package com.example.tarea2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et_Nombre, et_Edad, et_Tel, et_Mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_Nombre = (EditText) findViewById(R.id.txt_Nombre);
        et_Edad = (EditText) findViewById(R.id.txt_Edad);
        et_Tel = (EditText) findViewById(R.id.txt_Tel);
        et_Mail = (EditText) findViewById(R.id.txt_Mail);
    }

    //Método del boton registrar.
    public void registrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String Nombre = et_Nombre.getText().toString();
        String Edad = et_Edad.getText().toString();
        String Tel = et_Tel.getText().toString();
        String Mail = et_Mail.getText().toString();

        if (!Nombre.isEmpty() && !Edad.isEmpty() && !Tel.isEmpty() && !Mail.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("nombre", Nombre);
            registro.put("edad", Edad);
            registro.put("telefono", Tel);
            registro.put("email", Mail);
            BaseDeDatos.insert("personal", null, registro);
            BaseDeDatos.close();
            et_Nombre.setText("");
            et_Edad.setText("");
            et_Tel.setText("");
            et_Mail.setText("");
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Se deben llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
            }

    //Método para consultar al personal.
    public void Buscar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombre = et_Nombre.getText().toString();

        if(!nombre.isEmpty()) {
            Cursor fila = BaseDeDatos.rawQuery("select edad, telefono, mail from personal where nombre =" + nombre, null);
            if(fila.moveToFirst()) {
                et_Edad.setText(fila.getString(0));
                et_Tel.setText(fila.getString(1));
                et_Mail.setText(fila.getString(2));
                BaseDeDatos.close();

            } else {
                Toast.makeText(this, "No existe el empleado.", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        } else {
            Toast.makeText(this, "Debes escribir un nombre", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para eliminar un empleado.
    public void Eliminar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombre = et_Nombre.getText().toString();
        if(!nombre.isEmpty()){
            int cantidad = BaseDeDatos.delete("personal", "nombre=" + nombre, null);
            BaseDeDatos.close();
            et_Nombre.setText("");
            et_Edad.setText("");
            et_Tel.setText("");
            et_Mail.setText("");
            if(cantidad == 1){
                Toast.makeText(this, "Registro eliminado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Registro no existente", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Debes escribir un nombre", Toast.LENGTH_SHORT).show();
        }
    }
}
