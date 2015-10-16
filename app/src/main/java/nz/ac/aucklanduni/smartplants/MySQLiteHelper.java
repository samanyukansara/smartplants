package nz.ac.aucklanduni.smartplants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {

        String CREATE_TEMP_TABLE = "CREATE TABLE temperature ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT, "+
                "temp INTEGER )";

        String CREATE_LIGHT_TABLE = "CREATE TABLE light ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT, "+
                "lightV INTEGER )";

        String CREATE_MOISTURE_TABLE = "CREATE TABLE moisture ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT, "+
                "moistureV INTEGER )";

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


        this.onCreate(sdb);
    }

    public void addTemp(Temperature temp)
    {
        Log.d("addTemp", temp.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TEMP, temp.getTemp());
        values.put(KEY_DATE_TEMP, temp.getDate());

        db.insert(TABLE_TEMP,
                null,
                values);

        db.close();

    }

    public Temperature getTemp(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_TEMP,
                        TEMP_COLUMNS,
                        "id = ? ",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);
        db.rawQuery("select * from temperature", null);

        if (cursor != null) {
            cursor.moveToFirst();
            Log.d("how many ", " " + cursor.getCount());
        }

        Temperature temp = new Temperature();
        temp.setID(Integer.parseInt(cursor.getString(0)));
        temp.setDate(cursor.getString(1));
        temp.setTemp(Integer.parseInt(cursor.getString(2)));

        Log.d("getTemp(" + id + ")", temp.toString());

        return null;
    }

    public void addLight(Light lightV)
    {
        Log.d("addLightValue", lightV.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LIGHT, lightV.getLight());
        values.put(KEY_DATE_LIGHT, lightV.getDate());

        db.insert(TABLE_LIGHT,
                null,
                values);

        db.close();

    }

    public Light getLight(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_LIGHT,
                        LIGHT_COLUMNS,
                        "id = ? ",
                        new String[]{String.valueOf(id)},
                        null,
                        null,
                        null,
                        null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Light lightV = new Light();
        lightV.setID(Integer.parseInt(cursor.getString(0)));
        lightV.setDate(cursor.getString(1));
        lightV.setLight(Integer.parseInt(cursor.getString(2)));

        Log.d("getLight(" + id + ")", lightV.toString());

        return lightV;
    }

    public void addMoisture(Moisture moistureV)
    {
        Log.d("addMoistureValue", moistureV.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MOISTURE, moistureV.getMoisture());
        values.put(KEY_DATE_MOISTURE, moistureV.getDate());

        db.insert(TABLE_MOISTURE,
                null,
                values);

        db.close();
    }

    public Moisture getMoisture(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_MOISTURE,
                        MOISTURE_COLUMNS,
                        "id = ? ",
                        new String[]{String.valueOf(id)},
                        null,
                        null,
                        null,
                        null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Moisture moistureV = new Moisture();
        moistureV.setID(Integer.parseInt(cursor.getString(0)));
        moistureV.setDate(cursor.getString(1));
        moistureV.setMoisture(Integer.parseInt(cursor.getString(2)));

        Log.d("getMoisture(" + id + ")", moistureV.toString());

        return moistureV;
    }

    public List<Integer> retrieveTemp(){
        final SQLiteDatabase db = this.getReadableDatabase();
        final String queryS = "SELECT * FROM temperature ORDER BY id DESC LIMIT 24";

        final List<Integer> lastRecords = new ArrayList<Integer>();
        final Cursor cursor =
                db.rawQuery(queryS, null);
        if (cursor != null) {
            while(cursor.moveToNext()) {
                lastRecords.add(Integer.valueOf(cursor.getString(2)));
            }
        }
        return lastRecords;
    }

    public List<Integer> retrieveLight(){
        final SQLiteDatabase db = this.getReadableDatabase();
        final String queryS = "SELECT * FROM light ORDER BY id DESC LIMIT 24";

        final List<Integer> lastRecords = new ArrayList<Integer>();
        final Cursor cursor =
                db.rawQuery(queryS, null);
        if (cursor != null) {
            while(cursor.moveToNext()) {
                lastRecords.add(Integer.valueOf(cursor.getString(2)));
            }
        }
        return lastRecords;
    }

    public List<Integer> retrieveMoist(){
        final SQLiteDatabase db = this.getReadableDatabase();
        final String queryS = "SELECT * FROM moisture ORDER BY id DESC LIMIT 24";

        final List<Integer> lastRecords = new ArrayList<Integer>();
        final Cursor cursor =
                db.rawQuery(queryS, null);
        if (cursor != null) {
            while(cursor.moveToNext()) {
                lastRecords.add(Integer.valueOf(cursor.getString(2)));
            }
        }
        return lastRecords;
    }
}
