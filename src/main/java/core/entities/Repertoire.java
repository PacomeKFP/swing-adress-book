/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.entities;

import core.helpers.enums.ChampRechercheEnum;
import core.helpers.tools.Levenshtein;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * @author pacome
 */
public class Repertoire {
    private List<Contact> contacts;

    public Repertoire() {
        this.contacts = new ArrayList<>();
    }

    /**
     * @return the contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    public void ajouterContact(Contact contact) {
        contacts.add(contact);
    }

    public int size(){
        return contacts.size();
    }

    public void supprimerContact(String code) {
        contacts.removeIf(contact -> contact.getCode().equals(code));
    }

    public void modifierContact(String code, Contact newContact) {
        contacts.stream().forEach(contact -> {
            if (contact.getCode().equals(code)) {

                switch (contact.getClass().toString()) {
                    case "class core.entities.Enseignant" -> contact.modifier((Enseignant) newContact);
                    case "class core.entities.Etudiant" -> contact.modifier((Etudiant) newContact);
                    case "class core.entities.Agent" -> contact.modifier((Agent) newContact);
                    default -> contact.modifier(newContact);
                }
            }
        });
    }


    /**
     * Cette methode permet de rechercher un contact en ce servant de d'un champ et de sa valeur
     * Nous utiliseront la distance de <b>Levenshtein</b> pour ne pas chercher
     * le contact avec la valeur strictement égale, mais les contact dont la valeur specifiée pour le champ
     * est le plus similaire selon la distance de Leverstein
     * Ceci permettra de faire des recherches efficaces meme si on ne connait pas la valeur exacte qu'on cherche
     *
     * @param champ le champ sur lequel on effectue la recherche
     * @param value la valeur recheerchée
     * @param limit Le nombre maximal d'elements qu'on veut.
     *              Si la valeur est INTEGER.MIN_VALUE alors, on fera une comparaison stricte sans usage de distance
     *              Si la valeur est invalide (negative ou nulle) on utilisera 10 par defaut
     * @return
     */
    public List<Contact> rechercherContact(ChampRechercheEnum champ, String value, int limit) {

        if (limit == Integer.MIN_VALUE)
            return contacts.stream().filter(contact -> contact.getValeurChamp(champ).equals(value)).toList();


        return contacts.stream()
                .sorted((contact1, contact2) -> {
                            double d1 = Levenshtein.distance(contact1.getValeurChamp(champ), value);
                            double d2 = Levenshtein.distance(contact2.getValeurChamp(champ), value);
                            return Double.compare(d1, d2);
                        }
                )
                .limit(limit <= 0 ? 10 : limit).toList();
    }

    public void sort(ChampRechercheEnum champ) {
        contacts = contacts
                .stream()
                .sorted(Comparator.comparing(c -> c.getValeurChamp(champ)))
                .toList();
    }


}
