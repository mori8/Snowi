package kr.ac.sookmyung.snowi.DB;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class DBConnect extends AsyncTask<String, Void, String> { //diviceaddActivity
    private static String IP_ADDRESS = "13.125.236.238"; //서버 IP주소
    InputStreamReader temp;
    HttpURLConnection con;

    String str, receivMsg;

    @Override
    protected String doInBackground(String... params) {

        try {
            URL url = new URL("http://" + IP_ADDRESS + "/" + params[0] + ".php");
            String http_code = params[0].substring(0, 3);

            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            if(con.getResponseCode() == con.HTTP_OK){
                temp = new InputStreamReader(con.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(temp);
                StringBuffer buffer = new StringBuffer();

                while((str = reader.readLine()) != null){ // json 읽어와서 buffer에 추가
                    buffer.append(str);
                }

                receivMsg = buffer.toString(); // 받아온 json을 String으로 저장

                JSONObject jsonObject = new JSONObject(receivMsg); //받아온 json을 object화
                JSONArray resultData = jsonObject.getJSONArray("getData");

                for ( int i = 0; i < resultData.length(); ++i ) {
                    JSONObject tmp = resultData.getJSONObject(i); //출력
                    Log.i("GET_DATA", tmp.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    public void setBeaconInfo(String json){ //beaconinfo 저장
        BeaconVO beaconVo = new BeaconVO(); // beacon_info 받아서 set/get하는 class 만들어야 함

        try{
            JSONArray jsonArray = new JSONObject(json).getJSONArray("beacon_info");

            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                //set beaconVO data
                beaconVo.setBeacon_no(obj.getInt("beacon_no"));
                beaconVo.setBeacon_name(obj.getString("beacon_name"));
                beaconVo.setBeacon_place(obj.getString("beacon_place"));
                beaconVo.setBeacon_prefix(obj.getInt("beacon_prefix"));
                beaconVo.setBeacon_uuid(obj.getString("beacon_uuid"));
                beaconVo.setBeacon_major(obj.getInt("beacon_major"));
                beaconVo.setBeacon_minor(obj.getInt("beacon_minor"));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
