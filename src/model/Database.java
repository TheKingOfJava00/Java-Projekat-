package model;

import observer.Observable;
import observer.Observer;

import java.util.ArrayList;

public class Database extends Observable implements Observer {

    private ArrayList<Zaposleni> zaposleni = new ArrayList<>();
    private ArrayList<Softver> softveri = new ArrayList<>();
    private ArrayList<Cetkica> cetkice = new ArrayList<>();
    private ArrayList<Render> renderi = new ArrayList<>();


    public Database() {

    }

    @Override
    public void update(Object notification) {
        notifyObservers(notification);
    }

    public boolean addZaposleni(Zaposleni zaposleni) {
        if (!this.zaposleni.contains(zaposleni)) {
            this.zaposleni.add(zaposleni);
            notifyObservers(this);
            return true;
        }
        return false;
    }

    public boolean addSoftver(Softver softver) {
        if (!this.softveri.contains(softver)) {
            this.softveri.add(softver);
            notifyObservers(this);
            return true;
        }
        return false;
    }

    public void deleteZaposleni(String jmbg) {
        Zaposleni z = findZaposleni(jmbg);
        this.zaposleni.remove(z);
        notifyObservers(this);
    }

    public void deleteSoftver(String naziv) {
        Softver s = findSoftver(naziv);
        this.softveri.remove(s);
        notifyObservers(this);
    }

    public Zaposleni findZaposleni(String jmbg) {
        for (Zaposleni z: zaposleni) {
            if (z.getJmbg().equals(jmbg)) {
                return z;
            }
        }
        return null;
    }

    public Softver findSoftver(String naziv) {
        for (Softver s: softveri) {
            if (s.getNaziv().equals(naziv)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Zaposleni> getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(ArrayList<Zaposleni> zaposleni) {
        this.zaposleni = zaposleni;
    }

    public ArrayList<Softver> getSoftveri() {
        return softveri;
    }

    public void setSoftveri(ArrayList<Softver> softveri) {
        this.softveri = softveri;
    }

    public ArrayList<Cetkica> getCetkice() {
        return cetkice;
    }

    public ArrayList<Render> getRenderi() {
        return renderi;
    }

    public void setRenderi(ArrayList<Render> renderi) {
        this.renderi = renderi;
    }

    public void setCetkice(ArrayList<Cetkica> cetkice) {
        this.cetkice = cetkice;
    }
}
