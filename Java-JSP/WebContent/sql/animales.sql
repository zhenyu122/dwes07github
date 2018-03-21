-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2018 a las 22:41:09
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `animales`
--
CREATE DATABASE IF NOT EXISTS `animales` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `animales`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animal`
--

CREATE TABLE IF NOT EXISTS `animal` (
  `chip` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `especie` varchar(45) DEFAULT NULL,
  `imagen` varchar(30) NOT NULL,
  PRIMARY KEY (`chip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `animal`
--

INSERT INTO `animal` (`chip`, `nombre`, `especie`, `imagen`) VALUES
(1, 'Garfield', 'gato', 'garfield.png'),
(2, 'Odie', 'perro', 'odie.png'),
(3, 'Nymeria', 'lobo huargo', 'nymeria.png'),
(4, 'Zero', 'perro fantasma', 'zero.png'),
(5, 'Babe', 'cerdo', 'babe.gif'),
(6, 'Toothless', 'dragón', 'toothless.png'),
(7, 'Idéfix', 'perro', 'idefix.png'),
(8, 'Santa\'s Little Helper', 'galgo inglés', 'santa.png'),
(9, 'Snowball', 'gato', 'snowball.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuida`
--

CREATE TABLE IF NOT EXISTS `cuida` (
  `idCuidador` int(11) NOT NULL,
  `chipAnimal` int(11) NOT NULL,
  PRIMARY KEY (`idCuidador`,`chipAnimal`),
  KEY `fk_Cuidador_has_Animal_Animal1` (`chipAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuida`
--

INSERT INTO `cuida` (`idCuidador`, `chipAnimal`) VALUES
(12345, 1),
(12345, 2),
(14524, 7),
(15512, 5),
(23243, 4),
(35132, 8),
(35132, 9),
(35133, 8),
(35133, 9),
(42356, 6),
(54321, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuidador`
--

CREATE TABLE IF NOT EXISTS `cuidador` (
  `idCuidador` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCuidador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuidador`
--

INSERT INTO `cuidador` (`idCuidador`, `Nombre`) VALUES
(12345, 'Jon'),
(14524, 'Obélix'),
(15512, 'Arthur Hoggett'),
(23243, 'Jack Skellington'),
(35132, 'Homer Simpson'),
(35133, 'Marge Simpson'),
(42356, 'Hipo'),
(54321, 'Arya');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuida`
--
ALTER TABLE `cuida`
  ADD CONSTRAINT `fk_Cuidador_has_Animal_Animal1` FOREIGN KEY (`chipAnimal`) REFERENCES `animal` (`chip`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cuidador_has_Animal_Cuidador` FOREIGN KEY (`idCuidador`) REFERENCES `cuidador` (`idCuidador`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
