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

    ArrayList<BeaconItemVO> beaconArrayList = new ArrayList<>();
    BeaconListAdapter beaconAdapter;
    //beacon get now
    List<Beacon> beaconList = new ArrayList<org.altbeacon.beacon.Beacon>();

    List arrBeaconSave = new ArrayList();
    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviceadd);

        //beacon setting
        beaconManager = BeaconManager.getInstanceForApplication(this);
        beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));
        //beacon start
        beaconManager.bind(this);

        //recyclerView setting
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);

        r_layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(r_layoutManager);

        beaconArrayList.add(new BeaconItemVO("test","test","test", true));

        handler.sendEmptyMessage(0);

        beaconAdapter = new BeaconListAdapter(beaconArrayList);
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
                if(beacon != null) {
                    if ((position = arrBeaconSave.indexOf(beacon.getBluetoothAddress())) == -1) {
                        Log.i("GET_BEACON3", "beacon add : " + beacon.getBluetoothAddress() + "ID : " + beacon.getId2() + " / " + "Distance : " + Double.parseDouble(String.format("%.3f", beacon.getDistance())) + "m " + beacon.getDistance() + "\n");
                        beaconArrayList.add(new BeaconItemVO("등록되지 않은 비콘", String.format("%.3f", beacon.getDistance()), beacon.getId1().toString(),  true));
                        arrBeaconSave.add(beacon.getBluetoothAddress());
                    } else { Log.i("GET_BEACON3", "beacon add : " + beacon.getBluetoothAddress() + "ID : " + beacon.getId2() + " / " + "Distance : " + Double.parseDouble(String.format("%.3f", beacon.getDistance())) + "m " + beacon.getDistance() + "\n");
                        //이미 검색 비콘 일 때
                        beaconArrayList.set(position, beaconArrayList.get(position).setBB_distance(String.format("%.3f", beacon.getDistance())));
                    }
                }
            }
            //Log.i("BEACON LIST SIZE", beaconList.size()+"");

            beaconAdapter.notifyDataSetChanged();

            handler.sendEmptyMessageDelayed(0, 1200);
        }
    };
}