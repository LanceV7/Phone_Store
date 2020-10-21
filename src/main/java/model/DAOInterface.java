package model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @param <K> la chiave dell'oggetto...
 * @param <T> T è l'oggetto stesso
 */
public interface DAOInterface<K, T> {
    void doSave(T item) throws SQLException;
    boolean doDelete(K key) throws SQLException;
    T doRetrieveByKey(K key) throws SQLException;
    ArrayList<T> doRetrieveAll() throws SQLException;
}
