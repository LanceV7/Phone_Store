package model;

import java.util.List;
import java.util.Objects;

public class Prodotto {
    private int codiceTel;
    private String marca;
    private String nome;
    private String descrizione;
    private double prezzo;
    private int quantita;
    private String foto;
    private List<Categoria> categorie;

    public Prodotto() {
    }

    public Prodotto(int codiceTel, String marca,String nome, String descrizione, double prezzo, int quantita, List<Categoria> categorie, String foto) {
        this.codiceTel = codiceTel;
        this.marca = marca;
        this.nome=nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.categorie = categorie;
        this.foto=foto;
    }

    public int getCodiceTel() {
        return codiceTel;
    }

    public void setCodiceTel(int codiceTel) {
        this.codiceTel = codiceTel;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome(){return nome;}

    public void setNome(String nome) {this.nome=nome;}

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public List<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(List<Categoria> categorie) {
        this.categorie = categorie;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return codiceTel == prodotto.codiceTel &&
                Double.compare(prodotto.prezzo, prezzo) == 0 &&
                quantita == prodotto.quantita &&
                Objects.equals(marca, prodotto.marca) &&
                Objects.equals(descrizione, prodotto.descrizione) &&
                Objects.equals(categorie, prodotto.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceTel, marca, descrizione, prezzo, quantita, categorie);
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "codiceTel=" + codiceTel +
                ", marca='" + marca + '\'' +
                ", nome="+ nome+ '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", quantita=" + quantita +
                ", categorie=" + categorie +
                '}';
    }
}
