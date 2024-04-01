package core.helpers.utils;

public class ErrorMessages {
    public static String SQLErrorMessage = "Une erreur est survenue lors de la tentative de connexion à la base de donnée.\n" +
            "1.  Assurez vous d'avoir le pilote JDBC pour MySQL \n" +
            "2.  Assurez vous d'avoir lancé le serveur de base de donnée\n" +
            "3.  S'il est lancé sur un port autre que le port 3306 veuillez preciser le port en argument\n" +
            "\n\n" +
            "L'application se refermera, et ne marchera que lorsque ce probleme sera réglé.";

    public static String InvalidArgsErrorMessage = "L'argument entré est invalide. Il devrait etre un entier representant " +
            "Le port sur lequel est lancé le serveur de base de donnée" +
            "L'application sera lancée avec le port 3306 par defaut";
}
