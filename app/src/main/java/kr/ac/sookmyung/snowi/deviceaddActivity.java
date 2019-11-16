package kr.ac.sookmyung.snowi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

import kr.ac.sookmyung.snowi.DB.DBConnect;

public class deviceaddActivity extends AppCompatActivity {

    DBConnect dbConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviceadd);

        //DB data 중 beacon_info 가져오는 코드
        try{
            String result = "";

            dbConnect = new DBConnect();
            result = dbConnect.execute("getBeacon_info").get();

            Log.i("result :", result);

        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
