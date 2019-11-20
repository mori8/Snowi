package kr.ac.sookmyung.snowi;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BeaconItemsHolder extends RecyclerView.ViewHolder {

    private int mCurrentPosition;

    public BeaconItemsHolder(@NonNull View itemView) {

        super(itemView);

        //아이템 클릭 이벤트 처리
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //click event
            }
        });
    }

    protected abstract void clear();

    public void onBind(int position){
        mCurrentPosition = position;
        clear();
    }

    public int getmCurrentPosition(){
        return mCurrentPosition;
    }

}
