package kr.ac.sookmyung.snowi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.SystemRequirementsChecker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nav_button = (Button) findViewById(R.id.navstartbutton);
        nav_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), navigateActivity.class);
                startActivity(intent);
            }
        });

        Button device_set_button = (Button) findViewById(R.id.deviceaddbutton);
        device_set_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), deviceaddActivity.class);
                startActivity(intent);
            }
        });

        Button myinfo_button = (Button) findViewById(R.id.myinfobutton);
        myinfo_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), myinfoActivity.class);
                startActivity(intent);
            }
        });

        Button settings_button = (Button) findViewById(R.id.settingbutton);
        settings_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), settingsActivity.class);
                startActivity(intent);
            }
        });

        Button device_active_button = (Button) findViewById(R.id.devicesetbutton);
        settings_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), settingsActivity.class);
                startActivity(intent);
            }
        });
    }

}
