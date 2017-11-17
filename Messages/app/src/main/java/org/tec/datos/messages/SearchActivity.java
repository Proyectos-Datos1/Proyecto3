package org.tec.datos.messages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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
}
