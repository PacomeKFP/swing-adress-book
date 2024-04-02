Swing Address Book
==================

Il s'agit d'un projet academique, visant à réaliser à l'aide de Swing et JDBC, une petite application de carnet
d'adresses.
Ce projet vise à asseoir les bases de la programmation Orientée Objet en Java tout en verifaint les acquis quant aux
notions liées aux bases de données SQL.

## Comment l'executer ?

Pour executer et tester le projet, il est necessaire d'avoir une configuration prealable sur son ordinateur

- ### Prerequis

    - **Java**: Il est necessaire d'avoir sur sa machine le JDK = 17 (Le programme a été developpé sous java 21)
    - **MySQL**: Avoir une base de données SQL est necessaire, car l'application y accedera pour faire persister les
      données. (Lors du developpement nous avons utilisé avec MySQL = 8 sur le serveur MariaDB 10.4 fourni par XAMPP 8.0
      sur Ubuntu)
    - **JDBC Driver for MySQL**: le pilote JDBC pour **MySQL** est necessaire pour permettre à java de se connecter à la
      base de donnée. Dans notre cas, nous avons fait l'implementation sous Jetbrains.Idea, et nous y avons directement
      telechargé le pilote version = 8.0

- ### Environnement de developpement
    - **Apache Netbeans IDE 21** fourni par Apache, pour la réalisation des interfaces graphiques, à l'aide du *
      *framework
      Swing** et des JFrames. Netbeans offre un environnement fonctionnel pour la réalisation des interfaces en **
      WYSIWYG
      ** (What You See Is What You Get)
    - **Jetbrains Idea 2023.3** fourni une environnement de developpement ideal de belles fonctionnalités
      d'autocompletion et un bien meilleur analyseur syntaxique que NetBeans. Ce dernier nous a été utile pour la
      redaction de la logique metier de l'application (Package core), et les interaction derriere les interfaces. C'est
      également dans cet environnement que les tests de l'application on été effectués.
    - **XAMPP 8.0 et PHPMyAdmin** Une suite d'application permettant d'emuler des serveurs de base de donnée (MariaDB
      pour MySQL) mais aussi le necessaire pour executer PHP. Nous avons utilisé l'interface offerte par PHPMyAdmin pour
      administrer notre base de donnée.
- ### Excecution
  #### Lancer la base de donnée
    - Lancer le serveur de base de donner sur le port 3306 (Pour creer la base de donnée, nous presenterons 2 approches
      par
      la suite)
    - Y creer une base de donnée avec le nom **adress_book**
    - Sur cette base de donnée, creer les differentes tables necessaires en important les fichiers contenus dans le
      dossier `src/ressources`. Chaque fichier sql correspond à une table.
    - Vous pouvez aussi importer le fichier de la base base de donnée `src/ressources/adress_book.sql` sur votre serveur
      et l'executer pour la creer avec toutes ses tables.
  #### Executer/Debugger le projet

    - Ouvrez le projet dans votre IDE favori (Idea Jetbrains est recommandé)
    - Si le serveur de base de donnée est sur un port autre que 3306, alors vous pourrez ajouter la valeur du port comme
      argument en lançant l'application.
    - Executez le fichier **`screens/MainFrameApplication.java`** (ne pas oublier de preciser le port pour le serveur de
      donnée.) Dans la methode main qui y est vous pourrez modifier les informations de connection au serveur de base de
      donnée.
  #### Organisation des interfaces
    - L'acceuil **MainFrameApplication** qui permet de creer et gerer un repertoire, à chaque fois que vous ajouterez un
      contact, cliquez sur une colonne du tableau pour actualiser. Il est également possible de sauvegarder le
      repertoire en
      base de donnée.
    - La liste des contacts en base de donnée **ListeContacts** qui affiche le repertoire basé sur le contenu de la base
      de donné.
    - La page de creation de contact **CreerContact** Cette interface permet de creer de nouveaux contacts dans le
      repertoire courrant.

A chaque erreur lors de l'execution du programme, soit une boite de dialogue s'ouvrira et expliquera la raison, ou
alors une trace sera écrite dans la console pour debugger et comprendre le probleme en profondeur.

## Architecture

### Principaux organes

L'application comporte 4 principaux organes. L'objectif est d'avoir la plus grande portabilité et independance possible
entre les parties du code.

- **L'interface utilisateur**: Qui permet d'interagir avec l'utilisateur de l'application
- **Les entitées**: Qui represente les principaux objets au coeur de la logique metier de l'application, ce sont les
  objets manipulés (Tous des  `Contact`)
