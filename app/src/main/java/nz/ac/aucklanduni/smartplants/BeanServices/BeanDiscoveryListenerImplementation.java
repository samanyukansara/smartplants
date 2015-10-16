package nz.ac.aucklanduni.smartplants.BeanServices;

import com.punchthrough.bean.sdk.Bean;
import com.punchthrough.bean.sdk.BeanDiscoveryListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark on 10/16/2015.
 */
public class BeanDiscoveryListenerImplementation implements BeanDiscoveryListener {

    final List<Bean> beans = new ArrayList<>();
    List<BeanObservers> observers = new ArrayList<>();

    @Override
    public void onBeanDiscovered(Bean bean, int rssi) {
        beans.add(bean);
    }

    @Override
    public void onDiscoveryComplete() {
        for (Bean bean : beans) {
            System.out.println(bean.getDevice().getName());   // "Bean"              (example)
            System.out.println(bean.getDevice().getAddress());    // "B4:99:4C:1E:BC:75" (example)
            notifyObservers(bean);
        }
    }

    private void notifyObservers(Bean bean) {
        for (BeanObservers observer: observers) {
            observer.onBeanDiscovered(bean);
        }
    }

    public void registerBeanObserver(BeanObservers observer) {
        observers.add(observer);
    }

    public void deregisterBeanObserver(BeanObservers observer) {
        observers.remove(observer);
    }
}
