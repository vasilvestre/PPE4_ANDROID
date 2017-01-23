package efficom.slam.groupe2.techplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView tv_result;
    private ListView lv_intervention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
    }

    private void getData(){
        tv_result = (TextView) findViewById(R.id.tv_result);
        //String url = "https://raw.githubusercontent.com/artandor/TPs-Android/master/tpAmine1901/etudiants.json";
        String url = "https://apirestppe4-artandor.c9users.io/index.php/get_all_latlong";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        tv_result.setText("Response: " + response.toString());
                        //lv_intervention.setAdapter();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });
        Volley.newRequestQueue(this).add(jsObjRequest);
    }
}
