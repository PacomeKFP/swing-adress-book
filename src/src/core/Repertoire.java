package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

public class Repertoire  {

    private final ArrayList<Contact> repertoire;

    public Repertoire() {
        repertoire = new ArrayList<>();
    }

    public void ajouterContact(Contact contact) throws IllegalArgumentException{
        String code = contact.getCode();
        for (Contact _contact : this.repertoire) {
            if (_contact.getCode().equalsIgnoreCase(code)){
                throw new IllegalArgumentException("Erreur, un contact avec le code " + code + " exste déja dans le répertoire  ");
            }
        }
        
        this.repertoire.add(contact);
    }

    public void SupprimerContact(String code) throws IllegalArgumentException {
        Iterator<Contact> it = this.repertoire.iterator();
        while (it.hasNext()) {
            if (it.next().getCode().equalsIgnoreCase(code)) {
                it.remove();
                return;
            }
        }

        throw new IllegalArgumentException("error, the contact with code : " + code + " was not found for deleting");
    }

    private void modifierContact(Contact contact, String nom, Date dateDeNaissance, String address, String email, String telNumber) {
        // base parameters
        contact.setDateDeNaissance(dateDeNaissance);
        contact.setEmail(email);
        contact.setTelNumber(telNumber);
        contact.setNom(nom);
        contact.setAddress(address);
    }

    public void modifierContact(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber, String niveau, Etudiant.Cycle cycle) throws IllegalArgumentException {
        for (Contact contact : this.repertoire) {
            if (contact instanceof Etudiant etudiant) {
                if (contact.getCode().equalsIgnoreCase(code)) {
                    // base parameters
                    this.modifierContact(contact, nom, dateDeNaissance, address, email, telNumber);

                    // specif parameters
                    etudiant.setNiveau(niveau);
                    etudiant.setCycle(cycle);
                    return;
                }
            }
        }

        throw new IllegalArgumentException("error, the contact with code : " + code + " was not found for modifications");
    }

    public void modifierContact(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber, Enseignant.Statut statut) throws IllegalArgumentException {
        for (Contact contact : this.repertoire) {
            if (contact instanceof Enseignant enseignant) {
                if (contact.getCode().equalsIgnoreCase(code)) {
                    // base parameters
                    this.modifierContact(contact, nom, dateDeNaissance, address, email, telNumber);

                    // specif parameters
                    enseignant.setStatut(statut);
                    return;
                }
            }
        }

        throw new IllegalArgumentException("error, the contact with code : " + code + " was not found for modification");
    }

    public void modifierContact(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber, int salaire, Agent.Statut statut, String categorie, int indiceSalaire, String occupation) throws IllegalArgumentException {
        for (Contact contact : this.repertoire) {
            if (contact instanceof Agent agent) {
                if (contact.getCode().equalsIgnoreCase(code)) {
                    // base parameters
                    this.modifierContact(contact, nom, dateDeNaissance, address, email, telNumber);

                    // specif parameters
                    agent.setCategorie(categorie);
                    agent.setIndiceSalaire(indiceSalaire);
                    agent.setOccupation(occupation);
                    agent.setSalaire(salaire);
                    agent.setStatut(statut);
                    return;
                }
            }
        }

        throw new IllegalArgumentException("error, the contact with code : " + code + " was not found for modification");
    }
    
    public Contact rechercherContact(String code) throws IllegalArgumentException{
        for (Contact contact : this.repertoire){
            if (contact.getCode().equalsIgnoreCase(code)){
                return contact;
            }
        }
        throw new IllegalArgumentException("error, the contact with code : "+ code +" was not found");
    }
    
    public List<Contact> getRepertoire() {
        return Collections.unmodifiableList(repertoire);
    }
    
    public void afficherRepertoire(){
        for (Contact contact : this.repertoire){
            if (contact instanceof Etudiant etudiant){
                etudiant.print();
            } else if (contact instanceof Enseignant enseignant){
                enseignant.print();
            } else if (contact instanceof Agent agent){
                agent.print();
            }
        }
    }
}
