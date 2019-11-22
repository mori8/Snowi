package kr.ac.sookmyung.snowi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BeaconListAdapter extends RecyclerView.Adapter<BeaconItemsHolder> {

    private List<BeaconItemVO> beaconItemsList;

    public static class MyViewHolder extends BeaconItemsHolder{

        TextView b_name_tv;
        TextView b_place_tv;
        TextView b_uuid_tv;
        Switch b_switch;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            b_name_tv = itemView.findViewById(R.id.b_name_tv);
            b_uuid_tv = itemView.findViewById(R.id.b_uuid_tv);
            b_place_tv = itemView.findViewById(R.id.b_place_tv);
            b_switch = itemView.findViewById(R.id.b_onoff_swi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    CustomDialog customDialog = new CustomDialog(context);
                    customDialog.setDialogListener(new CustomDialog.CustomDialogListener() {
                        @Override
                        public void onPositiveClicked(String devname, String sort) {

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
    public void onBindViewHolder(@NonNull BeaconItemsHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.b_name_tv.setText(beaconItemsList.get(position).getB_name_str());
        myViewHolder.b_uuid_tv.setText(beaconItemsList.get(position).getB_uuid_str());
        myViewHolder.b_place_tv.setText(beaconItemsList.get(position).getB_place_str());
        myViewHolder.b_switch.setChecked(beaconItemsList.get(position).getB_onoff_bln());

    }

    @Override
    public int getItemCount() {
        return beaconItemsList.size();
    }




}