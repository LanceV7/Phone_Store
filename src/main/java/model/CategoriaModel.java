package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaModel implements DataAccesObjectInterface<Categoria>{

    private DriverManagerConnectionPool dmcp;

    public CategoriaModel(DriverManagerConnectionPool dmcp) {
        this.dmcp = dmcp;

        System.out.println("DriverManager  CategoriaModel creation....");
    }

    private static final String TABLE_NAME = "Categoria";

    public CategoriaModel() {

    }


    @Override
    public void doSave(Categoria categoria) throws SQLException {
        //Dichiari un oggetto di tipo connection.
        Connection connection = null;
        //Dichiari un oggetto di tipo prepared statament
        PreparedStatement preparedStatement = null;
        //Crei la stringa per effettuare l'operazione di inserimento.
        String insertSQL = "INSERT INTO " + CategoriaModel.TABLE_NAME
                + " (id, nome) VALUES (?,?)";

        try {
            //Prendi la connessione.
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);

            //Setti i paramentri
            preparedStatement.setInt(1, categoria.getId());
            preparedStatement.setString(2, categoria.getNome());

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
    public boolean doDelete(Categoria categoria) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result;

        String deleteSQL = "DELETE FROM" + CategoriaModel.TABLE_NAME + "WHERE id = ?";

        try {
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.setInt(1, categoria.getId());
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
    public Categoria doRetrieveByKey(Categoria categoria) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Categoria c = new Categoria();
        int id = categoria.getId();

        String selectSQL = "SELECT * FROM " + CategoriaModel.TABLE_NAME + " WHERE id = ?";

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));

            }
        }finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                dmcp.releaseConnection(connection);
            }

        }return c;
    }

    @Override
    public ArrayList<Categoria> doRetrieveAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String order;

        ArrayList<Categoria> lista_categorie = new ArrayList<>();
        String selectSQL = "SELECT * FROM" + CategoriaModel.TABLE_NAME;

        try {
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                lista_categorie.add(c);
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                dmcp.releaseConnection(connection);
            }
        }
        return lista_categorie;
    }
}
