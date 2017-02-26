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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static EditText usernameEt;
    private static EditText passwordEt;
    private static Button login_btn;
    int attempt_counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, PositionService.class));
        usernameEt = (EditText)findViewById(R.id.edittext_username);
        usernameEt = (EditText)findViewById(R.id.edittext_password);
        //LoginButton();


    }

    public void Onlogin(View view) {
        usernameEt = (EditText)findViewById(R.id.edittext_username);
        passwordEt = (EditText)findViewById(R.id.edittext_password);
        String username = usernameEt.getText().toString();
        String password = passwordEt.getText().toString();
        String type ="Login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);

    }
//    public void LoginButton() {
//        username = (EditText) findViewById(R.id.edittext_username);
//        password = (EditText) findViewById(R.id.edittext_password);
//        login_btn = (Button) findViewById(R.id.button_login);
//
//        login_btn.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (username.getText().toString().equals("user") &&
//                                (password.getText().toString().equals("pass"))){
//                            Toast.makeText(MainActivity.this,"User and Password is correct",Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent("efficom.slam.groupe2.techplan.ListIntervention");
//                            startActivity(intent);
//                        }else{ Toast.makeText(MainActivity.this,"User and Password not correct",Toast.LENGTH_SHORT).show();
//                            attempt_counter--;
//                            if(attempt_counter==0){
//                                login_btn.setEnabled(false);
//                                Toast.makeText(MainActivity.this,"you failed this app with your non-sense!!",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//                }
//        );
//    }


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
