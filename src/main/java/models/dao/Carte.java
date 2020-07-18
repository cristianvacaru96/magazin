package models.dao;

public class Carte {
    private long idCarte;
    private String titlu;
    private String autori;
    private String isbn;
    private int anCarte;
    private String editura;

    public Carte (){
    }

    public Carte(long idCarte, String titlu, String autori, String isbn, int anCarte, String editura) {
        this.idCarte = idCarte;
        this.titlu = titlu;
        this.autori = autori;
        this.isbn = isbn;
        this.anCarte = anCarte;
        this.editura = editura;
    }


    public long getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(long idCarte) {
        this.idCarte = idCarte;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutori() {
        return autori;
    }

    public void setAutori(String autori) {
        this.autori = autori;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnCarte() {
        return anCarte;
    }

    public void setAnCarte(int anCarte) {
        this.anCarte = anCarte;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }
}
