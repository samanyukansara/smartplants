package nz.ac.aucklanduni.smartplants.InterfaceFunctionality;

import android.app.Activity;
import android.media.MediaPlayer;

import nz.ac.aucklanduni.smartplants.AiServices.TemperatureAi;
import nz.ac.aucklanduni.smartplants.R;

/**
 * Created by mark on 10/16/2015.
 */
public class TemperatureFunction extends ButtonFunction {

    private final TemperatureAi temperatureAi;
    private int count;

    public TemperatureFunction(Activity context) {
        super(context);
        temperatureAi = new TemperatureAi();
        count = 0;
    }

    @Override
    public void execute() {
        MediaPlayer mediaPlayer;
        switch(count) {
            case 0:
                mediaPlayer = MediaPlayer.create(context, R.raw.tempright);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(context, R.raw.temphigh);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(context, R.raw.tempright);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(context, R.raw.templow);
                mediaPlayer.start();
                break;
            default:
                final int value = this.temperatureAi.getValue(this.context);

                if (value > 37) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.temphigh);
                    mediaPlayer.start();
                } else if (value < 10) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.templow);
                    mediaPlayer.start();
                } else {
                    mediaPlayer = MediaPlayer.create(context, R.raw.tempright);
                    mediaPlayer.start();
                }
        }
        count++;
    }

    @Override
    public void explore() {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.temperature);
        mediaPlayer.start();
    }
}
