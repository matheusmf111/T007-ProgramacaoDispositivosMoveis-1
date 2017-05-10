package br.unifor.mybeer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unifor.mybeer.model.IModel;

/**
 * Created by Bruno Lopes on 04/05/2017.
 */

public abstract class AbstractDAO<T extends IModel> implements GenericDAO<T> {

    protected String tableName;
    protected SQLiteDatabase db;


    public AbstractDAO(Context context, String tableName) {
        MyBeerHelper helper = new MyBeerHelper(context);
        this.db = helper.getWritableDatabase();
        this.tableName = tableName;
    }

    @Override
    public void insert(T obj) {
        if (obj != null) {
            db.insert(tableName, null, getContentValues(obj));
        } else {
            throw new NullPointerException("O objeto não pode ser nulo abestado!");
        }

    }

    @Override
    public void update(T obj) {
        if (obj != null) {
            db.update(tableName,
                    getContentValues(obj),
                    "_id = ?",
                    new String[]{obj.getId().toString()});
        } else {
            throw new NullPointerException("O objeto não pode ser nulo abestado!");
        }
    }

    @Override
    public void delete(T obj) {
        if (obj != null) {
            db.delete(tableName,
                    "_id  = ?",
                    new String[]{obj.getId().toString()});
        } else {
            throw new NullPointerException("O objeto não pode ser nulo abestado!");
        }
    }

    @Override
    public T find(int id) {

        T obj = null;

        if (id > 0) {

            Cursor cursor = db.query(tableName,
                    null,
                    "_id = ?",
                    new String[]{String.valueOf(id)},
                    null,
                    null,
                    null);

            if (cursor.getCount() > 0) {
                obj = createObjectFromCursor(cursor);
            }

        }

        return obj;
    }

    @Override
    public List<T> findAll() {

        List<T> objs = null;

        Cursor cursor = db.query(tableName,
                null,
                null,
                null,
                null,
                null,
                null);

        if(cursor.getCount() > 0){
            objs = createObjectListFromCursor(cursor);
        }

        return objs;

    }

    public abstract ContentValues getContentValues(T obj);

    public abstract T createObjectFromCursor(Cursor cursor);

    protected abstract List<T> createObjectListFromCursor(Cursor cursor);

}
