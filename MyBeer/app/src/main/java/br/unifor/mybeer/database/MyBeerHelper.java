package br.unifor.mybeer.database;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Bruno Lopes on 04/05/2017.
 */

public class MyBeerHelper  extends SQLiteOpenHelper{


    public static final String DB_NAME = "mybeer.db";
    public static final int DB_VERSION = 3;

    private Context context;

    public MyBeerHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        execSqlFile(db, "db/create.sql");
        Log.i("MyBeer", "Banco de dados criado com sucesso!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        execSqlFile(db, "db/update.sql");
        onCreate(db);
        Log.i("MyBeer", "Banco de dados atualizado com sucesso!");
    }

    private void execSqlFile(SQLiteDatabase db, String path) {
        try {

            AssetManager assetManager = context.getAssets();
            InputStream in = assetManager.open(path);

            BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
            String line;

            while((line = buffer.readLine()) != null){
                db.execSQL(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
