package core.helpers.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Cette classe nous permettra de gerer effcicacement la connection à la base de donnée.
 * En gardant la variable de connection statique, on s'assure qu'elle sera facilement accessible partout et en O(1)
 */
public class Database {
    public static Connection connection = null;

    public static Connection initializeDatabaseConnection(String database, String username, String password, int port) {
        if (connection != null)
            return connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver for MySQL loaded with success");
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + database, username, password);
            System.out.println("Connection à la base de donnée réussie");
            connection = dbConnection;
            return connection;
        } catch (ClassNotFoundException e) {
            // TODO: arreter l'application ici en douce
            System.out.println("JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur de connection à la base de donnée SQL");
        }

        return null;
    }
}
