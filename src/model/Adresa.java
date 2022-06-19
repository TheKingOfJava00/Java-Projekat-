package model;

public class Adresa {

    private int broj;
    private String ulica;
    private String grad;

    public Adresa(int broj, String ulica, String grad) {
        this.broj = broj;
        this.ulica = ulica;
        this.grad = grad;
    }

    public Adresa() {
    }

    @Override
    public String toString() {
        return ulica + " " + broj + ", " + grad;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }
}
