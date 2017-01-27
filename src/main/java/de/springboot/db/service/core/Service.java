package db.service.core;

import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
public interface Service<T> {
    public List<T> getAll();

    public T getById(String id);

    public int add(T t);

    public void delete(T t);
}
