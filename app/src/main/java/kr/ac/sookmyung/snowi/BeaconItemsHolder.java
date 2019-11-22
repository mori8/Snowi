package kr.ac.sookmyung.snowi;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BeaconItemsHolder extends RecyclerView.ViewHolder {

    private int mCurrentPosition;

    public BeaconItemsHolder(@NonNull View itemView) {

        super(itemView);
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
