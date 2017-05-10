package br.unifor.mybeer.database;

import java.util.List;

import br.unifor.mybeer.model.IModel;

/**
 * Created by Bruno Lopes on 04/05/2017.
 */

public interface GenericDAO<T> {

    public void insert(T obj);

    public void update(T obj);

    public void delete(T obj);

    public T find(int id);

    public List<T> findAll();

}
