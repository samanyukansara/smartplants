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

    private static final String KEY_ID = "id";
    private static final String KEY_TEMP = "temp";
    private static final String KEY_DATE = "date";
    private static final String TABLE_TEMP = "temperature";
    private static final String TEMP_COLUMNS[] = {KEY_ID, KEY_DATE, KEY_TEMP};


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
                "voltage TEXT )";

        String CREATE_MOISTURE_TABLE = "CREATE TABLE moisture ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT, "+
                "voltage TEXT )";

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
        values.put(KEY_DATE, temp.getDate()); // get date

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
            Log.d("how many ", " " + cursor.getCount());
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
}
