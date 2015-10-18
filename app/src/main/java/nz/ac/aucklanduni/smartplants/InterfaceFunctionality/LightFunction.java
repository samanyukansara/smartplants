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
    int count;

    public LightFunction(Activity context) {
        super(context);
        count = 0;
        this.lightAi = new LightAi();
    }

    @Override
    public void execute() {
        MediaPlayer mediaPlayer;
        switch(count) {
            case 0:
                mediaPlayer = MediaPlayer.create(context, R.raw.lightenough);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(context, R.raw.lightnotenough);
                mediaPlayer.start();
                break;
            default:
                final int value = this.lightAi.getValue(this.context);

                if (value <= 10) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.lightnotenough);
                    mediaPlayer.start();
                } else {
                    mediaPlayer = MediaPlayer.create(context, R.raw.lightenough);
                    mediaPlayer.start();
                }
        }
        count++;
    }

    @Override
    public void explore() {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.light);
        mediaPlayer.start();
    }
}
