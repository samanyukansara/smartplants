package nz.ac.aucklanduni.smartplants.InterfaceFunctionality;

import android.app.Activity;
import android.media.MediaPlayer;
import nz.ac.aucklanduni.smartplants.R;

/**
 * Created by mark on 10/16/2015.
 */
public class HelpFunction extends ButtonFunction {

    public HelpFunction(Activity context) {
        super(context);
    }

    @Override
    public void execute() {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.helpread);
        mediaPlayer.start();
    }

    @Override
    public void explore() {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.help);
        mediaPlayer.start();
    }
}
