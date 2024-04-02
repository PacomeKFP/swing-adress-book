/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aku.adressbook;

import core.entities.Contact;
import core.entities.Enseignant;
import core.entities.Etudiant;
import core.entities.Repertoire;
import core.helpers.enums.ChampRechercheEnum;
import core.helpers.enums.CycleEnum;
import core.helpers.enums.StatutEnseignantEnum;
import core.helpers.tools.Database;
import core.repositories.EtudiantRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @author pacome
 */
public class AdressBook {

    public static void main1(String[] args) {
        Repertoire repertoire = new Repertoire();
        Contact teacher = new Enseignant(
                StatutEnseignantEnum.PERMANENT,
                "code-1", "Teacher 1",
                (Date) Date.from(Instant.now()),
                "adresse",
                "email",
                "690");
        repertoire.ajouterContact(teacher);
        repertoire.ajouterContact(new Enseignant((Enseignant) teacher, "le codage"));
        repertoire.ajouterContact(new Enseignant((Enseignant) teacher, "pharac"));
        repertoire.ajouterContact(new Enseignant((Enseignant) teacher, "coderie"));
        repertoire.ajouterContact(new Enseignant((Enseignant) teacher, "ecod"));
        repertoire.ajouterContact(new Enseignant((Enseignant) teacher, "cod"));
        repertoire.ajouterContact(new Enseignant((Enseignant) teacher));
        repertoire.rechercherContact(ChampRechercheEnum.CODE, "cod", Integer.MIN_VALUE).stream().forEach(contact -> System.out.println(contact.getNom()));


        System.out.println(teacher.getClass());

        Enseignant t2 = new Enseignant((Enseignant) teacher, "yo");
        t2.setNom("Pacome");
        t2.setAddress("Londres");
        t2.setStatut(StatutEnseignantEnum.VACATAIRE);
        repertoire.modifierContact("cod", t2);
        repertoire.rechercherContact(ChampRechercheEnum.CODE, "cod", Integer.MIN_VALUE).stream().forEach(contact -> System.out.println(contact.getNom()));

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver for MySQL loaded with success");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/adress_book", "root", "");
            System.out.println("Connexion established successfully");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur de connection à la base de donnée SQL");

        }
        if (connection == null)
            return;
        Contact etudiant = new Etudiant(
                CycleEnum.INGENIEUR,
                "2832",
                "The KFP",
                Date.valueOf(LocalDate.of(2004, 06, 29)),
                "adresse",
                "mail ici",
                "690",
                "3");

        System.out.println("Classe name" + etudiant.getClass().getName());

        try {
            Database.initializeDatabaseConnection("adress_book", "root", "", 3307);
            EtudiantRepository studentRepository = new EtudiantRepository(Database.connection);
            studentRepository.findAll()
                    .stream()
                    .forEach(etudiant1 -> System.out.println(etudiant1.getNiveau() + ' ' + etudiant1.getNom() + ' ' + etudiant1.getCycle()));
        } catch (SQLException e) {
            System.err.println("Error on saving");
            e.printStackTrace();
        }
    }
}
