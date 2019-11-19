package kr.ac.sookmyung.snowi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        Button settings_button = (Button) findViewById(R.id.deviceaddbutton);
        settings_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), deviceaddActivity.class);
                startActivity(intent);
            }
        });

        Button device_set_button = (Button) findViewById(R.id.devicesetbutton);
        device_set_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), devicesetActivity.class);
                startActivity(intent);
            }
        });
    }
}
