package nz.ac.aucklanduni.smartplants.InterfaceFunctionality;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by mark on 10/16/2015.
 */
public class HelpFunction extends ButtonFunction {

    public HelpFunction(Activity context) {
        super(context);
    }

    @Override
    public void execute() {
        Toast.makeText(context, "Executing help function",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void explore() {
        Toast.makeText(context, "Exploring help function",Toast.LENGTH_SHORT).show();
    }
}
