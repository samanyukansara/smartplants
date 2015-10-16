package nz.ac.aucklanduni.smartplants.InterfaceFunctionality;

import android.app.Activity;
import android.media.MediaPlayer;

import nz.ac.aucklanduni.smartplants.AiServices.WaterAi;
import nz.ac.aucklanduni.smartplants.R;

/**
 * Created by mark on 10/16/2015.
 */
public class WaterFunction extends ButtonFunction {

    private final WaterAi waterAi;

    public WaterFunction(Activity context) {
        super(context);
        this.waterAi = new WaterAi();
    }

    @Override
    public void execute() {
        final int value = this.waterAi.getValue(this.context);

        if (value > 80) {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.waterdry);
            mediaPlayer.start();
        } else if (value < 6){
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.watertoomuch);
            mediaPlayer.start();
        } else {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.waterright);
            mediaPlayer.start();
        }
    }

    @Override
    public void explore() {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.water);
        mediaPlayer.start();
    }
}
