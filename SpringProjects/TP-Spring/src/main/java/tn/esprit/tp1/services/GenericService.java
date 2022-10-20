package tn.esprit.tp1.services;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

    List<T> listAll();

    Optional<T> findOneById(Long id);

    T create(T t);

    T updateOne(Long id, T t);

    void deleteOne(Long id);

    void deleteAll();
}
