package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
public class DriverManagerConnectionPool {
    private List<Connection> freeDbConnections;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("DB driver not found:"+ e.getMessage());
        }
    }

    public DriverManagerConnectionPool() {
        freeDbConnections = new LinkedList<>();
    }

    private synchronized Connection createDBConnection() throws SQLException {
        Connection newConnection;
        String ip = "localhost";
        String port = "3306";
        String db = "db_phone";
        String username = "root";
        String password = "root";


        newConnection = DriverManager.getConnection("jdbc:mysql://"+ ip+":"+
                port+"/"+ db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", username, password);
        newConnection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        newConnection.setAutoCommit(false);
        return newConnection;
    }


    public synchronized Connection getConnection() throws SQLException {
        Connection connection;
        //Se la connessione è già presente allora la prendo direttamente dalla lista altrimenti la creo e la aggiuno alla lista.
        if (!freeDbConnections.isEmpty()) {
            connection = freeDbConnections.get(0);
            freeDbConnections.remove(0);

            try {
                if (connection.isClosed())
                    connection = getConnection();
            } catch (SQLException e) {
                connection.close();
                connection = getConnection();
            }
        } else {
            connection = createDBConnection();

        }

        return connection;
    }

    public synchronized void releaseConnection(Connection connection) throws SQLException {
        if(connection != null) freeDbConnections.add(connection);
    }

    public static DriverManagerConnectionPool getIstance () {return LazyHolder.ISTANCE;}

    private static class LazyHolder {
        private static final DriverManagerConnectionPool ISTANCE = new DriverManagerConnectionPool();
    }
}
