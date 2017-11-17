package org.tec.datos.messages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.tec.datos.datastructures.Tree.Splay.SplayBST;
import org.tec.datos.objects.Message;
import org.tec.datos.objects.User;

public class WriteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText messageField;
    private ImageButton sendButton;
    private Message message;
    private Spinner contactSpinner;
    ArrayAdapter<String> arrayAdapterContact;
    String[] contactList= new String[]{"Juan","Fiorella","Monica","Mario"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        contactSpinner= findViewById(R.id.contactSpinner);
        messageField = findViewById(R.id.messageField);
        sendButton= findViewById(R.id.sendButton);
        contactSpinner.setOnItemSelectedListener(this);
        arrayAdapterContact=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,contactList);
        contactSpinner.setAdapter(arrayAdapterContact);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = messageField.getText().toString();
                message = new Message(messageField.getText().toString());
                //message.setReceiver(new User(contactSpinner.get));
                if (text != null && !text.isEmpty()) {
                    Intent intent = new Intent(WriteActivity.this, ListActivity.class);
                    intent.putExtra("message", message);
                    Toast.makeText(WriteActivity.this,message.getText(), Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }else{
                    Toast.makeText(WriteActivity.this, "You must be write something", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
