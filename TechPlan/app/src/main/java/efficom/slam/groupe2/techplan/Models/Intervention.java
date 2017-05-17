package efficom.slam.groupe2.techplan.Models;

/**
 * Created by lbettini on 27/02/17.
 */

public class Intervention {

    private String entreprise,id_intervention,intervention_duration,intervention_start,city,image,address;

    //setter
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public void setId_intervention(String id_intervention) {
        this.id_intervention = id_intervention;
    }

    public void setIntervention_duration(String intervention_duration) {
        this.intervention_duration = intervention_duration;
    }

    public void setIntervention_start(String intervention_start) {
        this.intervention_start = intervention_start;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // getter
    public String getEntreprise() {
        return entreprise;
    }

    public String getId_intervention() {
        return id_intervention;
    }

    public String getIntervention_duration() {
        return intervention_duration;
    }

    public String getIntervention_start() {
        return intervention_start;
    }

    public String getCity() {
        return city;
    }

    public String getImage() {
        return image;
    }

    public void setaddress(String address) {
        this.address = address;
    }
}