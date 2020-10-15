package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DataAccesObjectInterface <T>{

    void doSave(T item) throws SQLException;

    boolean doDelete(T item) throws SQLException;

    T doRetrieveByKey(T item) throws SQLException;

    ArrayList<T> doRetrieveAll() throws SQLException;
}

