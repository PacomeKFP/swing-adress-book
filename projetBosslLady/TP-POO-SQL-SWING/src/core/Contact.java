package core;

import java.sql.*;
import java.util.Date;

/**
 *
 * @author pc
 */
public abstract class Contact {
    
    protected String code;
    protected String nom;
    protected Date dateDeNaissance;
    protected String address;
    protected String email;
    protected String telNumber;

    public Contact(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber) throws IllegalArgumentException {
        if (code.equals("") || nom.equals("") || dateDeNaissance == null || address.equals("") || email.equals("") || telNumber.equals(""))
            throw new IllegalArgumentException("erreur, mauvais parametres dans l'appel au constructeur contact");
        
        this.code = code;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.address = address;
        this.email = email;
        this.telNumber = telNumber;
    }

    public abstract void insererContact(Connection connection);
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void print(){
        System.out.print(this.code + " " + this.nom + " " + this.address + " " + this.email + " " + this.telNumber + " " + this.dateDeNaissance.toString());
    }
}
