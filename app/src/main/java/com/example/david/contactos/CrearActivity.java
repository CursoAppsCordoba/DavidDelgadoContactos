package com.example.david.contactos;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CrearActivity extends AppCompatActivity implements View.OnClickListener {


    private AlertDialog ventana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        Button btnCancelar1 = (Button) findViewById(R.id.buttonCancelar1);
        btnCancelar1.setOnClickListener(this);
        Button btnAceptar1 = (Button) findViewById(R.id.buttonAceptar1);
        btnAceptar1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonAceptar1:
                EditText nombre = (EditText) findViewById(R.id.editTextNombre);
                EditText email = (EditText) findViewById(R.id.editTextEmail);
                EditText edad = (EditText) findViewById(R.id.editTextEdad);

                Contacto contacto = new Contacto(nombre.getText().toString(), email.getText().toString(), Integer.parseInt(edad.getText().toString()));

                Intent intent = new Intent();
                intent.putExtra("contacto", contacto);
                setResult(Activity.RESULT_OK, intent);
                finish();
                break;
            case R.id.buttonCancelar1:
                if (ventana == null) {
                ventana = CreateDialog();
        }
       ventana.show();
                break;
        }
    }
    public AlertDialog CreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                Intent intent1 = new Intent();
                setResult(Activity.RESULT_CANCELED, intent1);
                CrearActivity.this.finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        return builder.create();

    }
}
