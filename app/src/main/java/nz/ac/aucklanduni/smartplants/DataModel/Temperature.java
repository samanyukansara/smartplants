package nz.ac.aucklanduni.smartplants.DataModel;

/**
 * Created by Rodel on 10/16/2015.
 */
public class Temperature {

    private int id;
    private String date;
    private int temp;

    public Temperature(){}

    public Temperature(String date, int temp) {
        super();
        this.date = date;
        this.temp = temp;
    }

    //getters & setters
    public int getTemp(){
        return temp;
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

    public void setTemp(int temp){
        this.temp = temp;
    }

    public void setDate(String date){
        this.date = date;
    }

    @Override
    public String toString() {
        return "Temp [id=" + id + ", date=" + date + ", temp=" + temp
                + "]";
    }
}
