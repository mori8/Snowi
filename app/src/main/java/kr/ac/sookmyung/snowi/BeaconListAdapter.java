package kr.ac.sookmyung.snowi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.altbeacon.beacon.Beacon;

import java.util.ArrayList;
import java.util.List;

public class BeaconListAdapter extends RecyclerView.Adapter<BeaconItemsHolder> {

    private List<BeaconItemVO> beaconItemsList;
    BeaconItemVO minBeacon;

    public BeaconItemVO getMinBeacon(List<BeaconItemVO> beacons){
        Double min = 30000.0;
        for(BeaconItemVO beacon : beacons){
            if(min > Double.parseDouble(beacon.getB_distance_str())){
                minBeacon = beacon;
                min = Double.parseDouble(beacon.getB_distance_str());
            }

        }
        return minBeacon;
    }


    public static class MyViewHolder extends BeaconItemsHolder{

        TextView b_name_tv;
        TextView b_distance_tv;
        TextView b_uuid_tv;
        Boolean b_switch_bl;
        Switch b_switch;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            b_name_tv = itemView.findViewById(R.id.b_name_tv);
            b_distance_tv = itemView.findViewById(R.id.b_distance_tv);
            b_uuid_tv = itemView.findViewById(R.id.b_uuid_tv);
            b_switch = itemView.findViewById(R.id.b_onoff_swi);
            b_switch_bl = b_switch.isChecked();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    CustomDialog customDialog = new CustomDialog(context);
                    customDialog.setDialogListener(new CustomDialog.CustomDialogListener() {

                        @Override
                        public void onPositiveClicked(String devname, String sort, String place) {
                            b_name_tv.setText(devname);
                        }

                        @Override
                        public void onNegativeClicked() {

                        }
                    });
                    customDialog.show();
                }
            });
        }

        @Override
        protected void clear() {
            // 초기화 만들기
        }
    }

    public BeaconListAdapter(ArrayList<BeaconItemVO> beaconArrayList) {
        this.beaconItemsList = beaconArrayList;
    }

    @NonNull
    @Override
    public BeaconItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

        return new BeaconListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeaconItemsHolder holder, final int position) {

        final MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.b_name_tv.setText(beaconItemsList.get(position).getB_name_str());
        myViewHolder.b_distance_tv.setText(beaconItemsList.get(position).getB_distance_str()+"m");
        myViewHolder.b_uuid_tv.setText(beaconItemsList.get(position).getB_uuid_str());
        myViewHolder.b_switch.setChecked(beaconItemsList.get(position).getB_onoff_bln());

        myViewHolder.b_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                beaconItemsList.get(position).setB_onoff_bln(isChecked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return beaconItemsList.size();
    }


}