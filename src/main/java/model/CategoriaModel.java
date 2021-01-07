package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaModel implements DAOInterface<Integer,Categoria> {
    private DriverManagerConnectionPool dmcp;

    public CategoriaModel(DriverManagerConnectionPool dmcp) {
        this.dmcp = dmcp;

        System.out.println("DriverManager  CategoriaModel creation....");
    }

    private static final String TABLE_NAME = "Categoria";

    public CategoriaModel() {
        dmcp = DriverManagerConnectionPool.getIstance();
    }

    @Override
    public void doSave(Categoria categoria) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + CategoriaModel.TABLE_NAME +  "(id, nome) VALUES (?,?)" ;

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setInt(1,categoria.getId());
            preparedStatement.setString(2,categoria.getNome());
            preparedStatement.executeUpdate();
            connection.commit();

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
    public boolean doDelete(Integer key) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result;

        String deleteSQL = "DELETE FROM " + CategoriaModel.TABLE_NAME + " WHERE id = ?";

        try {
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.setInt(1,key);
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
    public boolean doUpdate(Categoria item) throws SQLException {
        return false;
    }

    @Override
    public Categoria doRetrieveByKey(Integer key) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Categoria c = new Categoria();

        String selectSQL = "SELECT * FROM " + CategoriaModel.TABLE_NAME + " WHERE id = ?";

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1,key);
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

        ArrayList<Categoria> lista_categorie = new ArrayList<>();
        String selectSQL = "SELECT * FROM " + CategoriaModel.TABLE_NAME;


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
