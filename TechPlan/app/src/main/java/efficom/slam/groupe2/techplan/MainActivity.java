package efficom.slam.groupe2.techplan;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private class LongOperation extends AsyncTask<String, Integer, ListReponse> {
        ListReponse listEtudiants = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ListReponse list) {
            super.onPostExecute(list);
            Toast.makeText(afficherListe.this, list.getEtudiants().toString(), Toast.LENGTH_LONG).show();
            listViewEtudiants = (ListView) findViewById(R.id.listViewEtudiants);
            ArrayAdapter<Etudiants> adapter = new ArrayAdapter<Etudiants>(afficherListe.this, android.R.layout.simple_list_item_1, list.getEtudiants());
            listViewEtudiants.setAdapter(adapter);


        }

        @Override
        protected ListReponse doInBackground(String... params) {
            String s = null;
            Gson gson = new Gson();
            try {
                s = run(params[0]);
                listEtudiants = gson.fromJson(s, ListReponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }



            return listEtudiants;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }


    ListView listViewEtudiants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_liste);

        new LongOperation().execute("https://raw.githubusercontent.com/artandor/TPs-Android/master/tpAmine1901/etudiants.json");


    }

    RequestQueue queue = Volley.newRequestQueue(this);

    StringRequest stringRequest = new StringRequest(Request.Method.GET,url,
            new Response.Listener<String>(){

              public void onResponse(String response){
                  mtextView.setText("Response is :" + response.substring( 0,500));
              }

            });

    String run(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }
}