- **La base de donnée**: Qui permet de faire persister les informations
- **Les repositories**: Objet qui permet de faire la liaison entre les entitées et les differentes tables de la base de
  donnée. Ce sont eux qui permettent d'effectuer des operations sur la base de données pour chaque entité de l'
  application. Chaque entité a un repository associé. L'Interface `Repository<DataClass>` permet de definir de façon
  générique le contrat que doit remplir chaque repository. Ici DataClass permet de definir la classe à laquelle est
  associée chaque repository on pourra ainsi retourner des objets de ce type à chaque requette SQL. Tous les
  repositories etendent du repository `ContactRepository` qui lui aussi est abstrait (car est associée à une classe
  abstraite n'ayant pas de table propre). Cette classe contient principalement des bouts de codes qui seront reutilisés
  par les autres repositories ceci afin d'eviter de la duplication de code tout en se servant de polymorphisme et d'
  heritage.

Avoir les repositories à part permettra d'assurer une certaine independance vis à vis de la base de donnée.
Nous pourrons donc modifier le type de base de donnée sans avoir à toucher aux entités, il suffira juste de creer de
nouveaux repositories pour ce SBGD qui implementerons l'interface `Repository<DataClass>`.

A coté de ces 4 principaux organes nous avons les `Helpers` qui sont juste des outils supplementaires permettant
d'executer des taches connexes. Qui ne font pas forcement partie du coeur du metier.

### Principe de fonctionnement

L'utilisateur interagit avec l'interface.
L'interface se sert des entités et pour chaque interaction d'une entité avec la base de donnée, on passe par le
repository correspondant. Ce dernier se charge d'effectuer l'action voulue en base de donnée, et retourne (si
necessaire) un objet du type de l'entité à laquelle il est associé.

### Rôle de chaque package

- **screens**: package qui contient toutes les intefaces graphiques faites à l'aide de Netbeans. Il contient 3
  principales interfaces decrites plus haut.
- **core**: il decrit l'ensemble des elements intrinsequement lié à la logique metier de l'application. Il embarque les
  differentes entités mais aussi le necessaire pour les interactions avec la base de donnée ainsi que les utilitaires
    - **core.entities**: C'est le paackage qui contient les differentes entités de l'application. Chaque entité est
      definie par une classe
    - **core.repositories**: Ce package represente la laison entre les entités et la base de donnée. On y definit une
      interface qui decrit le contrat general qu'une entité devrait avoir avec la table qui lui correspond en base de
      donnée, mais aussi des classes pour implementer ces contrats là. Ce modules presente beaucoup d'elements d'Orienté
      objet, notamment la genericité des interfaces et des classes abstraites. Cela permet d'avoir une belle abstraction
      et un polymorphisme plus evolué.
    - **core.helpers**: Il s'agit de l'ensemble des elements (enums, et tools) qui aident soit à definir convenablement
      les entités, soit à realiser des operations particulieres comme la conversion d'une chaine de caractere en enum,
      ou
      le calcul de la distance de Levenshtein (Utilisé pour reperer les chaines de caracteres similaires)

## Fonctionnalités déja mises sur l'interface graphique

- Manipulation d'un repertoire: On peut ajouter des contacts au repertoire de base,
- Sauvegarde de repertoire: on peut sauvegarder les contacts du repertoire en cours,
- Liste des contacts: Il est possible de voir la liste des contacts deja enregistrés en base de donnée.
- Recherche: Etant donné une liste de contacts, il est possible de faire une recherche, en precisant le champs sur
  lequel on fait la recherche. Cette recherche utilise la distance de Levershtein pour avoir des resultats plus
  concluants.

## Améliorations

Les principales ameliorations ont trait à l'interface. Elles sont pour la plupart deja écrites d'un point de vue de la
base de donnée. Dans les repositories.

- Faire une interface graphique plus elegante
- Ajouter un filtre sur le type de contact (Faire des tabs pour voir differents types de contacts)
- Permettre de modifier les informations d'un contact
- Permettre de supprimer un contact
- Ajouter un systeme d'authentification pour permettre que chaque utilisateur puisse voir uniquement les contacts qu'il
  a envoyé
- Permettre à differents utilisateurs de se partager des contacts

## Licence

Ce projet est sous licence MIT -- pacomekengafe@gmail.com Pacome Kengali Fegue.