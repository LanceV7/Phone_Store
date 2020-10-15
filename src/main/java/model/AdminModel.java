package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class AdminModel implements DataAccesObjectInterface<Admin>{
    private final DriverManagerConnectionPool dmcp;

    public AdminModel(DriverManagerConnectionPool dmcp) {
        this.dmcp = dmcp;

        System.out.println("DriverManager  AdminModel creation....");
    }

    private static final String TABLE_NAME = "Admin";
    @Override
    public void doSave(Admin admin) throws SQLException {
        //Dichiari un oggetto di tipo connection.
        Connection connection = null;
        //Dichiari un oggetto di tipo prepared statament
        PreparedStatement preparedStatement = null;
        //Crei la stringa per effettuare l'operazione di inserimento.
        String insertSQL = "INSERT INTO " + AdminModel.TABLE_NAME
                + " (email, password) VALUES (?,?)";

        try {
            //Prendi la connessione.
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);

            //Setti i paramentri
            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, admin.getPassword());

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
    public boolean doDelete(Admin admin) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result;

        String deleteSQL = "DELETE FROM" + AdminModel.TABLE_NAME + "WHERE email = ?";

        try {
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.setString(1, admin.getEmail());
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
    public Admin doRetrieveByKey(Admin admin) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Admin a = new Admin();
        String email = admin.getEmail();

        String selectSQL = "SELECT * FROM " + AdminModel.TABLE_NAME + " WHERE email = ?";

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("password"));

            }
        }finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                dmcp.releaseConnection(connection);
            }

        }return a;

    }

    @Override
    public ArrayList<Admin> doRetrieveAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ArrayList<Admin> lista_admin = new ArrayList<>();
        String selectSQL = "SELECT * FROM" + AdminModel.TABLE_NAME;

        try {
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Admin a = new Admin();
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("password"));
                lista_admin.add(a);
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                dmcp.releaseConnection(connection);
            }
        }
        return lista_admin;


    }
}

