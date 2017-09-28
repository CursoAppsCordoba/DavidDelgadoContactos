package com.example.david.contactos;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {
    private static AlertDialog ventana;
    private ListView listView;
    private List<Contacto> listac = new ArrayList<>();
    private List<String> lista = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = (ListView) findViewById(R.id.lista);
        lista = new ArrayList<String>();
        Intent intent = getIntent();
        listac = (ArrayList) intent.getParcelableArrayListExtra("listaContactos");
        for (Contacto c : listac) {
            lista.add(c.getNombre() + " " + c.getEmail() + " " + c.getEdad());
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              if(ventana == null) {
                  ventana = CreateDialog();

              }
              ventana.show();
            }
        });
    }


    public AlertDialog CreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("No hago el editar por que no se ");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                Intent intent1 = new Intent(ListviewActivity.this,EditarActivity.class);
                startActivityForResult (intent1 ,Activity.RESULT_CANCELED );

            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        return builder.create();
    }


}