package efficom.slam.groupe2.techplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import efficom.slam.groupe2.techplan.Models.Intervention;

public class InterventionDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention_details);

        TextView id_intervention = (TextView) findViewById(R.id.intervention_id);
        TextView entreprise = (TextView) findViewById(R.id.intervention_entreprise);
        TextView city = (TextView) findViewById(R.id.intervention_city);
        TextView duration = (TextView) findViewById(R.id.intervention_duration);
        TextView startAt = (TextView) findViewById(R.id.intervention_start);

        id_intervention.setText(this.getIntent().getStringExtra("id_intervention"));
        entreprise.setText( this.getIntent().getStringExtra("entreprise"));
        city.setText(this.getIntent().getStringExtra("city"));
        duration.setText(this.getIntent().getStringExtra("intervention_duration"));
        startAt.setText( this.getIntent().getStringExtra("intervention_start"));

          }
    }
