package efficom.slam.groupe2.techplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private  EditText usernameEt;
    private  EditText passwordEt;
    private  Button login_btn;
    private RequestQueue requestQueue;
    private static final String URL = "http://api.vsilvestre.fr/login_check";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, PositionService.class));
        usernameEt = (EditText)findViewById(R.id.edittext_username);
        passwordEt = (EditText)findViewById(R.id.edittext_password);
        login_btn = (Button)findViewById(R.id.button_login);

        requestQueue = Volley.newRequestQueue(this);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getString("success").equals("success")){
                                Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),ListIntervention.class));

                            }else{
                                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String,String> hashMap = new HashMap<String, String>();
                        hashMap.put("username",usernameEt.getText().toString());
                        hashMap.put("password",passwordEt.getText().toString());
                        return hashMap;
                    }

                };
                requestQueue.add(request);
            }
        });


    }


}

//        getData();
//    }
//
//    private void getData(){
//        lv_intervention = (ListView) findViewById(R.id.lv_intervention);
//        //String url = "https://raw.githubusercontent.com/artandor/TPs-Android/master/tpAmine1901/etudiants.json";
//        String url = "https://apirestppe4-artandor.c9users.io/index.php/get_all_latlong";
//
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                       // lv_intervention.setAdapter();
//                    }
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // TODO Auto-generated method stub
//
//                    }
//                });
//        Volley.newRequestQueue(this).add(jsObjRequest);
//    }
//}
