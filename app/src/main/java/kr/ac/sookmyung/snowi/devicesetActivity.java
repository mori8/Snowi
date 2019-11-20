package kr.ac.sookmyung.snowi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class devicesetActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager r_layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviceset);

        init();

        // getData();
    }

    private void init() {
        recyclerView =findViewById(R.id.recyclerView);
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
