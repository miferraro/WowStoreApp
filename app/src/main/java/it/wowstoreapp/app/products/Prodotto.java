package it.wowstoreapp.app.products;

/**
 * Created by user01 on 23/05/2016.
 */
public class Prodotto {

    public int id;
    public String modello;
    public String marchio;
    public double prezzo;
    public String descrizione;
    public String foto;
    public String tabella;

    public String getModello() {
        return modello;
    }

    public String getMarchio() {
        return marchio;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setMarchio(String marchio) {
        this.marchio = marchio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTabella() {
        return tabella;
    }

    public void setTabella(String tabella) {
        this.tabella = tabella;
    }
}
