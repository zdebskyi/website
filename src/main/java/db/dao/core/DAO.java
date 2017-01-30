package db.dao.core;

import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
public interface DAO<T> {

    public List<T> getAll();

    public T getById(int id, boolean close);

    public int add(T t);
    public void delete(T t);
}
