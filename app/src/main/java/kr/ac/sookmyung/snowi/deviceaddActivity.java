package kr.ac.sookmyung.snowi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class deviceaddActivity extends AppCompatActivity implements View.OnClickListener{
    //private Button button1;
    private TextView devname;
    private TextView sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviceadd);

        //button1 = (Button)findViewById(R.id.button1);
        //devname = (TextView)findViewById(R.id.devname);
        //sort = (TextView)findViewById(R.id.sort);

        //button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            //case R.id.button1:
//                deviceaddActivity dialog = new deviceaddActivity(this);
//                dialog.setDialogListener(new device.CustomDialogListener() {
//                    @Override
//                    public void onPositiveClicked(String devname, String sort) {
//                        devname.setText(devname);
//                        sort.setText(sort);
//                    }
//
//                    @Override
//                    public void onNegativeClicked() {
//
//                    }
//                });
//                dialog.showDialog();//이거 코드와 다른게
//                break;
//        }
    }
}