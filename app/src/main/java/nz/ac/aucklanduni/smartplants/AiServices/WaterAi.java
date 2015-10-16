package nz.ac.aucklanduni.smartplants.AiServices;

import android.content.Context;
import android.util.Log;

import java.util.List;

import nz.ac.aucklanduni.smartplants.DataModel.MySQLiteHelper;

/**
 * Created by mark on 10/16/2015.
 */
public class WaterAi implements Ai {
    @Override
    public int getValue(Context context) {
        final int DEFAULTVAL = 150;
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(context);
        List<Integer> list = mySQLiteHelper.retrieveMoist();
        if (list.size() > 0) {
            Log.i("waterdatabase", list.get(0).toString());
            return list.get(0);
        }
        else return DEFAULTVAL;
    }
}
