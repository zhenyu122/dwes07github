-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-02-2018 a las 10:39:43
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
-- Base de datos: `catalogo07`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sede` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Imagen` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`ID`, `Nombre`, `Sede`, `Imagen`) VALUES
(1, 'Electronic Arts', 'Redwood City, California, EE. UU', 'ea.png'),
(2, 'Nintendo', 'Kioto, Japón', 'nintendo.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obras`
--

CREATE TABLE `obras` (
  `ID` int(11) NOT NULL,
  `Titulo` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Compania` int(11) NOT NULL,
  `Imagen` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `obras`
--

INSERT INTO `obras` (`ID`, `Titulo`, `Compania`, `Imagen`) VALUES
(1, 'FIFA 18', 1, 'fifa18.png'),
(2, 'SUPER MARIO ODYSSEY', 2, 'mario.png'),
(3, 'THE LEGEND OF ZELDA : BREATH OF THE WILD', 2, 'zelda.png'),
(4, 'DISGAEA 5 COMPLETE', 2, 'disgaea.png'),
(5, 'STAR WARS BATTLEFRONT II', 1, 'battlefront2.png'),
(6, 'STAR WARS BATTLEFRONT', 1, 'battlefront.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `login` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `descripcion` text COLLATE utf8mb4_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`login`, `password`, `nombre`, `admin`, `descripcion`) VALUES
('zhenyu', '$2y$10$8za5tQTlnb5/Ynl.7FCMwewfbLFliQB2J7y6vohXscpOSELZ0vrFy', 'Zhenyu Guo', 1, 'Cuenta Admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `obras`
--
ALTER TABLE `obras`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Autor` (`Compania`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`login`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `obras`
--
ALTER TABLE `obras`
  ADD CONSTRAINT `AutorObra` FOREIGN KEY (`Compania`) REFERENCES `autor` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
