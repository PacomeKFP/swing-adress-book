/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.entities;

import core.helpers.enums.CycleEnum;
import core.helpers.utils.EnumsBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pacome
 */
public class Etudiant extends Contact {

    private CycleEnum cycle;
    private String niveau;

    public Etudiant(){}

    public Etudiant(CycleEnum cycle, String code, String nom, Date dateNaissance, String address, String email, String telNumber, String niveau) {
        super(code, nom, dateNaissance, address, email, telNumber);
        this.cycle = cycle;
        this.niveau = niveau;
    }


    public void modifier(Etudiant nouvelEtudiant) {
        super.modifier(nouvelEtudiant);
        this.cycle = nouvelEtudiant.getCycle();
        this.niveau = nouvelEtudiant.getNiveau();
    }

    /**
     * @return the cycle
     */
    public CycleEnum getCycle() {
        return cycle;
    }

    /**
     * @param cycle the cycle to set
     */
    public void setCycle(CycleEnum cycle) {
        this.cycle = cycle;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }



}
