package edu.ualr.recyclerviewassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.view.View;

import edu.ualr.recyclerviewassignment.data.AdapterListBasic;
import edu.ualr.recyclerviewassignment.model.Device;
import edu.ualr.recyclerviewassignment.data.DataGenerator;
import edu.ualr.recyclerviewassignment.model.Header;
import edu.ualr.recyclerviewassignment.model.Item;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView(){
        // TODO. Create and initialize the RecyclerView instance here

        List<Item> items = DataGenerator.getDevicesDataset(5);
        items.add(new Header("Linked", Header.HeaderType.Linked));
        items.add(new Header("Connected", Header.HeaderType.Connected));
        items.add(new Header("Disconnected", Header.HeaderType.Ready));
        //items.addAll(DataGenerator.getDevicesDataset(5));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        final AdapterListBasic mAdapter = new AdapterListBasic(this, items);
        RecyclerView rView = findViewById(R.id.recyclerView);

        mAdapter.setOnItemClickListener(new AdapterListBasic.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Device obj, int position) {

                if(obj.getDeviceStatus()== Device.DeviceStatus.Ready)
                    obj.setDeviceStatus(Device.DeviceStatus.Connected);
                else if(obj.getDeviceStatus() == Device.DeviceStatus.Connected) {
                    obj.setDeviceStatus(Device.DeviceStatus.Ready);
                }
                obj.setLastConnection(new Date(95364825));
                mAdapter.sortList();
                mAdapter.notifyDataSetChanged();
            }
        });

        rView.setLayoutManager(layoutManager);
        rView.setAdapter(mAdapter);

    }

}
