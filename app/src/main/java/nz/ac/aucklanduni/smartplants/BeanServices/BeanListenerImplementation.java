package nz.ac.aucklanduni.smartplants.BeanServices;

import android.util.Log;

import com.punchthrough.bean.sdk.BeanListener;
import com.punchthrough.bean.sdk.message.BeanError;
import com.punchthrough.bean.sdk.message.ScratchBank;

/**
 * Created by mark on 10/16/2015.
 */
public class BeanListenerImplementation implements BeanListener {
    @Override
    public void onConnected() {

    }

    @Override
    public void onConnectionFailed() {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onSerialMessageReceived(byte[] bytes) {
        String string = new String(bytes);
        Log.i("serial message", string);
    }

    @Override
    public void onScratchValueChanged(ScratchBank scratchBank, byte[] bytes) {

    }

    @Override
    public void onError(BeanError beanError) {

    }
}
