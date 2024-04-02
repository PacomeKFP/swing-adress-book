package core.repositories;

import core.entities.Etudiant;
import core.helpers.tools.EnumsBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantRepository extends ContactRepository<Etudiant> {

    public EtudiantRepository(Connection connection) {
        super(connection);
    }

    @Override
    public void save(Etudiant etudiant) throws SQLException {

        String sqlQuery = "INSERT INTO `etudiant`(`code`, `nom`, `email`, `telephone`, `adresse`, `date_naissance`, `cycle`, `niveau`)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = this.initilizePreparedStatement(sqlQuery, etudiant);
        statement.setString(7, etudiant.getCycle().name());
        statement.setString(8, etudiant.getNiveau());

        statement.execute();
    }


    @Override
    public List<Etudiant> findAll() throws SQLException {
        ResultSet resultSet = getConnection().prepareStatement("select * from etudiant").executeQuery();
        List<Etudiant> etudiants = new ArrayList<>();
        while (resultSet.next())
            etudiants.add(this.fromResultSet(resultSet));

        return etudiants;
    }


    @Override
    public void update(String code, Etudiant etudiant) throws SQLException {
        PreparedStatement statement = super.initilizePreparedStatement(code, etudiant);
        statement.setString(7, etudiant.getCycle().name());
        statement.setString(8, etudiant.getNiveau());
        statement.execute();
    }

    @Override
    public void delete(String code) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("DELETE FROM etudiant WHERE code = ?");
        statement.setString(1, code);
        statement.execute();
    }

    private Etudiant fromResultSet(ResultSet resultSet) throws SQLException {
        Etudiant contact = new Etudiant();
        if (!super.fromResultSet(resultSet, contact))
            return null;
        contact.setCycle(EnumsBuilder.cycleEnumFromString(resultSet.getString("cycle")));
        contact.setNiveau(resultSet.getString("niveau"));
        return contact;
    }
}
