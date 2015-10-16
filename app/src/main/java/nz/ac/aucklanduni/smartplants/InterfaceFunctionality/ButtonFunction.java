package nz.ac.aucklanduni.smartplants.InterfaceFunctionality;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;

/**
 * Created by mark on 10/16/2015.
 */
public abstract class ButtonFunction implements View.OnClickListener {

    private boolean isClicked;
    protected Context context;

    public ButtonFunction(Activity context) {
        this.context = context;
        this.isClicked = false;
    }

    @Override
    public synchronized void onClick(View v) {
        final int clickDelay = 500;

        if (isClicked) {
            isClicked = false;
            execute();
        } else {
            isClicked = true;

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable(){
                @Override
                public void run(){
                    processSingleClick();
                }
            }, clickDelay);
        }
    }

    private synchronized void processSingleClick() {
        if(isClicked) {
            isClicked = false;
            explore();
        }
    }

    public abstract void execute();

    public abstract void explore();
}
