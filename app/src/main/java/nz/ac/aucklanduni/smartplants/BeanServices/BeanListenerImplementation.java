package nz.ac.aucklanduni.smartplants.BeanServices;

import android.content.Context;
import android.util.Log;

import com.punchthrough.bean.sdk.BeanListener;
import com.punchthrough.bean.sdk.message.BeanError;
import com.punchthrough.bean.sdk.message.ScratchBank;

import java.text.DateFormat;
import java.util.Date;

import nz.ac.aucklanduni.smartplants.DataModel.Light;
import nz.ac.aucklanduni.smartplants.DataModel.Moisture;
import nz.ac.aucklanduni.smartplants.DataModel.MySQLiteHelper;
import nz.ac.aucklanduni.smartplants.DataModel.Temperature;

/**
 * Created by mark on 10/16/2015.
 */
public class BeanListenerImplementation implements BeanListener {

    private int count;
    private MySQLiteHelper mySQLiteHelper;

    public BeanListenerImplementation(Context context){
        count = 1;
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onConnectionFailed() {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onSerialMessageReceived(byte[] bytes) {
        String string = new String(bytes);
        Log.i("serial message", string);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        if (!string.trim().equals("")){
            if (count % 3 == 1) {
                //Save temperature
                mySQLiteHelper.addTemp(new Temperature(currentDateTimeString, Integer.parseInt(string)));
            }else if(count % 3 == 2) {
                //Save light
                mySQLiteHelper.addLight(new Light(currentDateTimeString, Integer.parseInt(string)));
            }else{
                //Save water
                mySQLiteHelper.addMoisture(new Moisture(currentDateTimeString, Integer.parseInt(string)));
            }
            count++;
        }
    }

    @Override
    public void onScratchValueChanged(ScratchBank scratchBank, byte[] bytes) {

    }

    @Override
    public void onError(BeanError beanError) {

    }
}
