package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoModel implements DAOInterface<Integer, Prodotto>{

    private DriverManagerConnectionPool dmcp;

    public ProdottoModel(DriverManagerConnectionPool dmcp) {
        this.dmcp = dmcp;

        System.out.println("DriverManager  ProdottoModel creation....");
    }

    private static final String TABLE_NAME = "Telefono";

    public ProdottoModel() { dmcp = DriverManagerConnectionPool.getIstance(); }

    @Override
    public void doSave(Prodotto prodotto) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + ProdottoModel.TABLE_NAME +  "(codiceTel, marca, nome, descrizione, prezzo, quantita, foto) VALUES (?,?,?,?,?,?,?)" ;

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setInt(1,prodotto.getCodiceTel());
            preparedStatement.setString(2,prodotto.getMarca() );
            preparedStatement.setString(3, prodotto.getNome());
            preparedStatement.setString(4, prodotto.getDescrizione());
            preparedStatement.setDouble(5, prodotto.getPrezzo());
            preparedStatement.setInt(6,prodotto.getQuantita());
            preparedStatement.setString(7, prodotto.getFoto());
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
        int result = 0;

        String deleteSQL = "DELETE FROM " + ProdottoModel.TABLE_NAME +" WHERE codiceTel = ?";

        try{
            connection = dmcp.getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.setInt(1, key);
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
    public Prodotto doRetrieveByKey(Integer key) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        Prodotto p = new Prodotto();

        String selectSQL = "SELECT * FROM " + ProdottoModel.TABLE_NAME + " WHERE codiceTel = ?";

        try{
            connection = dmcp.getConnection();
            ps= connection.prepareStatement(selectSQL);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                p.setMarca(rs.getString(2));
                p.setNome(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getDouble(5));
                p.setQuantita(rs.getInt(6));

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

    public ArrayList<Prodotto> doRetrieveByCat(String cat)throws SQLException{
        try(Connection connection = dmcp.getConnection()){
            String selectSQL = "SELECT * FROM " + ProdottoModel.TABLE_NAME +" WHERE marca= ?";
            PreparedStatement ps = connection.prepareStatement(selectSQL);
            ps.setString(1,cat);
            ResultSet rs = ps.executeQuery();

            ArrayList<Prodotto> prodotti = new ArrayList<>();
            while(rs.next()){
                Prodotto p = new Prodotto();
                p.setCodiceTel(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setNome(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getDouble(5));
                p.setQuantita(rs.getInt(6));
                p.setFoto(rs.getString(7));
                p.setCategorie(getCategorie(connection,p.getCodiceTel()));
                prodotti.add(p);
            }

            return prodotti;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Prodotto> doRetrieveBySrch(String srch)throws SQLException{
        try(Connection connection = dmcp.getConnection()){
            String selectSQL = "SELECT * FROM " + ProdottoModel.TABLE_NAME + " WHERE descrizione LIKE ?";
            PreparedStatement ps = connection.prepareStatement(selectSQL);
            ps.setString(1,"%"+srch+"%");
            ResultSet rs = ps.executeQuery();

            ArrayList<Prodotto> prodotti = new ArrayList<>();
            while(rs.next()){
                Prodotto p = new Prodotto();
                p.setCodiceTel(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setNome(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getDouble(5));
                p.setQuantita(rs.getInt(6));
                p.setFoto(rs.getString(7));
                p.setCategorie(getCategorie(connection,p.getCodiceTel()));
                prodotti.add(p);
            }

            return prodotti;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Prodotto> doRetrieveAll() throws SQLException {
        try(Connection connection = dmcp.getConnection()){
            String selectSQL = "SELECT * FROM " + ProdottoModel.TABLE_NAME;
            PreparedStatement ps = connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Prodotto> prodotti = new ArrayList<>();
            while(rs.next()){
                Prodotto p = new Prodotto();
                p.setCodiceTel(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setNome(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getDouble(5));
                p.setQuantita(rs.getInt(6));
                p.setFoto(rs.getString(7));
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

    public synchronized boolean doUpdate(Prodotto item) throws SQLException {
        Connection connection= null;
        PreparedStatement ps= null;
        String updateSQL= "UPDATE "+ ProdottoModel.TABLE_NAME + " SET "+ " prezzo=?, quantita=?";
        int result=0;
        try{
            connection= dmcp.getConnection();
            ps=connection.prepareStatement(updateSQL);
            ps.setDouble(1,item.getPrezzo());
            ps.setInt(2,item.getQuantita());
            result = ps.executeUpdate();
        }finally {
            try {
                if (ps != null)
                    ps.close();
            } finally {
                dmcp.releaseConnection(connection);
                }
            }
        return (result != 0);
        }
}
