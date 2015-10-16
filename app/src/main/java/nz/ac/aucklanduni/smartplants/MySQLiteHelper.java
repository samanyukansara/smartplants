package nz.ac.aucklanduni.smartplants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Rodel on 10/16/2015.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SmartPlants";

    private static final String KEY_ID_TEMP = "id";
    private static final String KEY_TEMP = "temp";
    private static final String KEY_DATE_TEMP = "date";
    private static final String TABLE_TEMP = "temperature";
    private static final String TEMP_COLUMNS[] = {KEY_ID_TEMP, KEY_DATE_TEMP, KEY_TEMP};

    private static final String KEY_ID_LIGHT = "id";
    private static final String KEY_LIGHT = "lightV";
    private static final String KEY_DATE_LIGHT = "date";
    private static final String TABLE_LIGHT = "light";
    private static final String LIGHT_COLUMNS[] = {KEY_ID_LIGHT, KEY_DATE_LIGHT, KEY_LIGHT};

    private static final String KEY_ID_MOISTURE = "id";
    private static final String KEY_MOISTURE = "moistureV";
    private static final String KEY_DATE_MOISTURE = "date";
    private static final String TABLE_MOISTURE = "moisture";
    private static final String MOISTURE_COLUMNS[] = {KEY_ID_MOISTURE, KEY_DATE_MOISTURE, KEY_MOISTURE};

//    private static final String KEY_ID = "id";
//    private static final String KEY_TEMP = "temp";
//    private static final String KEY_DATE = "date";
//    private static final String TABLE_TEMP = "temperature";
//    private static final String TEMP_COLUMNS[] = {KEY_ID, KEY_DATE, KEY_TEMP};


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        // SQL statement to create book table
        String CREATE_TEMP_TABLE = "CREATE TABLE temperature ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT, "+
                "temp INTEGER )";

        String CREATE_LIGHT_TABLE = "CREATE TABLE light ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT, "+
                "lightV TEXT )";

        String CREATE_MOISTURE_TABLE = "CREATE TABLE moisture ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT, "+
                "moistureV TEXT )";

        // create books table
        sdb.execSQL(CREATE_TEMP_TABLE);
        sdb.execSQL(CREATE_LIGHT_TABLE);
        sdb.execSQL(CREATE_MOISTURE_TABLE);
        System.out.println("success");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int oldDB, int newDB) {

        sdb.execSQL("DROP TABLE IF EXISTS temperature");
        sdb.execSQL("DROP TABLE IF EXISTS light");
        sdb.execSQL("DROP TABLE IF EXISTS moisture");
        System.out.println("success");


        // create fresh books table
        this.onCreate(sdb);
    }
    // Crud  operations
    public void addTemp(Temperature temp)
    {
        Log.d("addTemp", temp.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TEMP, temp.getTemp()); // get temp
        values.put(KEY_DATE_TEMP, temp.getDate()); // get date

        // 3. insert
        db.insert(TABLE_TEMP, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();

    }

    public Temperature getTemp(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_TEMP, // a. table
                        TEMP_COLUMNS, // b. column names
                        "id = ? ", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null) {
            cursor.moveToFirst();
//            Log.d("how many ", " " + cursor.getCount());
        }

        // 4. build book object
        Temperature temp = new Temperature();
        temp.setID(Integer.parseInt(cursor.getString(0)));
        temp.setDate(cursor.getString(1));
        temp.setTemp(Integer.parseInt(cursor.getString(2)));
//
//        //log
        Log.d("getTemp(" + id + ")", temp.toString());

        // 5. return book
        return temp;
    }

    public void addLight(Light lightV)
    {
        Log.d("addLightValue", lightV.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LIGHT, lightV.getLight()); // get temp
        values.put(KEY_DATE_LIGHT, lightV.getDate()); // get date

        // 3. insert
        db.insert(TABLE_LIGHT, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();

    }

    public Light getLight(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_LIGHT, // a. table
                        LIGHT_COLUMNS, // b. column names
                        "id = ? ", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null) {
            cursor.moveToFirst();
        }

        // 4. build book object
        Light lightV = new Light();
        lightV.setID(Integer.parseInt(cursor.getString(0)));
        lightV.setDate(cursor.getString(1));
        lightV.setLight(Integer.parseInt(cursor.getString(2)));
//
//        //log
        Log.d("getLight(" + id + ")", lightV.toString());

        // 5. return book
        return lightV;
    }

    public void addMoisture(Moisture moistureV)
    {
        Log.d("addMoistureValue", moistureV.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MOISTURE, moistureV.getMoisture()); // get temp
        values.put(KEY_DATE_MOISTURE, moistureV.getDate()); // get date

        // 3. insert
        db.insert(TABLE_MOISTURE, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public Moisture getMoisture(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_MOISTURE, // a. table
                        MOISTURE_COLUMNS, // b. column names
                        "id = ? ", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null) {
            cursor.moveToFirst();
        }

        // 4. build book object
        Moisture moistureV = new Moisture();
        moistureV.setID(Integer.parseInt(cursor.getString(0)));
        moistureV.setDate(cursor.getString(1));
        moistureV.setMoisture(Integer.parseInt(cursor.getString(2)));
//
//        //log
        Log.d("getMoisture(" + id + ")", moistureV.toString());

        // 5. return book
        return moistureV;
    }
}
