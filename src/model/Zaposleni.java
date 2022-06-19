package model;

import observer.Observable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Zaposleni extends Observable {

    private String ime;
    private String prezime;
    private String jmbg;
    private LocalDate datumRodjenja;
    private String email;
    private Adresa adresa;
    private RadnoMesto radnoMesto;
    private ArrayList<Softver> softveri;


    public Zaposleni(String ime, String prezime, String jmbg, LocalDate datumRodjenja, String email, Adresa adresa, RadnoMesto radnoMesto, ArrayList<Softver> softveri) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.adresa = adresa;
        this.radnoMesto = radnoMesto;
        this.softveri = softveri;
    }

    public Zaposleni() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zaposleni zaposleni = (Zaposleni) o;
        return jmbg.equals(zaposleni.jmbg);
    }

    @Override
    public String toString() {
        return "Zaposleni{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", email='" + email + '\'' +
                ", adresa=" + adresa +
                ", radnoMesto=" + radnoMesto +
                ", softveri=" + softveri +
                '}';
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
        notifyObservers(this);
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
        notifyObservers(this);
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
        notifyObservers(this);
    }

    // https://www.baeldung.com/java-date-without-time
    public String getDatumRodjenja() {
        return datumRodjenja.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
        notifyObservers(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyObservers(this);
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
        notifyObservers(this);
    }

    public RadnoMesto getRadnoMesto() {
        return radnoMesto;
    }

    public void setRadnoMesto(RadnoMesto radnoMesto) {
        this.radnoMesto = radnoMesto;
        notifyObservers(this);
    }

    public ArrayList<Softver> getSoftveri() {
        return softveri;
    }

    public ArrayList<String> getSoftveriForTable() {
        ArrayList<String> res = new ArrayList<>();
        for (Softver s: softveri) {
            res.add(s.getNaziv());
        }
        return res;
    }

    public void setSoftveri(ArrayList<Softver> softveri) {
        this.softveri = softveri;
        notifyObservers(this);
    }
}
