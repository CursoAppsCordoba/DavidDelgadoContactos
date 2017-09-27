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

public class BorrarActivity extends AppCompatActivity implements View.OnClickListener {

    private AlertDialog ventana1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
        Button btnCancelar1 = (Button) findViewById(R.id.buttonCancelar1);
        btnCancelar1.setOnClickListener(this);
        Button btnBorrarContacto = (Button) findViewById(R.id.buttonBorrarContacto);
        btnBorrarContacto.setOnClickListener(this);
    }
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonBorrarContacto:
                EditText nombreB = (EditText) findViewById(R.id.editTextNombreB);
                EditText emailB = (EditText) findViewById(R.id.editTextEmailB);
                EditText edadB = (EditText) findViewById(R.id.editTextEdadB);

                Contacto contacto = new Contacto(nombreB.getText().toString(), emailB.getText().toString(), Integer.parseInt(edadB.getText().toString()));

                Intent intent = new Intent();
                intent.putExtra("contacto", contacto);
                setResult(Activity.RESULT_OK, intent);
                finish();
                break;
            case R.id.buttonCancelar1:
                if (ventana1 == null) {
                    ventana1 = CreateDialog();
                }
                ventana1.show();
                break;
        }
    }
    public AlertDialog CreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                Intent intent1 = new Intent();
                setResult(Activity.RESULT_CANCELED, intent1);
                BorrarActivity.this.finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        return builder.create();

    }
}


