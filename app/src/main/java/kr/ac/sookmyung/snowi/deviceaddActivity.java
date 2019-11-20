package kr.ac.sookmyung.snowi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class deviceaddActivity extends AppCompatActivity implements BeaconConsumer {
    private BeaconManager beaconManager;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager r_layoutManager;

    ArrayList<BeaconItemVO> beaconArrayList;
    List<Beacon> beaconList = new ArrayList<org.altbeacon.beacon.Beacon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviceadd);

        //beacon setting
        beaconManager = BeaconManager.getInstanceForApplication(this);
        beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));

        beaconManager.bind(this);

        //recyclerView setting
        recyclerView =findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);

        r_layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(r_layoutManager);

        beaconArrayList = new ArrayList<>();
        beaconArrayList.add(new BeaconItemVO("test1","test : uuid", "test_place",true));
        beaconArrayList.add(new BeaconItemVO("test2","test : uuid", "test_place",true));
        beaconArrayList.add(new BeaconItemVO("test3","test : uuid", "test_place",true));

        BeaconListAdapter beaconAdapter = new BeaconListAdapter(beaconArrayList);
        recyclerView.setAdapter(beaconAdapter);
    }

    @Override
    public void onBeaconServiceConnect() {
        beaconManager.setRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<org.altbeacon.beacon.Beacon> beacons, Region region) {
                if (beacons.size() > 0) {
                    beaconList.clear();
                    for (org.altbeacon.beacon.Beacon beacon : beacons) {
                        beaconList.add(beacon);
                    }
                }
            }
        });

        try {
            beaconManager.startRangingBeaconsInRegion(new Region("myRangingUniqueId", null, null, null));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.unbind(this);
    }


    Handler handler = new Handler() {
        public void handleMessage(Message msg) {

            for(Beacon beacon : beaconList){
                Log.i("GET_BEACON","ID : " + beacon.getId2() + " / " + "Distance : " + Double.parseDouble(String.format("%.3f", beacon.getDistance())) + "m "+beacon.getDistance()+"\n");
                if(beacon != null){
                    Log.i("GET_REAL_BEACON","ID : " + beacon.getId2() + " / " + "Distance : " + Double.parseDouble(String.format("%.3f", beacon.getDistance())) + "m "+beacon.getDistance()+"\n");
                }
            }
            handler.sendEmptyMessageDelayed(0, 1000);
        }
    };


}