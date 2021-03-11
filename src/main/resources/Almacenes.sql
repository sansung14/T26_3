DROP TABLE IF EXISTS `cajero`;
CREATE TABLE `cajero` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nomapels` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;



DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `precio` INT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `maquina`;
CREATE TABLE `maquina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `piso` INT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS `venta`;
CREATE TABLE `venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cajero` INT NOT NULL,
  `maquina` INT NOT NULL,
  `producto` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `cajero_FK_1` FOREIGN KEY (`cajero`) REFERENCES `cajero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `maquina_FK_1` FOREIGN KEY (`maquina`) REFERENCES `maquina` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `producto_FK_1` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

INSERT INTO cajero (nomapels) values ('David Lascorz');
INSERT INTO cajero (nomapels) values ('Miguel Morillo');

INSERT INTO producto (nombre,precio) values ('Ventilador',200);
INSERT INTO producto (nombre,precio) values ('TV',4520);

INSERT INTO maquina (piso) VALUES (1);
INSERT INTO maquina (piso) VALUES (2);


INSERT INTO venta (cajero,maquina,producto) VALUES (1,1,1);
INSERT INTO venta (cajero,maquina,producto) VALUES (2,2,2);