/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.entities;

import core.helpers.enums.ChampRechercheEnum;

import java.sql.Date;

/**
 * @author pacome
 */
public abstract class Contact {

    private String code;
    private String nom;
    private Date dateNaissance;
    private String address;
    private String email;
    private String telNumber;

    public Contact() {
    }

    public Contact(String code, String nom, Date dateNaissance, String address, String email, String telNumber) {
        this.code = code;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.address = address;
        this.email = email;
        this.telNumber = telNumber;
    }


    protected void modifier(Contact contact) {
        this.nom = contact.getNom();
        this.dateNaissance = contact.getDateNaissance();
        this.address = contact.getAddress();
        this.email = contact.getEmail();
        this.telNumber = contact.getTelNumber();
    }


    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telNumber
     */
    public String getTelNumber() {
        return telNumber;
    }

    /**
     * @param telNumber the telNumber to set
     */
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }


    /**
     * @param champ l'enum qui correspond au champ (attribut) dont on veut la valeu
     * @return
     * @implNote Permet d'acceder à la valeur d'un champ de la classe, grace à un enum le representant
     * Ceci est particulierement utile dans la recherche dans un repertoire
     */
    public String getValeurChamp(ChampRechercheEnum champ) {
        return switch (champ) {
            case CODE -> this.code;
            case ADRESSE -> this.address;
            case EMAIL -> this.email;
            case TEL_NUMBER -> this.telNumber;
            default -> this.nom;
        };
    }
}
