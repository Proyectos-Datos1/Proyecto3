package org.tec.datos.messages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.tec.datos.datastructures.LinkedList.SimpleList.SimpleList;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleList<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView =  findViewById(R.id.listView);

        users = new SimpleList<>();
        users.addLast("Juan");
        users.addLast("Fiorella");
        users.addLast("Mario");
        users.addLast("Carlos");
        users.addLast("Fernanda");
        users.addLast("Ricardo");
        users.addLast("Joseph");
        users.addLast("Juan");
        users.addLast("Fiorella");
        users.addLast("Mario");
        users.addLast("Carlos");
        users.addLast("Fernanda");
        users.addLast("Ricardo");
        users.addLast("Joseph");





        // Adaptador, la forma visual en que mostraremos nuestros datos
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        // Enlazamos el adaptador con nuestro List View
        // listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Clicked: "+users.findItem(position), Toast.LENGTH_LONG).show();
            }
        });

        // Enlazamos con nuestro adaptador personalizado
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, users);
        listView.setAdapter(myAdapter);
    }

}
