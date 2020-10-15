package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoModel implements DataAccesObjectInterface<Prodotto>{

    private DriverManagerConnectionPool dmcp;

    public ProdottoModel(DriverManagerConnectionPool dmcp) {
        this.dmcp = dmcp;

        System.out.println("DriverManager  ProdottoModel creation....");
    }

    private static final String TABLE_NAME = "Telefono";

    public ProdottoModel() {

    }

    @Override
    public void doSave(Prodotto prodotto) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + ProdottoModel.TABLE_NAME +  "(codiceTel, marca, descrizione, prezzo, quantita) VALUES (?,?,?,?,?)" ;

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setInt(1,prodotto.getCodiceTel());
            preparedStatement.setString(2,prodotto.getMarca() );
            preparedStatement.setString(3, prodotto.getDescrizione());
            preparedStatement.setDouble(4, prodotto.getPrezzo());
            preparedStatement.setInt(5,prodotto.getQuantita());
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
    public boolean doDelete(Prodotto prodotto) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result;

        String deleteSQL = "DELETE FROM" + ProdottoModel.TABLE_NAME + "WHERE id= ?";

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.setInt(1, prodotto.getCodiceTel());
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
    public Prodotto doRetrieveByKey(Prodotto item) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        Prodotto p = new Prodotto();
        int id = item.getCodiceTel();

        String selectSQL = "SELECT * FROM " + ProdottoModel.TABLE_NAME + " WHERE codiceTel = ?";

        try{
            connection = dmcp.getConnection();
            ps= connection.prepareStatement(selectSQL);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                p.setMarca(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzo(rs.getDouble(4));
                p.setQuantita(rs.getInt(5));

            }
        }finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                dmcp.releaseConnection(connection);
            }

        }return p;
    }



    @Override
    public ArrayList<Prodotto> doRetrieveAll() throws SQLException {
        try(Connection connection = dmcp.getConnection()){
            String selectSQL = "SELECT * FROM" + ProdottoModel.TABLE_NAME;
            PreparedStatement ps = connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Prodotto> prodotti = new ArrayList<>();
            while(rs.next()){
                Prodotto p = new Prodotto();
                p.setMarca(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzo(rs.getDouble(4));
                p.setQuantita(rs.getInt(5));
                p.setCategorie(getCategorie(connection,p.getCodiceTel()));
                prodotti.add(p);
            }

            return prodotti;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private static List<Categoria> getCategorie(Connection connection, int codiceTel) throws SQLException {

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM Categoria LEFT JOIN prodotto_categoria ON id=id WHERE id = ?");
        ps.setInt(1,codiceTel);
        ArrayList<Categoria> categorie = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Categoria c = new Categoria();
            c.setId(rs.getInt(1));
            c.setNome(rs.getString(2));
            categorie.add(c);
        }
        return categorie;
    }


}