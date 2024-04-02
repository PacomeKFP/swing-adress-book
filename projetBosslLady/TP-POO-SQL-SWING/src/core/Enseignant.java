package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Enseignant extends Contact {
    
    public enum Statut {
        Vacataire,
        Permanent
    }
    
    private Statut statut;

    public Enseignant(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber, Statut statut) throws IllegalArgumentException{
        super(code, nom, dateDeNaissance, address, email, telNumber);
        
        if(statut == null)
            throw new IllegalArgumentException("erreur, mauvais parametres dans l'appel au contructeur Enseignant");
        
        this.statut = statut;
    }

    @Override
    public void insererContact(Connection connection){
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Enseignant (code, nom, date_naissance, adresse, email, tel_number, statut) VALUES (?, ?, ?, ?, ?, ?, ?);";
            // converting date 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
            String[] values = {this.code, this.nom, format.format(this.dateDeNaissance), this.address, this.email, this.telNumber, this.statut.name()};
            statement.execute(query, values);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println(" " + this.statut);
    }
}
