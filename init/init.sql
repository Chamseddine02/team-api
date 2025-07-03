REATE DATABASE IF NOT EXISTS teamdb;
USE teamdb;

CREATE TABLE IF NOT EXISTS equipe (
                                      id INT PRIMARY KEY,
                                      name VARCHAR(100),
    acronym VARCHAR(10),
    budget DOUBLE
    );

INSERT INTO equipe (id, name, acronym, budget) VALUES
                                                   (1, 'OGC Nice', 'OGC Nice', 30000000.00),
                                                   (2, 'Paris Saint-Germain', 'PSG', 600000000.00),
                                                   (3, 'Olympique Lyonnais', 'OL', 180000000.00);

CREATE TABLE IF NOT EXISTS joueur (
                                      id INT PRIMARY KEY,
                                      name VARCHAR(100),
    position VARCHAR(50),
    equipe_id INT,
    FOREIGN KEY (equipe_id) REFERENCES equipe(id)
    );

INSERT INTO joueur (id, name, position, equipe_id) VALUES
                                                       (1, 'Jean Dupont', 'Attaquant', 1),
                                                       (2, 'Paul Martin', 'Défenseur', 1),
                                                       (3, 'Luc Bernard', 'Milieu', 1),
                                                       (4, 'Kylian Mbappé', 'Attaquant', 2),
                                                       (5, 'Marquinhos', 'Défenseur', 2),
                                                       (6, 'Marco Verratti', 'Milieu', 2),
                                                       (7, 'Moussa Dembélé', 'Attaquant', 3),
                                                       (8, 'Jason Denayer', 'Défenseur', 3),
                                                       (9, 'Lucas Paquetá', 'Milieu', 3);