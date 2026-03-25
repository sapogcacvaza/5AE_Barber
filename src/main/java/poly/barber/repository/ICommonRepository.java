package poly.barber.repository;

import java.util.List;

public interface ICommonRepository<T, K> {
    List<T> getAll();

    T getOne(K id);

    void add(T obj);

    void delete(K id);

    void update(T obj);
}
