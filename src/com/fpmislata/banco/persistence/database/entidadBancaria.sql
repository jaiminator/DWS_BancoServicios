-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.0.20-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para banco
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco`;


-- Volcando estructura para tabla banco.entidadbancaria
CREATE TABLE IF NOT EXISTS `entidadbancaria` (
  `idEntidadBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `codigoEntidad` varchar(50) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `cif` varchar(50) NOT NULL,
  PRIMARY KEY (`idEntidadBancaria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.entidadbancaria: ~4 rows (aproximadamente)
DELETE FROM `entidadbancaria`;
/*!40000 ALTER TABLE `entidadbancaria` DISABLE KEYS */;
INSERT INTO `entidadbancaria` (`idEntidadBancaria`, `nombre`, `codigoEntidad`, `fechaCreacion`, `direccion`, `cif`) VALUES
	(1, 'Bankia', '431C', '2015-10-21', 'C/Uriel', '001'),
	(2, 'Caixabank', '731G', '2015-09-24', 'C/Juan Varelles', '002'),
	(3, 'Santander', '3456', '2015-10-28', 'C/Julio Iglesias', '003'),
	(6, 'Santander', '432V', '2015-11-05', 'C/Mislata', '004');
/*!40000 ALTER TABLE `entidadbancaria` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
