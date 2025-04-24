DROP TABLE IF EXISTS `VOITURE`;
CREATE TABLE VOITURE ( idV INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
Modele VARCHAR(100) NOT NULL, Marque VARCHAR(100) NOT NULL,  `Prix` INT,`Couleur` varchar(100) NOT NULL);

INSERT INTO `VOITURE` (`idV`, `Modele`, `Marque`,`Prix`,`Couleur`) VALUES
(1, 'Clio', 'Renaul', 9000, 'noir'),
(2, 'Mercedes', 'Mercedes-Benz', 15000, 'blan'),
(3, 'peugeot', 'peugeot', 6000, 'rouge');
