package core.repositories;

import core.entities.Enseignant;
import core.helpers.tools.EnumsBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnseignantRepository extends ContactRepository<Enseignant> {

    public EnseignantRepository(Connection connection) {
        super(connection);
    }

    @Override
    public void save(Enseignant enseignant) throws SQLException {
        String sqlQuery = "INSERT INTO `enseignant`(`code`, `nom`, `email`, `telephone`, `adresse`, `date_naissance`, `statut`) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = initilizePreparedStatement(sqlQuery, enseignant);
        statement.setString(7, enseignant.getStatut().name());
        statement.execute();
    }

    @Override
    public List<Enseignant> findAll() throws SQLException {
        ResultSet resultSet = getConnection().prepareStatement("select * from enseignant").executeQuery();
        List<Enseignant> enseignants = new ArrayList<>();
        while (resultSet.next())
            enseignants.add(this.fromResultSet(resultSet));

        return enseignants;
    }

    @Override
    public void update(String code, Enseignant enseignant) throws SQLException {
        PreparedStatement statement = initilizePreparedStatement( code, enseignant);
        statement.setString(7, enseignant.getStatut().name());
        statement.execute();
    }


    @Override
    public void delete(String code) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("DELETE FROM enseignant WHERE code = ?");
        statement.setString(1, code);
        statement.execute();
    }
    private Enseignant fromResultSet(ResultSet resultSet) throws SQLException {
        Enseignant contact = new Enseignant();
        if (!super.fromResultSet(resultSet, contact))
            return null;
        contact.setStatut(EnumsBuilder.statutEnseignantEnumFromString(resultSet.getString("statut")));

        return contact;
    }

}
