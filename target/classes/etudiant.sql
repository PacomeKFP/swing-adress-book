CREATE TABLE `adress_book`.`etudiant`
(
    `code`           VARCHAR(255) NOT NULL,
    `nom`            VARCHAR(255) NOT NULL,
    `email`          VARCHAR(255) NOT NULL,
    `telephone`      VARCHAR(12)  NOT NULL,
    `adresse`        VARCHAR(255) NOT NULL,
    `date_naissance` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `cycle`          ENUM('LICENCE','INGENIEUR') NOT NULL,
    `niveau`         VARCHAR(16)  NOT NULL,
    PRIMARY KEY (`code`(255))
) ENGINE = InnoDB COMMENT = 'Cette table est celle qui decrit les contacts des étudiants.';