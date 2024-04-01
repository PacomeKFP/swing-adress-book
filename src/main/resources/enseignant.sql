CREATE TABLE IF NOT EXISTS `adress_book`.`enseignant`
(
    `code`           VARCHAR(255) NOT NULL,
    `nom`            VARCHAR(255) NOT NULL,
    `email`          VARCHAR(255) NOT NULL,
    `telephone`      VARCHAR(12)  NOT NULL,
    `adresse`        VARCHAR(255) NOT NULL,
    `date_naissance` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `statut`          ENUM('VACATAIRE','PERMANENT') NOT NULL,
    PRIMARY KEY (`code`(255))
) ENGINE = InnoDB COMMENT = 'Cette table est celle qui decrit les contacts des enseignants.';