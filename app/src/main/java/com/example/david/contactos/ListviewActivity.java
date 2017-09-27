package com.example.david.contactos;

import android.content.Intent;
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
            lista.add(c.getNombre()+" "+c.getEmail()+" "+c.getEdad());
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListviewActivity.this, lista.get(i), Toast.LENGTH_LONG).show();
            }
        });

    }


}