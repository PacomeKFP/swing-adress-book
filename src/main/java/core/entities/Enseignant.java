/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.entities;

import core.helpers.enums.StatutEnseignantEnum;
import core.helpers.utils.EnumsBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pacome
 */
public class Enseignant extends Contact{
    private StatutEnseignantEnum statut;

    public Enseignant() {
    }

    public Enseignant(StatutEnseignantEnum statut, String code, String nom, Date dateNaissance, String address, String email, String telNumber) {
        super(code, nom, dateNaissance, address, email, telNumber);
        this.statut = statut;
    }

    public Enseignant(Enseignant enseignant) {
        super(enseignant.getCode() + "-copy" + (int) (Math.random() * 50) % 50, enseignant.getNom(), enseignant.getDateNaissance(), enseignant.getAddress(), enseignant.getEmail(), enseignant.getTelNumber());
        this.statut = enseignant.statut;
    }

    public Enseignant(Enseignant enseignant, String code) {
        super(code, enseignant.getNom(), enseignant.getDateNaissance(), enseignant.getAddress(), enseignant.getEmail(), enseignant.getTelNumber());
        this.statut = enseignant.statut;
    }

    public void modifier(Enseignant nouvelEnseignant) {
        super.modifier((Contact) nouvelEnseignant);
        statut = nouvelEnseignant.statut;
    }

    /**
     * @return the statut
     */
    public StatutEnseignantEnum getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(StatutEnseignantEnum statut) {
        this.statut = statut;
    }



}
