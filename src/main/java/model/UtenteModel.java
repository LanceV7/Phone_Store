package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteModel implements DAOInterface<String,Utente> {
    private final DriverManagerConnectionPool dmcp;

    public UtenteModel(DriverManagerConnectionPool dmcp) {
        this.dmcp = dmcp;

        System.out.println("DriverManager  UtenteModel creation....");
    }

    private static final String TABLE_NAME = "Utente";

    public UtenteModel(){ dmcp=DriverManagerConnectionPool.getIstance();}

    @Override
    public void doSave(Utente utente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + UtenteModel.TABLE_NAME +  "( nome, cognome, indirizzo, email, password) VALUES (?,?,?,?,?)" ;

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setString(1, utente.getNome());
            preparedStatement.setString(2, utente.getCognome());
            preparedStatement.setString(3, utente.getIndirizzo());
            preparedStatement.setString(4, utente.getEmail());
            preparedStatement.setString(5, utente.getPassword());

        }finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                dmcp.releaseConnection(connection);
            }
        }
    }

    @Override
    public boolean doDelete(String key) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result;

        String deleteSQL = "DELETE FROM " + UtenteModel.TABLE_NAME +" WHERE email = ?";

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.setString(1, key);
            result = preparedStatement.executeUpdate();
            connection.commit();
        }finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                dmcp.releaseConnection(connection);
            }
        }
        return (result!=0);
    }

    @Override
    public Utente doRetrieveByKey(String key) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        Utente u= new Utente();

        String selectSQL = "SELECT * FROM " + UtenteModel.TABLE_NAME + " WHERE email = ?";

        try{
            connection = dmcp.getConnection();
            ps= connection.prepareStatement(selectSQL);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                u.setEmail(rs.getString(4));
                u.setNome(rs.getString(1));
                u.setCognome(rs.getString(2));
                u.setIndirizzo(rs.getString(3));
                u.setPassword(rs.getString(5));

            }
        }finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                dmcp.releaseConnection(connection);
            }

        }return u;
    }

    @Override
    public ArrayList<Utente> doRetrieveAll() throws SQLException {
        try(Connection connection = dmcp.getConnection()){
            String selectSQL = "SELECT * FROM " + UtenteModel.TABLE_NAME;
            PreparedStatement ps = connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Utente> utente = new ArrayList<>();
            while(rs.next()){
                Utente u = new Utente();
                u.setEmail(rs.getString(4));
                u.setNome(rs.getString(1));
                u.setCognome(rs.getString(2));
                u.setIndirizzo(rs.getString(3));
                u.setPassword(rs.getString(5));
                utente.add(u);
            }

            return utente;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
