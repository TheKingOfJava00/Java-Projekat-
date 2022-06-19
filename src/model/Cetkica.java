package model;

import java.util.Objects;

public class Cetkica {

    private String naziv;
    private String namena;
    private String boja;

    public Cetkica(String naziv, String namena, String boja) {
        this.naziv = naziv;
        this.namena = namena;
        this.boja = boja;
    }

    @Override
    public String toString() {
        return naziv + " cetkica " + "(" + namena + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cetkica cetkica = (Cetkica) o;
        return Objects.equals(boja, cetkica.boja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boja);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNamena() {
        return namena;
    }

    public void setNamena(String namena) {
        this.namena = namena;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }
}
