package nz.ac.aucklanduni.smartplants;

/**
 * Created by Rodel on 10/16/2015.
 */
public class Light {

    private int id;
    private String date;
    private int lightV;

    public Light(){}

    public Light(String date, int lightV) {
        super();
        this.date = date;
        this.lightV = lightV;
    }

    //getters & setters
    public int getLight(){
        return lightV;
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

    public void setLight(int lightV){
        this.lightV = lightV;
    }

    public void setDate(String date){
        this.date = date;
    }

    @Override
    public String toString() {
        return "Light Value [id=" + id + ", date=" + date + ", light =" + lightV
                + "]";
    }
}
