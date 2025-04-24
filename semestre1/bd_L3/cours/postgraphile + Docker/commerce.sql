-- Question 1 : détruire les relations utilisées par la suite
DROP TABLE IF EXISTS achats;
DROP TABLE IF EXISTS produits;
DROP TABLE IF EXISTS magasins;
DROP TABLE IF EXISTS clients;

-- Question 2 : insérer les données
CREATE TABLE clients(id INT, nom VARCHAR(20), PRIMARY KEY(id));
CREATE TABLE magasins(id INT, nom VARCHAR(20), soldes INT, PRIMARY KEY(id));
CREATE TABLE produits(id INT, designation VARCHAR(20), magasin INT REFERENCES magasins, prix FLOAT, PRIMARY KEY(id));
CREATE TABLE achats(date DATE, client INT REFERENCES clients, quantite INT, produit INT REFERENCES produits, PRIMARY KEY(client, produit, date));

-- Question 3 : 
INSERT INTO magasins VALUES(1, 'Auchan', 14);
INSERT INTO magasins VALUES(2, 'Casino', 6);

INSERT INTO produits VALUES(1, 'pull-over', 1, 9);
INSERT INTO produits VALUES(2, 'casque', 2, 5);
INSERT INTO produits VALUES(3, 'pull-over', 2, 13);
INSERT INTO produits VALUES(4, 'casque', 1, 15);

INSERT INTO clients VALUES(1, 'Alphonse');
INSERT INTO clients VALUES(2, 'Marie');
INSERT INTO clients VALUES(3, 'Claude');

INSERT INTO achats VALUES(DATE '2020-02-21', 1, 5, 1);
INSERT INTO achats VALUES(DATE '2020-02-17', 2, 10, 2);
INSERT INTO achats VALUES(DATE '2020-02-28', 2, 9, 3);
INSERT INTO achats VALUES(DATE '2020-02-20', 1, 4, 4);
INSERT INTO achats VALUES(DATE '2020-02-25', 2, 5, 1);
INSERT INTO achats VALUES(DATE '2020-02-17', 3, 6, 4);
INSERT INTO achats VALUES(DATE '2020-02-17', 3, 5, 2);

