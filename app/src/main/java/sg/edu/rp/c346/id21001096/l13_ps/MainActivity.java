package sg.edu.rp.c346.id21001096.l13_ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvCarpark;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCarpark = findViewById(R.id.listView);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Carpark> alCarpark = new ArrayList<Carpark>();

        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            String totalLots;
            String lotType;
            String lotsAvailble;
            String carparkNumber;
            String updatedTime;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrData = firstObj.getJSONArray("carpark_data");

                    for(int i = 0; i < jsonArrData.length(); i++) {
                        JSONObject jsonObjInfo = jsonArrData.getJSONObject(i);
                        JSONArray jsonArrInfo  = jsonObjInfo.getJSONArray("carpark_info");
                        JSONObject dataObj = jsonArrInfo.getJSONObject(0);
                        carparkNumber = jsonObjInfo.getString("carpark_number");
                        updatedTime = jsonObjInfo.getString("update_datetime");
                        totalLots = dataObj.getString("total_lots");
                        lotType = dataObj.getString("lot_type");
                        lotsAvailble = dataObj.getString("lots_available");
                        Carpark carpark = new Carpark(totalLots, lotType, lotsAvailble, carparkNumber, updatedTime);
                        alCarpark.add(carpark);
                    }
                }
                catch(JSONException e){

                }
                //POINT X – Code to display List View
                ArrayAdapter<Carpark> aaCarpark = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alCarpark);
                lvCarpark.setAdapter(aaCarpark);


            }//end onSuccess
        });
    }//end onResume

}