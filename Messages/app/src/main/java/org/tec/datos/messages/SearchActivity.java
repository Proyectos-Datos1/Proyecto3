package org.tec.datos.messages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText txtField;
    private Spinner searchSpinner;
    ArrayAdapter<String> arrayAdapterContact;
    String[] optionList= new String[]{"Attribute","Name Attached","Type Attached"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchSpinner= findViewById(R.id.optionSpinner);
        txtField = findViewById(R.id.txtField);
        searchSpinner.setOnItemSelectedListener(this);
        arrayAdapterContact=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,optionList);
        searchSpinner.setAdapter(arrayAdapterContact);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {

            case R.id.action_settings:

                return true;


            case R.id.action_newMsg:
                intent = new Intent(SearchActivity.this, WriteActivity.class);
                Toast.makeText(SearchActivity.this,"Go to Search", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            case R.id.action_account:
                intent = new Intent(SearchActivity.this, SearchActivity.class);
                Toast.makeText(SearchActivity.this,"Go to Search", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
