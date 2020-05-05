package kr.ac.sookmyung.snowi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class navigateActivity extends AppCompatActivity implements BeaconConsumer {

    private BeaconManager beaconManager;

    // 감지된 비콘들을 임시로 담을 리스트
    private List<Beacon> beaconList = new ArrayList<>();
    ArrayList<BeaconItemVO> beaconArrayList = new ArrayList<>();
    BeaconListAdapter beaconAdapter;

    TextView distanceTextView;
    TextView nameTextView;
    Button voiceBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_navigate);

            distanceTextView = (TextView)findViewById(R.id.n_distance_tv);
            nameTextView = (TextView)findViewById(R.id.n_name_tv);
            voiceBtn = (Button)findViewById(R.id.voice_btn);

            //beacon setting
            beaconManager = BeaconManager.getInstanceForApplication(this);
            beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));

           beaconArrayList.add(new BeaconItemVO("장식용 화분","0.55","c96d936a-f87b-4573-afb3-38ab68ab3e91",true));
            //beacon start
            //beaconManager.bind(this);
           // handler.sendEmptyMessage(0);
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            beaconManager.unbind(this);
        }

        @Override
        public void onBeaconServiceConnect() {
            beaconManager.setRangeNotifier(new RangeNotifier() {
                @Override
                // 비콘이 감지되면 해당 함수가 호출된다. Collection<Beacon> beacons에는 감지된 비콘의 리스트가,
                // region에는 비콘들에 대응하는 Region 객체가 들어온다.
                public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                    if (beacons.size() > 0) {
                        beaconList.clear();
                        for (Beacon beacon : beacons) {
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


        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                distanceTextView.setText("");
                nameTextView.setText("");

                for(Beacon beacon : beaconList){
                    if(beacon != null) {
                       // BeaconItemVO minBeacon = beaconAdapter.getMinBeacon(beaconArrayList);

                        distanceTextView.append(String.format(String.format("%.3f", beacon.getDistance())));
                        //nameTextView.append(minBeacon.getB_name_str());
                        voiceBtn.setText("0.55 미터 전방에 장식용 화분이가 위치합니다.조심하세요");
                    }
                }

                // 비콘의 아이디와 거리를 측정하여 textView에 넣는다.



                // 자기 자신을 1초마다 호출
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        };
    }
