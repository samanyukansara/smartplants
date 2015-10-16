package nz.ac.aucklanduni.smartplants.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import nz.ac.aucklanduni.smartplants.BeanServices.BeanConnector;
import nz.ac.aucklanduni.smartplants.MySQLiteHelper;
import nz.ac.aucklanduni.smartplants.R;
import nz.ac.aucklanduni.smartplants.Temperature;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new BeanConnector(this);
        MySQLiteHelper myHelper = new MySQLiteHelper(this);
        myHelper.addTemp(new Temperature("16/10/2015", 34));
        myHelper.addTemp(new Temperature("17/10/2015", 33));
        myHelper.addTemp(new Temperature("18/10/2015", 32));

        myHelper.retrieve();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
