-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2017 a las 12:40:03
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

CREATE TABLE `animal` (
  `chip` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `especie` varchar(45) DEFAULT NULL,
  `imagen` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `animal`
--

INSERT INTO `animal` (`chip`, `nombre`, `especie`, `imagen`) VALUES
(1, 'Garfield', 'gato', 'garfield.png'),
(2, 'Odie', 'perro', 'odie.png'),
(3, 'Babe', 'jabali', 'babe.png'),
(4, 'Baxter', 'perro', 'baxter.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuida`
--

CREATE TABLE `cuida` (
  `idCuidador` int(11) NOT NULL,
  `chipAnimal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuida`
--

INSERT INTO `cuida` (`idCuidador`, `chipAnimal`) VALUES
(12345, 1),
(12345, 2),
(54321, 3),
(54321, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuidador`
--

CREATE TABLE `cuidador` (
  `idCuidador` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuidador`
--

INSERT INTO `cuidador` (`idCuidador`, `Nombre`) VALUES
(12345, 'Alberto'),
(23243, 'Luis'),
(54321, 'Áurea');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`chip`);

--
-- Indices de la tabla `cuida`
--
ALTER TABLE `cuida`
  ADD PRIMARY KEY (`idCuidador`,`chipAnimal`),
  ADD KEY `fk_Cuidador_has_Animal_Animal1` (`chipAnimal`);

--
-- Indices de la tabla `cuidador`
--
ALTER TABLE `cuidador`
  ADD PRIMARY KEY (`idCuidador`);

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
