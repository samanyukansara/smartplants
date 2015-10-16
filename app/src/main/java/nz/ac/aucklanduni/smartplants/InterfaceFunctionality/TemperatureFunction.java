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

    public TemperatureFunction(Activity context) {
        super(context);
        temperatureAi = new TemperatureAi();
    }

    @Override
    public void execute() {
        final int value = this.temperatureAi.getValue(this.context);

        if (value > 37) {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.temphigh);
            mediaPlayer.start();
        } else if (value < 10){
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.templow);
            mediaPlayer.start();
        } else {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.tempright);
            mediaPlayer.start();
        }
    }

    @Override
    public void explore() {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.temperature);
        mediaPlayer.start();
    }
}
