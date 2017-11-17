package org.tec.datos.messages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Message message;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Recogemos el dato del activity anterior
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //message = (Message) bundle.getSerializable("message");
            message= (Message) bundle.getSerializable("message");
            Toast.makeText(SecondActivity.this,message.getText(), Toast.LENGTH_LONG).show();
        }
    }
}
