package com.example.david.contactos;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int CREAR = 100;
    public static final int BORRAR = 200;
    public static final int TODOS = 300;

    private ArrayList<Contacto> listaContactos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCrear = (Button) findViewById(R.id.buttonCrear);
        btnCrear.setOnClickListener(this);
        Button btnBorrar = (Button) findViewById(R.id.buttonBorrar);
        btnBorrar.setOnClickListener(this);
        Button btnTodos = (Button) findViewById(R.id.buttonTodos);
        btnTodos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        int codigo = 0;
        switch (v.getId()) {
            case R.id.buttonCrear:
                intent = new Intent(this, CrearActivity.class);
                codigo = CREAR;
                break;
            case R.id.buttonBorrar:
                intent = new Intent(this, BorrarActivity.class);
                codigo = BORRAR;
                break;
            case R.id.buttonTodos:
                intent = new Intent(this, ListviewActivity.class);
                intent.putParcelableArrayListExtra("listaContactos", (ArrayList)listaContactos);
                codigo = TODOS;
                break;


        }
        startActivityForResult(intent, codigo);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CREAR:
                if (resultCode == Activity.RESULT_OK) {
                    if (data.hasExtra("contacto")) {
                        Contacto c = (Contacto) data.getParcelableExtra("contacto");
                        listaContactos.add(c);
                        Toast.makeText(this, c.getNombre() + "Contacto Guardado", Toast.LENGTH_LONG).show();
                        
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Toast.makeText(this, "No se ha guardado el contacto", Toast.LENGTH_LONG).show();


                    }

                }
                break;
            case BORRAR:
                if (BORRAR == requestCode) {
                    if (resultCode == Activity.RESULT_OK) {
                        if (data.hasExtra("contacto")) {
                            Contacto c = (Contacto) data.getParcelableExtra("contacto");
                        listaContactos.remove(c);
                            Toast.makeText(this, c.getNombre() + "Contacto Borrado", Toast.LENGTH_LONG).show();

                    }

                    else if (resultCode == Activity.RESULT_CANCELED) {
                            Toast.makeText(this, "No se ha borrado el contacto", Toast.LENGTH_LONG).show();
                        }



                }
                break;



    }


}}}








