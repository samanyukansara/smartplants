package nz.ac.aucklanduni.smartplants.AiServices;

import android.content.Context;
import android.util.Log;

import java.util.List;

import nz.ac.aucklanduni.smartplants.DataModel.MySQLiteHelper;

/**
 * Created by mark on 10/16/2015.
 */
public class LightAi implements Ai {
    @Override
    public int getValue(Context context) {
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(context);
        List<Integer> list = mySQLiteHelper.retrieveLight();
        return getAverage(list);
    }

    private int getAverage(List<Integer> list) {
        final int DEFAULTVAL = 20;
        int total = 0;
        for (Integer integer: list) {
            total += integer;
        }
        if (list.size() > 0) {
            Log.i("lightdatabase", list.get(0).toString());
            return list.get(0);
        }
        else return DEFAULTVAL;
    }
}
