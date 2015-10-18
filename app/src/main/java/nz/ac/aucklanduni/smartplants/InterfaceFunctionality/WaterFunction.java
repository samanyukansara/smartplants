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
    private int count;

    public WaterFunction(Activity context) {
        super(context);
        this.waterAi = new WaterAi();
        count = 0;
    }

    @Override
    public void execute() {
        MediaPlayer mediaPlayer;
        switch(count) {
            case 0:
                mediaPlayer = MediaPlayer.create(context, R.raw.waterdry);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(context, R.raw.watertoomuch);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(context, R.raw.waterright);
                mediaPlayer.start();
                break;
            default:
                final int value = this.waterAi.getValue(this.context);

                if (value > 80) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.waterdry);
                    mediaPlayer.start();
                } else if (value < 6) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.watertoomuch);
                    mediaPlayer.start();
                } else {
                    mediaPlayer = MediaPlayer.create(context, R.raw.waterright);
                    mediaPlayer.start();
                }
        }
        count++;
    }

    @Override
    public void explore() {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.water);
        mediaPlayer.start();
    }
}
