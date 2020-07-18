package models.dao;

public class User {
    private long idUser;
    private String lastName;
    private String firstName;
    private String email;
    private String parola;
    private String adresa;

    public User(long idUser, String lastName, String firstName, String email, String parola, String adresa) {
        this.idUser = idUser;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.parola = parola;
        this.adresa = adresa;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idAdmin) {
        this.idUser = idUser;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
