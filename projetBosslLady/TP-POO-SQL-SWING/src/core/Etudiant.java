package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Etudiant extends Contact{
    
    public enum Cycle {
        Licence,
        Ingenieur
    }
    
    private String niveau;
    private Cycle cycle;

    public Etudiant(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber, String niveau, Cycle cycle) throws IllegalArgumentException{
        super(code, nom, dateDeNaissance, address, email, telNumber);
        
        if (niveau.equals("") || cycle == null)
            throw new IllegalArgumentException("erreur, mauvais parametres dans l'appel au contructeur contact");
        
        this.niveau = niveau;
        this.cycle = cycle;
    }
    
    @Override
    public void insererContact(Connection connection){
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Etudiant (code, nom, date_naissance, adresse, email, tel_number, cycle, niveau) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            // converting date 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
            String[] values = {this.code, this.nom, format.format(this.dateDeNaissance), this.address, this.email, this.telNumber, this.cycle.name(), this.niveau};
            statement.execute(query, values);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println(" " + this.niveau + " " + this.cycle.name());
    }
}
