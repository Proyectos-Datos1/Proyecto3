package org.tec.datos.messages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.tec.datos.datastructures.LinkedList.SimpleList.SimpleList;
import org.tec.datos.datastructures.Tree.Splay.SplayBST;
import org.tec.datos.objects.Message;
import org.tec.datos.objects.User;

public class WriteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText messageField;
    private ImageButton sendButton;
    private Message message;
    private Spinner contactSpinner;
    private ArrayAdapter<String> arrayAdapterContact;
    private SimpleList<User> userList;
    private String[] contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        //************TOOLBAR******
        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);





        this.userList=new SimpleList<>();
        this.userList.addLast(new User("Juan", "juan09_@gmail.com"));
        this.userList.addLast(new User("Pedro", "pRodrigues@hotmail.com"));
        this.userList.addLast(new User("Luis","luis56@gmail.com"));
        this.userList.addLast(new User("Manfred","m3489@hotmail.es"));
        this.userList.addLast(new User("Manuel","man@hotmail.com"));
        this.userList.addLast(new User("Pamela","pame09@gmail.com"));
        this.userList.addLast(new User("Paola","pao78@hotmail.com"));
        this.contactList= new String[this.userList.length()+1];
        this.contactList[0]="";
        for (int i=0;i<this.userList.length();i++){
            this.contactList[i+1]=this.userList.findItem(i).getEmail();
        }



        this.contactSpinner= findViewById(R.id.contactSpinner);
        this.messageField = findViewById(R.id.messageField);
        this.sendButton= findViewById(R.id.sendButton);
        this.contactSpinner.setOnItemSelectedListener(this);
        this.arrayAdapterContact=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,this.contactList);
        this.contactSpinner.setAdapter(arrayAdapterContact);

        //Falta agregar la verificacion de que se haya seleccionado un contacto
        this.sendButton.setOnClickListener(new View.OnClickListener() {
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

            case R.id.action_search:
                intent = new Intent(WriteActivity.this, SearchActivity.class);
                Toast.makeText(WriteActivity.this,"Go to Search", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;

            case R.id.action_newMsg:
                intent = new Intent(WriteActivity.this, SearchActivity.class);
                Toast.makeText(WriteActivity.this,"Go to Search", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            case R.id.action_account:
                intent = new Intent(WriteActivity.this, SearchActivity.class);
                Toast.makeText(WriteActivity.this,"Go to Search", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
