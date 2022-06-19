package model;

import java.util.ArrayList;

public class Render {

    private String naziv;
    private ArrayList<String> materijali = new ArrayList<>();
    private ArrayList<String> kamere = new ArrayList<>();
    private String svetlo;
    private ArrayList<String> objekti;

    public Render(String naziv, ArrayList<String> materijali, ArrayList<String> kamere, String svetlo, ArrayList<String> objekti) {
        this.naziv = naziv;
        this.materijali = materijali;
        this.kamere = kamere;
        this.svetlo = svetlo;
        this.objekti = objekti;
    }

    public Render() {

    }

    @Override
    public String toString() {
        return naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ArrayList<String> getMaterijali() {
        return materijali;
    }

    public void setMaterijali(ArrayList<String> materijali) {
        this.materijali = materijali;
    }

    public ArrayList<String> getKamere() {
        return kamere;
    }

    public void setKamere(ArrayList<String> kamere) {
        this.kamere = kamere;
    }

    public String getSvetlo() {
        return svetlo;
    }

    public void setSvetlo(String svetlo) {
        this.svetlo = svetlo;
    }

    public ArrayList<String> getObjekti() {
        return objekti;
    }

    public void setObjekti(ArrayList<String> objekti) {
        this.objekti = objekti;
    }
}
