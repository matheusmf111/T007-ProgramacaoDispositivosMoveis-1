package br.unifor.mybeer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.unifor.mybeer.model.Beer;

/**
 * Created by Bruno Lopes on 09/05/2017.
 */

public class BeerDAO extends AbstractDAO<Beer> {

    private static final String TABLE_NAME = "beers";

    public BeerDAO(Context context) {
        super(context, TABLE_NAME);
    }

    @Override
    public ContentValues getContentValues(Beer obj) {

        ContentValues cValues = null;

        if(obj != null){

            cValues = new ContentValues();
            cValues.put("name", obj.getName());
            cValues.put("brand", obj.getBrand());
            cValues.put("volume", obj.getVolume());
            cValues.put("kind", obj.getKind());
            cValues.put("score", obj.getScore());
            cValues.put("picture", obj.getPicture());
        }

        return cValues;

    }

    @Override
    public Beer createObjectFromCursor(Cursor cursor) {

        Beer beer = null;

        if(cursor != null){
            cursor.moveToFirst();
            beer = createBeerFromCursor(cursor);
        }

        return beer;

    }

    @Override
    protected List<Beer> createObjectListFromCursor(Cursor cursor) {

        List<Beer> beers = null;

        if(cursor != null){

            beers = new ArrayList<>();
            cursor.moveToFirst();

            do{
                beers.add(createBeerFromCursor(cursor));
            }while(cursor.moveToNext());

        }

        return beers;
    }

    @NonNull
    private Beer createBeerFromCursor(Cursor cursor) {
        Beer beer = new Beer();
        beer.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        beer.setName(cursor.getString(cursor.getColumnIndex("name")));
        beer.setBrand(cursor.getString(cursor.getColumnIndex("brand")));
        beer.setVolume(cursor.getInt(cursor.getColumnIndex("volume")));
        beer.setKind(cursor.getString(cursor.getColumnIndex("kind")));
        beer.setScore(cursor.getInt(cursor.getColumnIndex("score")));
        beer.setPicture(cursor.getString(cursor.getColumnIndex("picture")));
        return beer;
    }

}
