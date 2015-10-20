package nz.ac.aucklanduni.smartplants.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;

import nz.ac.aucklanduni.smartplants.BeanServices.BeanConnector;
import nz.ac.aucklanduni.smartplants.InterfaceFunctionality.HelpFunction;
import nz.ac.aucklanduni.smartplants.InterfaceFunctionality.LightFunction;
import nz.ac.aucklanduni.smartplants.InterfaceFunctionality.TemperatureFunction;
import nz.ac.aucklanduni.smartplants.InterfaceFunctionality.WaterFunction;
import nz.ac.aucklanduni.smartplants.DataModel.MySQLiteHelper;
import nz.ac.aucklanduni.smartplants.R;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        new BeanConnector(this);
        MySQLiteHelper myHelper = new MySQLiteHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new WaterFunction(this));

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new LightFunction(this));

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new TemperatureFunction(this));

        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new HelpFunction(this));

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
