package org.tec.datos.messages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class WriteActivity extends AppCompatActivity {

    private EditText messageField;
    private ImageButton sendButton;
    private Message message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        messageField = findViewById(R.id.messageField);
        sendButton= findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = messageField.getText().toString();
                Message message = new Message(messageField.getText().toString());
                if (name != null && !name.isEmpty()) {
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
}
