package efficom.slam.groupe2.techplan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import efficom.slam.groupe2.techplan.Models.Intervention;

public class ListIntervention extends AppCompatActivity {
    JSONArray listInterventionJson = null;
    private ListView listInterventionView;
    private List<Intervention> listIntervention = new ArrayList<Intervention>();
    private InterventionAdapter interventionAdapter;

    private ProgressDialog dialog;
    private Button detailsButton;
    private RequestQueue requestQueue;
    private static final String URL = "http://api.vsilvestre.fr/interventions";
    private StringRequest request;

    protected void hideDialog()
    {
        if (dialog != null)
        {
            dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_list_intervention);
        listInterventionView = (ListView) findViewById(R.id.listIntervention);
        interventionAdapter = new InterventionAdapter(this,listIntervention);
        listInterventionView.setAdapter(interventionAdapter);


        dialog= new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        requestQueue = Volley.newRequestQueue(this);

        request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {

                try {
                    JSONObject reponseJson = new JSONObject(response);
                    listInterventionJson = reponseJson.getJSONArray("interventions");
                    for(Integer i =0 ; i<listInterventionJson.length();i++) {
                        JSONObject interventionJson = listInterventionJson.getJSONObject(i);
                        Intervention itemIntervention = new Intervention();


                        itemIntervention.setId_intervention(interventionJson.getString("id_intervention"));
                        itemIntervention.setEntreprise(interventionJson.getString("entreprise"));
                        itemIntervention.setCity(interventionJson.getString("city"));
                        itemIntervention.setIntervention_duration(interventionJson.getString("intervention_duration"));
                        itemIntervention.setIntervention_start(interventionJson.getString("intervention_start"));
                        itemIntervention.setImage(interventionJson.getString("picture"));

                        listIntervention.add(itemIntervention);


                        //Log.d("Intervention",intervention.getString("entreprise"));
                    }

                    Log.d("debug", String.valueOf( listIntervention.size()));
                    interventionAdapter.notifyDataSetInvalidated();

                    hideDialog();

                    listInterventionView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            try {
                                Intent intent = new Intent(getApplicationContext(),InterventionDetails.class);
                                JSONObject interventionJson = listInterventionJson.getJSONObject(position);
                                intent.putExtra("id_intervention",interventionJson.getString("id_intervention"));
                                intent.putExtra("entreprise",interventionJson.getString("entreprise"));
                                intent.putExtra("city",interventionJson.getString("city"));
                                intent.putExtra("intervention_duration",interventionJson.getString("intervention_duration"));
                                intent.putExtra("intervention_start",interventionJson.getString("intervention_start"));
                                startActivity(intent);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                    Log.d("response", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("errorResponse",error.toString());
            }
        });
        requestQueue.add(request);

    }



}
