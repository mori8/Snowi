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

//    private void getData() {
        // 임의의 데이터입니다.
        // List<String> listTitle = Arrays.asList("국화", "사막", "수국", "해파리", "코알라", "등대", "펭귄", "튤립",
                // "국화", "사막", "수국", "해파리", "코알라", "등대", "펭귄", "튤립");
        // List<String> listContent = Arrays.asList(
//                "이 꽃은 국화입니다.",
//                "여기는 사막입니다.",
//                "이 꽃은 수국입니다.",
//                "이 동물은 해파리입니다.",
//                "이 동물은 코알라입니다.",
//                "이것은 등대입니다.",
//                "이 동물은 펭귄입니다.",
//                "이 꽃은 튤립입니다.",
//                "이 꽃은 국화입니다.",
//                "여기는 사막입니다.",
//                "이 꽃은 수국입니다.",
//                "이 동물은 해파리입니다.",
//                "이 동물은 코알라입니다.",
//                "이것은 등대입니다.",
//                "이 동물은 펭귄입니다.",
//                "이 꽃은 튤립입니다."
//        );
}
