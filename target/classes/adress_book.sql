-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 02 avr. 2024 à 13:54
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `adress_book`
--

-- --------------------------------------------------------

--
-- Structure de la table `agent`
--

CREATE TABLE `agent` (
                         `code` varchar(255) NOT NULL,
                         `nom` varchar(255) NOT NULL,
                         `email` varchar(255) NOT NULL,
                         `telephone` varchar(12) NOT NULL,
                         `adresse` varchar(255) NOT NULL,
                         `date_naissance` timestamp NOT NULL DEFAULT current_timestamp(),
                         `statut` enum('TEMPORAIRE','STAGIAIRE','PERMANENT') NOT NULL,
                         `salaire` decimal(12,2) NOT NULL,
                         `categorie` varchar(32) NOT NULL,
                         `indice_salaire` varchar(32) NOT NULL,
                         `occupation` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Cette table est celle qui decrit les contacts des agents.';

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
                              `code` varchar(255) NOT NULL,
                              `nom` varchar(255) NOT NULL,
                              `email` varchar(255) NOT NULL,
                              `telephone` varchar(12) NOT NULL,
                              `adresse` varchar(255) NOT NULL,
                              `date_naissance` timestamp NOT NULL DEFAULT current_timestamp(),
                              `statut` enum('VACATAIRE','PERMANENT') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Cette table est celle qui decrit les contacts des enseignants.';

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`code`, `nom`, `email`, `telephone`, `adresse`, `date_naissance`, `statut`) VALUES
    ('ens217110', 'enseignant', 'sdfsdf', 'fdsf', 'sdfds', '2004-06-28 23:00:00', 'PERMANENT');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
                            `code` varchar(255) NOT NULL,
                            `nom` varchar(255) NOT NULL,
                            `email` varchar(255) NOT NULL,
                            `telephone` varchar(12) NOT NULL,
                            `adresse` varchar(255) NOT NULL,
                            `date_naissance` timestamp NOT NULL DEFAULT current_timestamp(),
                            `cycle` enum('LICENCE','INGENIEUR') NOT NULL,
                            `niveau` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Cette table est celle qui decrit les contacts des étudiants.';

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`code`, `nom`, `email`, `telephone`, `adresse`, `date_naissance`, `cycle`, `niveau`) VALUES
                                                                                                                 ('21P027', 'Pacome Kengali Fegue', 'pacomekengafe@gmail.com', '', 'Londres', '2024-04-01 13:42:56', 'INGENIEUR', '3'),
                                                                                                                 ('2832', 'The KFP', 'mail ici', '690', 'adresse', '2004-06-28 23:00:00', 'INGENIEUR', '3'),
                                                                                                                 ('code-1', 'Teacher 1', 'email', '690', 'adresse', '2004-06-28 23:00:00', 'INGENIEUR', '3'),
                                                                                                                 ('etu445405', 'etudiant', 'fdgfd', 'gfdgfd', 'gfd', '2004-06-28 23:00:00', 'LICENCE', '');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `agent`
--
ALTER TABLE `agent`
    ADD PRIMARY KEY (`code`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
    ADD PRIMARY KEY (`code`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
    ADD PRIMARY KEY (`code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;