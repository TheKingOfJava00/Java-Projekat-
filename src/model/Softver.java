package model;

import java.util.ArrayList;

public class Softver {

    private String naziv;
    private ArrayList<Cetkica> cetkice = new ArrayList<>();
    private ArrayList<String> modifikatori = new ArrayList<>();
    private ArrayList<String> formatiFajla = new ArrayList<>();
    private ArrayList<String> animationTools = new ArrayList<>();
    private Render render;

    public Softver(String naziv, ArrayList<Cetkica> cetkice, ArrayList<String> modifikatori, ArrayList<String> formatiFajla, ArrayList<String> animationTools, Render render) {
        this.naziv = naziv;
        this.cetkice = cetkice;
        this.modifikatori = modifikatori;
        this.formatiFajla = formatiFajla;
        this.animationTools = animationTools;
        this.render = render;
    }

    public Softver() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Softver softver = (Softver) o;
        return naziv.equals(softver.naziv);
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
        notifyObservers(this);
    }

    public ArrayList<Cetkica> getCetkice() {
        return cetkice;
    }

    public void setCetkice(ArrayList<Cetkica> cetkice) {
        this.cetkice = cetkice;
    }

    public ArrayList<String> getModifikatori() {
        return modifikatori;
    }

    public void setModifikatori(ArrayList<String> modifikatori) {
        this.modifikatori = modifikatori;
    }

    public ArrayList<String> getFormatiFajla() {
        return formatiFajla;
    }

    public void setFormatiFajla(ArrayList<String> formatiFajla) {
        this.formatiFajla = formatiFajla;
    }

    public ArrayList<String> getAnimationTools() {
        return animationTools;
    }

    public void setAnimationTools(ArrayList<String> animationTools) {
        this.animationTools = animationTools;
    }

    public Render getRender() {
        return render;
    }

    public void setRender(Render render) {
        this.render = render;
    }
}
