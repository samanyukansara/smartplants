package nz.ac.aucklanduni.smartplants.BeanServices;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;

import com.punchthrough.bean.sdk.Bean;
import com.punchthrough.bean.sdk.BeanManager;

/**
 * Created by mark on 10/16/2015.
 */
public final class BeanConnector implements BeanObservers {

    private final Context context;
    private boolean isConnected;

    public BeanConnector(Activity context) {
        this.context = context;
        this.isConnected = false;
        connecetToBluetooth(context);
        discoverBeans();
    }

    private void discoverBeans() {
        BeanDiscoveryListenerImplemtation listener = new BeanDiscoveryListenerImplemtation();
        listener.registerBeanObserver(this);
        BeanManager.getInstance().startDiscovery(listener);
    }

    final public void connecetToBluetooth(Activity context) {
        final int REQUEST_ENABLE_BT = 1;

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            context.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    @Override
    public void onBeanDiscovered(Bean bean) {
        if (!this.isConnected) {
            BeanListenerImplementation listener = new BeanListenerImplementation();
            bean.connect(context, listener);
            this.isConnected = true;
        }
    }
}
