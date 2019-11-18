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
    }

    @Override
    public void onClick(View view) {

    }
}

