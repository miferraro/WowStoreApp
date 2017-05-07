package it.wowstoreapp.app.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import it.wowstoreapp.app.products.Prodotto;

/**
 * Created by user01 on 25/05/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    private static String DB_PATH = null;

    private static String DB_NAME = "db12prodotti_wow";

    public static int CL_ID =0;
    public static int CL_MODELLO =1;
    public static int CL_MARCHIO =2;
    public static int CL_PREZZO =3;
    public static int CL_DESCRIZIONE =4;
    public static int CL_FOTO =5;

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DataBaseHelper(Context context) {

        super(context, DB_NAME, null, 10);
        this.myContext = context;
        this.DB_PATH = "data/data/"+context.getPackageName()+"/databases/";
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException {

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

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        return myDataBase.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);
    }

    public Prodotto getProductByID(String productTable, int id){
        Cursor c = null;
        Prodotto prod = null;

        try{
            createDataBase();
        }catch(IOException ioe) {
            throw  new Error ("Database non creato!");
        }

        try{
            openDataBase();
        }catch(SQLException sqle){
            throw new Error("Niente da fare!");
        }

        String whereClause = "_id ="+id;
        //String[] whereArgs = new String[] {id+""};

        c = query(productTable, null, whereClause, null, null, null, null);

        if(c.moveToFirst()){
            prod.setId(c.getInt(CL_ID));
            prod.setModello(c.getString(CL_MODELLO));
            prod.setMarchio(c.getString(CL_MARCHIO));
            prod.setPrezzo(c.getDouble(CL_PREZZO));
            prod.setDescrizione(c.getString(CL_DESCRIZIONE));
            prod.setFoto(c.getString(CL_FOTO));
            prod.setTabella(productTable);
        }

        return prod;
    }

    public ArrayList<Prodotto> getProducts(String productTable){

        Cursor c = null;
        ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();

        try{
            createDataBase();
        }catch(IOException ioe) {
            throw  new Error ("Database non creato!");
        }

        try{
            openDataBase();
        }catch(SQLException sqle){
            throw new Error("Niente da fare!");
        }

        c = query(productTable, null, null, null, null, null, "PREZZO desc");

        if(c.moveToFirst()){
            do{
                Prodotto p = new Prodotto();
                p.setId(c.getInt(CL_ID));
                p.setModello(c.getString(CL_MODELLO));
                p.setMarchio(c.getString(CL_MARCHIO));
                p.setPrezzo(c.getDouble(CL_PREZZO));
                p.setDescrizione(c.getString(CL_DESCRIZIONE));
                p.setFoto(c.getString(CL_FOTO));
                p.setTabella(productTable);
                listaProdotti.add(p);
            }while(c.moveToNext());
        }

        return listaProdotti;
    }

}