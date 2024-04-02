package core.repositories;

import core.entities.Agent;
import core.helpers.tools.EnumsBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentRepository extends ContactRepository<Agent> {

    public AgentRepository(Connection connection) {
        super(connection);
    }

    private Agent fromResultSet(ResultSet resultSet) throws SQLException {
        Agent agent = new Agent();
        if (!super.fromResultSet(resultSet, agent))
            return null;
        agent.setStatut(EnumsBuilder.statutAgentEnumFromString(resultSet.getString("statut")));
        agent.setSalaire(resultSet.getFloat("salaire"));
        agent.setCategorie(resultSet.getString("categorie"));
        agent.setIndiceSalaire(resultSet.getString("indice_salaire"));
        agent.setOccupation(resultSet.getString("occupation"));
        return agent;
    }

    @Override
    public void save(Agent agent) throws SQLException {
        String sqlQuery = "INSERT INTO `agent`(`code`, `nom`, `email`, `telephone`, `adresse`, `date_naissance`, `statut`, `salaire`, `categorie`, `indice_salaire`, `occupation`)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?)";
        PreparedStatement statement = super.initilizePreparedStatement(sqlQuery, agent);
        statement.setString(7, agent.getStatut().name());
        statement.setDouble(8, agent.getSalaire());
        statement.setString(9, agent.getCategorie());
        statement.setString(10, agent.getIndiceSalaire());
        statement.setString(11, agent.getOccupation());

        statement.execute();
    }

    @Override
    public List<Agent> findAll() throws SQLException {
        ResultSet resultSet = this.getConnection().prepareStatement("select * from agent").executeQuery();
        List<Agent> agents = new ArrayList<>();
        while (resultSet.next())
            agents.add(this.fromResultSet(resultSet));

        return agents;
    }


        @Override
    public void update(String code, Agent agent) throws SQLException {
        PreparedStatement statement = super.initilizePreparedStatement(code, agent);
        statement.setString(7, agent.getStatut().name());
        statement.setDouble(8, agent.getSalaire());
        statement.setString(9, agent.getCategorie());
        statement.setString(10, agent.getIndiceSalaire());
        statement.setString(11, agent.getOccupation());

        statement.execute();
    }
    @Override
    public void delete(String code) throws SQLException {
        PreparedStatement statement = this.getConnection().prepareStatement("DELETE FROM agent WHERE code = ?");
        statement.setString(1, code);
        statement.execute();
    }


}
