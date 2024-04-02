CREATE TABLE IF NOT EXISTS `adress_book`.`agent`
(
    `code`           VARCHAR(255)                                 NOT NULL,
    `nom`            VARCHAR(255)                                 NOT NULL,
    `email`          VARCHAR(255)                                 NOT NULL,
    `telephone`      VARCHAR(12)                                  NOT NULL,
    `adresse`        VARCHAR(255)                                 NOT NULL,
    `date_naissance` TIMESTAMP                                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `statut`         ENUM ('TEMPORAIRE','STAGIAIRE', 'PERMANENT') NOT NULL,
    `salaire`        DECIMAL(12, 2)                               NOT NULL,
    `categorie`      VARCHAR(32)                                  NOT NULL,
    `indice_salaire` VARCHAR(32)                                  NOT NULL,
    `occupation`     VARCHAR(32)                                  NOT NULL,
    PRIMARY KEY (`code`(255))
) ENGINE = InnoDB COMMENT = 'Cette table est celle qui decrit les contacts des agents.';