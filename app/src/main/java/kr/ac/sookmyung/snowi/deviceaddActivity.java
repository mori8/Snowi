package kr.ac.sookmyung.snowi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class deviceaddActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager r_layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviceadd);

        recyclerView =findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);

        r_layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(r_layoutManager);

        ArrayList<BeaconItemVO> beaconArrayList = new ArrayList<>();
        beaconArrayList.add(new BeaconItemVO("test1","test : uuid", "test_place",true));
        beaconArrayList.add(new BeaconItemVO("test2","test : uuid", "test_place",true));
        beaconArrayList.add(new BeaconItemVO("test3","test : uuid", "test_place",true));

        BeaconListAdapter beaconAdapter = new BeaconListAdapter(beaconArrayList);
        recyclerView.setAdapter(beaconAdapter);
    }

}