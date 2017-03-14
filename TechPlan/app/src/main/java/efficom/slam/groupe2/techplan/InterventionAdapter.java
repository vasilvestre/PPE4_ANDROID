package efficom.slam.groupe2.techplan;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import efficom.slam.groupe2.techplan.Models.Intervention;
import efficom.slam.groupe2.techplan.Singelton.AppController;

/**
 * Created by lbettini on 27/02/17.
 */

public class InterventionAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Intervention> interventions;
    ImageLoader imageLoader= AppController.getmInstance().getmImageLoader();

    public InterventionAdapter(Activity activity,List<Intervention> interventions){
        this.activity=activity;
        this.interventions=interventions;
    }

    @Override
    public int getCount() {
        return interventions.size();
    }

    @Override
    public Intervention getItem(int position) {
        return interventions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater==null){
            inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if (convertView==null){
            convertView=inflater.inflate(R.layout.custom_layout,null);
        }
        if (imageLoader==null) {
            imageLoader = AppController.getmInstance().getmImageLoader();
        }


            NetworkImageView imageView = (NetworkImageView) convertView.findViewById(R.id.image_view);

            TextView id = (TextView) convertView.findViewById(R.id.intervention_id);
            TextView entreprise = (TextView) convertView.findViewById(R.id.intervention_entreprise);
            TextView duration = (TextView) convertView.findViewById(R.id.intervention_duration);
            TextView city = (TextView) convertView.findViewById(R.id.intervention_city);
            TextView start = (TextView) convertView.findViewById(R.id.intervention_start);

            Intervention intervention = interventions.get(position);

           // Log.d("debug", "Test view creation");

            id.setText(intervention.getId_intervention());
            entreprise.setText(intervention.getEntreprise());
            duration.setText(intervention.getIntervention_duration());
            city.setText(intervention.getCity());
            start.setText(intervention.getIntervention_start());
            imageView.setImageUrl(intervention.getImage(), imageLoader);



        return convertView;
    }


}
