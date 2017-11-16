package org.tec.datos.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> names;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.names= this.getAllNames();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
    private List<String> getAllNames(){
        return new ArrayList<String>(){{
            add("Carlos");
            add("Fiorella");
            add("Daniel");
            add("Jose");
            add("Juan");
            add("Pamela");


        }};
    }
}
