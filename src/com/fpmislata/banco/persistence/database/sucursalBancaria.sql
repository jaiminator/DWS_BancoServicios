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


-- Volcando estructura para tabla banco.sucursalbancaria
CREATE TABLE IF NOT EXISTS `sucursalbancaria` (
  `idSucursalBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreSucursal` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `director` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `fechaApertura` date NOT NULL,
  PRIMARY KEY (`idSucursalBancaria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.sucursalbancaria: ~3 rows (aproximadamente)
DELETE FROM `sucursalbancaria`;
/*!40000 ALTER TABLE `sucursalbancaria` DISABLE KEYS */;
INSERT INTO `sucursalbancaria` (`idSucursalBancaria`, `nombreSucursal`, `direccion`, `director`, `telefono`, `fechaApertura`) VALUES
	(1, 'Bancaixa', 'C/Pelayo', 'Joan Manuel', '964320058', '2015-10-29'),
	(2, 'Santander', 'C/Turia', 'Joan Manuel', '963210137', '2015-10-29'),
	(3, 'Bankia', 'C/Tirant', 'Lola Flores', '962903613', '2015-11-05');
/*!40000 ALTER TABLE `sucursalbancaria` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
