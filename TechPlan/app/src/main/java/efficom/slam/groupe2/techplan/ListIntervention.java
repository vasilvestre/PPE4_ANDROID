package efficom.slam.groupe2.techplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListIntervention extends AppCompatActivity {

    private static ListView list_intervention;
    private static String[] Intervention = new String[]{"test","test2","test3","test4","test5","test6"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_intervention);
        listIntervention();
    }

    public void listIntervention(){
        list_intervention = (ListView)findViewById(R.id.listIntervention);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.intervention_list,Intervention);
        list_intervention.setAdapter(adapter);
        list_intervention.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String)list_intervention.getItemAtPosition(position);
                        Toast.makeText(ListIntervention.this,"position :"+ position +"Value : "+ value,
                                Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
