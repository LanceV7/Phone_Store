package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminModel implements DAOInterface<String,Admin>{
    private final DriverManagerConnectionPool dmcp;

    public AdminModel(DriverManagerConnectionPool dmcp) {
        this.dmcp = dmcp;

        System.out.println("DriverManager  AdminModel creation....");
    }

    public AdminModel() {
        dmcp = DriverManagerConnectionPool.getIstance();
    }

    private static final String TABLE_NAME = "Utentespecial";
    @Override
    public void doSave(Admin a) throws SQLException {
        //Dichiari un oggetto di tipo connection.
        Connection connection = null;
        //Dichiari un oggetto di tipo prepared statament
        PreparedStatement preparedStatement = null;
        //Crei la stringa per effettuare l'operazione di inserimento.
        String insertSQL = "INSERT INTO " + AdminModel.TABLE_NAME + "(email, password) VALUES (?,?)";
        try {
            //Prendi la connessione.
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);

            //Setti i paramentri
            preparedStatement.setString(1, a.getEmail());
            preparedStatement.setString(2, a.getPassword());

            preparedStatement.executeUpdate();

            connection.commit();
        } finally {
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

        String deleteSQL = "DELETE FROM " + AdminModel.TABLE_NAME +" WHERE email = ?";

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
    public Admin doRetrieveByKey(String key) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        Admin a= null;

        String selectSQL = "SELECT * FROM " + AdminModel.TABLE_NAME + " WHERE email = ?";

        try{
            connection = dmcp.getConnection();
            ps= connection.prepareStatement(selectSQL);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                a= new Admin();
                a.setEmail(rs.getString(1));
                a.setPassword(rs.getString(2));

            }
        }finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                dmcp.releaseConnection(connection);
            }

        }return a;
    }

    @Override
    public boolean doUpdate(Admin item) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Admin> doRetrieveAll() throws SQLException {
        try(Connection connection = dmcp.getConnection()){
            String selectSQL = "SELECT * FROM " + AdminModel.TABLE_NAME;
            PreparedStatement ps = connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Admin> admin= new ArrayList<>();
            while(rs.next()){
                Admin a= new Admin();
                a.setEmail(rs.getString(1));
                a.setPassword(rs.getString(2));
                admin.add(a);
            }

            return admin;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

