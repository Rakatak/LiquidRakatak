package com.example.rakatak.liquidrakatak.datalogic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.rakatak.liquidrakatak.datalogic.user.User;
import com.example.rakatak.liquidrakatak.datalogic.user.UserEntryContract;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by
 Juan-Manuel Fluxà on 03.03.09.
 Modified by Robin Steller alias Rakatak 18.06.15.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.example.rakatak.liquidrakatak/databases/";

    private static String DB_NAME = "liquidDB";

    private SQLiteDatabase myDataBase;

    private final Context myContext;


    public DataBaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException{

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    public User getUser(String mEmail, String mPassword) throws SQLException {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(UserEntryContract.UserEntry.TABLE_NAME_USER,
                        UserEntryContract.UserEntry.COLUMNS, // b. column names
                        "Email=?", // c. selections
                        new String[] { mEmail }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        final User user;
        final String password;
        final String name;
        final String email;
        // 4. build user object
        try {
            name = cursor.getString(cursor.getColumnIndexOrThrow(UserEntryContract.UserEntry.COLUMN_NAME_NAME));
            email = cursor.getString(cursor.getColumnIndexOrThrow(UserEntryContract.UserEntry.COLUMN_NAME_EMAIL));
            password = cursor.getString(cursor.getColumnIndexOrThrow(UserEntryContract.UserEntry.COLUMN_NAME_PASSWORD));
            Log.d("LOGIN", name + "   " + email + "    " + password);
            user = new User(name, email, password);
        } catch (CursorIndexOutOfBoundsException e){
            throw e;
        } finally {
            db.close();
        }
        if (!password.equals(mPassword)){
            throw new CursorIndexOutOfBoundsException(2, 0);
        }

        return user;

    }

    public void addUser(String mName, String mEmail, String mPassword) throws SQLException {

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. build query
        ContentValues values = new ContentValues();
        values.put(UserEntryContract.UserEntry.COLUMN_NAME_NAME, mName);
        values.put(UserEntryContract.UserEntry.COLUMN_NAME_EMAIL, mEmail);
        values.put(UserEntryContract.UserEntry.COLUMN_NAME_PASSWORD, mPassword);

        try {

            db.insert(UserEntryContract.UserEntry.TABLE_NAME_USER, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        } catch (Exception e){
            throw e;
        } finally {
            db.close();
        }
        return;

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();
        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}