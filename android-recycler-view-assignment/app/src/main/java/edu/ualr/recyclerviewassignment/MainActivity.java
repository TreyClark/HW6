package edu.ualr.recyclerviewassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import android.os.Bundle;
import android.view.View;

import edu.ualr.recyclerviewassignment.data.AdapterListBasic;
import edu.ualr.recyclerviewassignment.model.Device;
import edu.ualr.recyclerviewassignment.data.DataGenerator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView(){
        // TODO. Create and initialize the RecyclerView instance here

        List<Device> items = DataGenerator.getDevicesDataset(5);
        //items.addAll(DataGenerator.getDevicesDataset(5));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        AdapterListBasic mAdapter = new AdapterListBasic(this, items);

        mAdapter.setOnItemClickListener(new AdapterListBasic.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Device obj, int position) {
                System.out.println(String.format("The user has tapped on %s", obj.getName()));
            }
        });

        RecyclerView rView = findViewById(R.id.recyclerView);
        rView.setLayoutManager(layoutManager);
        rView.setAdapter(mAdapter);

    }

    public void testFunction(){

    }
}
