package models.dao;

public class Admin {
    private long idAdmin;
    private String lastName;
    private String firstName;
    private String email;
    private String parola;
    private String telefon;
    private String drept;

    public Admin(){

    }
    public Admin(long idAdmin, String lastName, String firstName, String email, String parola, String telefon, String drept) {
        this.idAdmin = idAdmin;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.parola = parola;
        this.telefon = telefon;
        this.drept = drept;
    }

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDrept() {
        return drept;
    }

    public void setDrept(String drept) {
        this.drept = drept;
    }
}
