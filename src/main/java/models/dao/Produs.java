package models.dao;

public class Produs {
    private long idProdus;
    private String name;
    private String producator;
    private int pret;
    private int cantitateStoc;
    private String descriere;


        public Produs(long idProdus, String name, String producator, int pret, int cantitateStoc, String descriere) {
        this.idProdus = idProdus;
        this.name = name;
        this.producator = producator;
        this.pret = pret;
        this.cantitateStoc = cantitateStoc;
        this.descriere = descriere;
    }

    public long getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(long idProdus) {
        this.idProdus = idProdus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getCantitateStoc() {
        return cantitateStoc;
    }

    public void setCantitateStoc(int cantitateStoc) {
        this.cantitateStoc = cantitateStoc;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
