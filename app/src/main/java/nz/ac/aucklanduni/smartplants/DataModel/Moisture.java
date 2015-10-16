package nz.ac.aucklanduni.smartplants.DataModel;

/**
 * Created by Rodel on 10/16/2015.
 */
public class Moisture {

    private int id;
    private String date;
    private int moistureV;

    public Moisture(){}

    public Moisture(String date, int moistureV) {
        super();
        this.date = date;
        this.moistureV = moistureV;
    }

    //getters & setters
    public int getMoisture(){
        return moistureV;
    }

    public String getDate(){
        return date;
    }

    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setMoisture(int moistureV){
        this.moistureV = moistureV;
    }

    public void setDate(String date){
        this.date = date;
    }

    @Override
    public String toString() {
        return "Moisture Value [id=" + id + ", date=" + date + ", moisture =" + moistureV
                + "]";
    }
}
