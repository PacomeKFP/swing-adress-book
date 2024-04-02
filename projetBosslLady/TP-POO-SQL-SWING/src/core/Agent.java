
package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Agent  extends Contact {
    
    public enum Statut{
        Temporaire,
        Stagiaire,
        Permanent
    }
    
    private int salaire;
    private Statut statut;
    private String categorie;
    private int indiceSalaire;
    private String occupation;

    public Agent(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber, int salaire, Statut statut, String categorie, int indiceSalaire, String occupation) throws IllegalArgumentException{
        super(code, nom, dateDeNaissance, address, email, telNumber);
        
        if (statut == null || categorie.equals("") || occupation.equals("") || indiceSalaire < 0)
                throw new IllegalArgumentException("erreur, mauvais parametres dans l'appel au constructeur Agent");
        
        this.salaire = salaire;
        this.statut = statut;
        this.categorie = categorie;
        this.indiceSalaire = indiceSalaire;
        this.occupation = occupation;
    }
    
    @Override
    public void insererContact(Connection connection){
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Agent (code, nom, date_naissance, adresse, email, tel_number, salaire, statut, categorie, indice_salaire, occupation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            // converting date 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
            String[] values = {this.code, this.nom, format.format(this.dateDeNaissance), this.address, this.email, this.telNumber, Integer.toString(this.salaire), this.statut.name(), this.categorie, Integer.toString(this.indiceSalaire), this.occupation};
            statement.execute(query, values);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getIndiceSalaire() {
        return indiceSalaire;
    }

    public void setIndiceSalaire(int indiceSalaire) {
        this.indiceSalaire = indiceSalaire;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println(" " + this.categorie + " " + this.occupation + " " + this.indiceSalaire + " " + this.salaire + " " + this.statut.name());
    }
}
