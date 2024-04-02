package core.repositories;

import core.entities.Contact;
import core.helpers.tools.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ContactRepository<E> implements Repository<E>{

    private final Connection connection;

    public ContactRepository() {
        connection = Database.connection;
    }

    public ContactRepository(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    protected PreparedStatement initilizePreparedStatement(String sqlQuery, Contact contact) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setString(1, contact.getCode());
        statement.setString(2, contact.getNom());
        statement.setString(3, contact.getEmail());
        statement.setString(4, contact.getTelNumber());
        statement.setString(5, contact.getAddress());
        statement.setDate(6, contact.getDateNaissance());

        return statement;
    }

    /**
     * Permet de construire un objet à partir d'une ligne de resultat d'une requette
     * Cette methode servira d'utilitaire poour les factories des classes enfant.
     * Elle permettra de construire plus facilement un objet de type Enseignant, Eleve, ou Agent
     * en reduisant la replication de code.
     *
     * @param resultSet le result set à partir duquel on travaille
     * @param contact   l'objet qui va stocker les valeurs extraite de la ligne de resultat
     * @return true si tout s'est bien passé et false si le result set est en fin de liste
     * @throws SQLException
     */
    protected boolean fromResultSet(ResultSet resultSet, Contact contact) throws SQLException {
        if (resultSet.isAfterLast())
            return false;

        contact.setCode(resultSet.getString("code"));
        contact.setNom(resultSet.getString("nom"));
        contact.setAddress(resultSet.getString("adresse"));
        contact.setEmail(resultSet.getString("email"));
        contact.setTelNumber(resultSet.getString("telephone"));
        contact.setDateNaissance(resultSet.getDate("date_naissance"));

        return true;

    }
}
