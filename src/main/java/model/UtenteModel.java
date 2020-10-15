package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteModel implements DataAccesObjectInterface<Utente> {
    private final DriverManagerConnectionPool dmcp;

    public UtenteModel(DriverManagerConnectionPool dmcp) {
        this.dmcp = dmcp;

        System.out.println("DriverManager  UtenteModel creation....");
    }

    private static final String TABLE_NAME = "Utente";

    @Override
    public void doSave(Utente utente) throws SQLException {
        //Dichiari un oggetto di tipo connection.
        Connection connection = null;
        //Dichiari un oggetto di tipo prepared statament
        PreparedStatement preparedStatement = null;
        //Crei la stringa per effettuare l'operazione di inserimento.
        String insertSQL = "INSERT INTO " + UtenteModel.TABLE_NAME
                + " (nome, cognome,indirizzo, email, password) VALUES (?,?,?,?,?)";

        try {
            //Prendi la connessione.
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);

            //Setti i paramentri
            preparedStatement.setString(1, utente.getNome());
            preparedStatement.setString(2, utente.getCognome());
            preparedStatement.setString(3, utente.getIndirizzo());
            preparedStatement.setString(4, utente.getEmail());
            preparedStatement.setString(5, utente.getPassword());

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
    public boolean doDelete(Utente utente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result;

        String deleteSQL = "DELETE FROM" + UtenteModel.TABLE_NAME + "WHERE email = ?";

        try {
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.setString(4, utente.getEmail());
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
    public Utente doRetrieveByKey(Utente utente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Utente u = new Utente();
        String email = utente.getEmail();

        String selectSQL = "SELECT * FROM " + UtenteModel.TABLE_NAME + " WHERE email = ?";

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(4,email);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setIndirizzo(rs.getString("indirizzo"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));

            }
        }finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                dmcp.releaseConnection(connection);
            }

        }return u;
    }

    @Override
    public ArrayList<Utente> doRetrieveAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ArrayList<Utente> lista_utenti = new ArrayList<>();
        String selectSQL = "SELECT * FROM" + UtenteModel.TABLE_NAME;


        try {
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Utente u = new Utente();
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setIndirizzo(rs.getString("indirizzo"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                lista_utenti.add(u);
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                dmcp.releaseConnection(connection);
            }
        }
        return lista_utenti;

    }




}

