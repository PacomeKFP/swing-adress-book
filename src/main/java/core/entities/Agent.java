/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.entities;

import core.helpers.enums.StatutAgentEnum;

import java.sql.Date;

/**
 * @author pacome
 */
public class Agent extends Contact {
    private float salaire;
    private StatutAgentEnum statut;
    private String categorie, indiceSalaire, occupation;

    public Agent() {
    }

    public Agent(float salaire, StatutAgentEnum statut, String categorie, String indiceSalaire, String occupation, String code, String nom, Date dateNaissance, String address, String email, String telNumber) {
        super(code, nom, dateNaissance, address, email, telNumber);
        this.salaire = salaire;
        this.statut = statut;
        this.categorie = categorie;
        this.indiceSalaire = indiceSalaire;
        this.occupation = occupation;
    }

    public void modifier(Agent nouvelAgent) {
        super.modifier(nouvelAgent);
        this.categorie = nouvelAgent.getCategorie();
        this.salaire = nouvelAgent.getSalaire();
        this.statut = nouvelAgent.getStatut();
        this.indiceSalaire = nouvelAgent.getIndiceSalaire();
        this.occupation = nouvelAgent.getOccupation();
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public StatutAgentEnum getStatut() {
        return statut;
    }

    public void setStatut(StatutAgentEnum statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getIndiceSalaire() {
        return indiceSalaire;
    }

    public void setIndiceSalaire(String indiceSalaire) {
        this.indiceSalaire = indiceSalaire;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

}
