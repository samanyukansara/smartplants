package nz.ac.aucklanduni.smartplants.InterfaceFunctionality;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.Toast;

import nz.ac.aucklanduni.smartplants.AiServices.LightAi;
import nz.ac.aucklanduni.smartplants.R;

/**
 * Created by mark on 10/16/2015.
 */
public class LightFunction extends ButtonFunction {

    final LightAi lightAi;

    public LightFunction(Activity context) {
        super(context);
        this.lightAi = new LightAi();
    }

    @Override
    public void execute() {
        final int value = this.lightAi.getValue();

        if (value <= 10) {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.lightnotenough);
            mediaPlayer.start();
        } else {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.lightenough);
            mediaPlayer.start();
        }
    }

    @Override
    public void explore() {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.light);
        mediaPlayer.start();
    }
}
