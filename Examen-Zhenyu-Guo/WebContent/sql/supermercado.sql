-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-03-2018 a las 00:08:23
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
-- Base de datos: `supermercado`
--
CREATE DATABASE IF NOT EXISTS `supermercado` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `supermercado`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `login` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gasto` double NOT NULL,
  `direccion` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`login`, `password`, `nombre`, `gasto`, `direccion`) VALUES
('ariego', 'ariego', 'Almudena Riego', 40, 'C/ Llana 23, 1ºC, 28034, Madrid'),
('aruiz', 'aruiz', 'Alberto Ruiz', 127.3, 'C/ Quintana 34, 3ºC, 28008 Madrid');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `idproducto` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `marca` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `precio` decimal(3,2) NOT NULL,
  `stock` int(10) NOT NULL,
  `descripcion` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `imagen` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `familia` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ubicacion` int(10) NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `nombre`, `marca`, `precio`, `stock`, `descripcion`, `imagen`, `familia`, `ubicacion`) VALUES
(1, 'Salsa mayonesa sin huevo y sin lactosa 300ml', 'Musa', '1.80', 0, 'Denominaci&oacute;n del alimento:Salsa sin huevo-sin lactosa\r\nNombre del operador de la empresa alimentaria:DCOOP, S.COOP.AND.\r\nNombre del importador:Agroalimentaria Musa S.L.', 'Salsa_mayonesa_sin_huevo_y_sin_lactosa_300ml.png', 'Sin Lactosa', 1),
(2, 'Salsa mayonesa sin huevo y sin lactosa 450ml', 'Coosur', '1.52', 60, 'Denominación del alimento:Salsa Sin Huevo y Sin Lactosa\r\nNombre del operador de la empresa alimentaria:ACEITES DEL SUR - COOSUR S.A\r\nNombre del importador:Aceites del Sur - Coosur S.A', 'Salsa_mayonesa_sin_huevo_y_sin_lactosa_450ml.png', 'Sin Lactosa', 2),
(3, 'Vinagre de manzana 1l', 'Carrefour', '0.69', 120, 'Denominación del alimento:Vinagre de manzana\r\nNombre del operador de la empresa alimentaria:Centros Comerciales Carrefour S.A\r\nNombre del importador:Centros Comerciales Carrefour S.A', 'Vinagre_de_manzana_1l.png', 'Sin Lactosa', 3),
(4, 'Levadura en polvo pack 6x16g', 'Royal', '2.08', 23, 'Denominación del alimento: Levadura en polvo. Peso neto: 96 g.\r\nNombre del operador de la empresa alimentaria:Mondelez España Commercial S.L.\r\nNombre del importador:Mondelez España Commercial, S.L.', 'Levadura_en_polvo_pack_6x16g.png', 'Sin Lactosa', 4),
(5, 'Bicarbonato sódico 200g', 'Carmencita', '0.98', 15, 'Denominación del alimento:Bicarbonato sódico\r\nNombre del operador de la empresa alimentaria:JESÚS NAVARRO, S.A.\r\nNombre del importador:JESÚS NAVARRO, S.A.', 'Bicarbonato_sodico_200g.png', 'Sin Lactosa', 5),
(6, 'Aceite de girasol 1l', 'Carrefour', '0.99', 0, 'Denominación del alimento:Aceite refinado de girasol\r\nNombre del operador de la empresa alimentaria:FAIGES S.L\r\nNombre del importador:F.Faiges S.L', 'Aceite_de_girasol_1l.png', 'Sin Lactosa', 6),
(7, 'Galleta Delizias de Algarroba Sin Lactosa Bio 110g', 'Bio-Darma', '2.20', 15, 'Denominación del alimento:Delizias de Algarroba\r\nNombre del operador de la empresa alimentaria:Bio Darma, S.L.\r\nNombre del importador:Bio Darma, S.L.', 'Galleta_Delizias_de_Algarroba_Sin_Lacto_a_Bio_110g.png', 'Sin Lactosa', 13),
(8, 'Mini barquillo con leche y crema de avellana sin lactosa 100g', 'MinusL', '2.40', 10, 'Denominación del alimento:Mini barquillos rellenos con 37% de crema de leche desnatada y 27% de crema de avellanas, recubiertas con 16% de chocolate con leche entera, SIN LACTOSA\r\n', 'Mini_barquillo_con_leche_y_crema_de_avellana_sin_lactosa_100g.png', 'Sin Lactosa', 14),
(9, 'Galleta Delizias de Avena con Chocolate Sin Lactosa Bio 110g', 'Bio-Darma', '2.60', 33, 'Denominación del alimento: Delizias Avena con Chocolate', 'Galleta_Delizias_de_Avena_con_Chocolate_Sin_Lactosa_Bio_110g.png', 'Sin Lactosa', 15),
(10, 'Chocolate con leche y almendras sin lactosa 150g', 'Valor', '2.10', 20, 'Denominación del alimento:Chocolate', 'Chocolate_con_leche_y_almendras_sin_lactosa_150g.png', 'Sin Lactosa', 16),
(11, 'Galletas de Mantequilla y Chocolate Sin Lactosa 125g', 'MinusL', '2.94', 0, 'Denominación del alimento:GALLETAS MANTEQUILLA CON CHOCOLATE SIN LACTOSA', 'Galletas_de_Mantequilla_y_Chocolate_Sin_Lactosa_125g.png', 'Sin Lactosa', 17),
(12, 'Galletas de Chocolate sin Lactosa 300g', 'MinusL', '2.96', 3, 'Denominación del alimento:GALLETAS RELLENAS DE CHOCOLATE SIN LACTOSA', 'Galletas_de_Chocolate_sin_Lactosa_300g.png', 'Sin Lactosa', 18),
(13, 'Crema de Untar Avellana y Turrón Sin Lactosa 400g', 'MinusL', '4.85', 2, 'Denominación del alimento:CREMA DE AVELLANAS Y TURRÓN SIN LACTOSA\r\nNombre del operador de la empresa alimentaria:Casa Westfalia, S.A.', 'Crema_de_Untar_Avellana_y_Turron_Sin_Lactosa_400g.png', 'Sin Lactosa', 25),
(14, 'Galleta dibus sin lactosa 250g', 'Gullon', '1.24', 26, 'Denominación del alimento:Galleta\r\nNombre del operador de la empresa alimentaria:Galletas Gullón', 'Galleta_dibus_sin_lactosa_250g.png', 'Sin Lactosa', 26),
(15, 'Galletas de Chocolate Mignon sin Lactosa 200g', 'MinusL', '3.54', 14, 'Denominación del alimento:Barquillos con un 50% de manteca de cacao y un 30% de chocolate con leche, SIN LACTOSA.', 'Galletas_de_Chocolate_Mignon_sin_Lactosa_200g.png', 'Sin Lactosa', 27),
(16, 'Barritas de Galleta Chocolate Sin Lactosa 2x30g', 'MinusL', '0.99', 30, 'Denominación del alimento:Barquillos con un 50% de manteca de cacao y un 30% de chocolate con leche, sin lactosa.', 'Barritas_de_Galleta_Chocolate_Sin_Lactosa_2x30g.png', 'Sin Lactosa', 28),
(17, 'Café con leche sin lactosa 230ml', 'Kaiku', '1.25', 0, ' - ', 'Cafe_con_leche_sin_lactosa_230ml.png', 'Sin Lactosa', 29),
(18, 'Galletas sin Gluten y sin Lactosa Hello Kitty 120g', 'Virginias', '2.85', 0, 'Denominación del alimento:Galleta\r\nNombre del operador de la empresa alimentaria:Industrias Rodriguez', 'Galletas_sin_Gluten_y_sin_Lactosa_Hello_Kitty_120g.png', 'Sin Lactosa Sin Gluten', 30),
(19, 'Leche entera sin lactosa 1l', 'Kaiku', '1.39', 100, 'Leche entera UHT sin lactosa enriquecida en vitaminas A, D, E y ácido fólico', 'Leche_entera_sin_lactosa_1l.png', 'Sin Lactosa', 37),
(20, 'Leche con calcio sin lactosa 1l', 'Kaiku', '1.39', 96, 'Leche semidesnatada UHT sin lactosa con Calcio enriquecida en vitaminas A, D, E, ácido fólico y fósforo', 'Leche_con_calcio_sin_lactosa_1l.png', 'Sin Lactosa', 38),
(21, 'Leche desnatada sin lactosa 1l', 'Kaiku', '1.39', 0, 'Leche desnatada UHT sin lactosa enriquecida en vitaminas A, D, E y ácido fólico', 'Leche_desnatada_sin_lactosa_1l.png', 'Sin Lactosa', 39),
(22, 'Batido de chocolate sin lactosa 3x200ml', 'Kaiku', '1.69', 13, 'Batido de chocolate UHT sin lactosa\r\nCalibre:3x200ml', 'Batido_de_chocolate_sin_lactosa_3x200ml.png', 'Sin Lactosa', 40),
(23, 'Nata para montar sin lactosa 200ml', 'Kaiku', '1.37', 41, 'Preparado lácteo UHT Sin Lactosa (36% M.G.)', 'Nata_para_montar_sin_lactosa_200ml.png', 'Sin Lactosa', 41),
(24, 'Natillas sabor chocolate sin lactosa 250g', 'Kaiku', '1.89', 0, 'Postre lácteo sabor a chocolate sin lactosa.', 'Natillas_sabor_chocolate_sin_lactosa_250g.png', 'Sin Lactosa', 42),
(25, 'Preparado lácteo fermantado natural & Muesli sin lactosa 175g', 'Kaiuku', '1.49', 10, 'Leche fermentada azucarada sin lactosa y muesli.', 'Preparado_lacteo_fermentado_fresas_sin_lactosa_450g.png', 'Sin Lactosa', 49),
(26, 'Preparado lácteo fermentado batido sin lactosa 420g', 'Kaiku', '2.70', 15, 'Leche desnatada fermentada con LGG (Lactobacillus Gorbach y Goldin), con zumo de plátano y de fresa enriquecida en vitaminas B6 y B9 (ácido fólico). Sin lactosa.', 'Preparado_lácteo_fermentado_batido_sin_lactosa_420g.png', 'Sin Lactosa', 50),
(27, 'Preparado lácteo fermentado con piña 0% sin lactosa 4x125g', 'Kaiku', '1.61', 2, 'Leche desnatada fermentada sin lactosa, con piña. Con fructosa y edulcorantes.', 'Preparado_lácteo_fermentado_con_piña_0%_sin_lactosa_4x125g.png', 'Sin Lactosa', 51),
(28, 'Preparado lácteo fermentado fresa & Muesli sin lactosa', 'Kaiku', '1.49', 26, 'Leche fermentada sin lactosa con fresa y muesli.', 'Preparado_lacteo_fermentado_fresa_&_Muesli_sin_lactosa175.png', 'Sin Lactosa', 52),
(29, 'Preparado lácteo fermentado fresa sin lactosa 80g', 'Kaiku', '2.50', 15, 'Leche fermentada sin lactosa, sabor a fresa.', 'Preparado_lacteo_fermentado_fresa_sin_lactosa_80g.png', 'Sin Lactosa', 53),
(30, 'Preparado lácteo fermentado fresas sin lactosa 450g', 'Kaiku', '2.05', 0, 'Leche fermentada semidenatada con fresas y sin lactosa', 'Preparado_lácteo_fermentado_fresas_sin_lactosa_450g.png', 'Sin Lactosa', 54),
(31, 'Leche Energía y Crecimiento sin lactosa semidesnatada 1l', 'Celta', '1.00', 78, 'LECHE UHT SIN LACTOSA ENERGIA\r\nNombre del operador de la empresa alimentaria:LECHE CELTA S.L.U.\r\n', 'Leche_Energia_y_Crecimiento_sin_lactosa_semidesnatada_1l.png', 'Sin Lactosa', 61),
(32, 'Leche Semidesnatada Sin Lactosa Fácil Digestión 1l', 'Celta', '1.15', 48, 'LECHE UHT SIN LACTOSA\r\nNombre del operador de la empresa alimentaria:LECHE CELTA S.L.U.', 'Leche_Semidesnatada_Sin_Lactosa_Fácil_Digestión_1l.png', 'Sin Lactosa', 62),
(33, 'Leche sin lactosa desnatada 1l', 'Celta', '1.09', 26, 'LECHE UHT SIN LACTOSA\r\nNombre del operador de la empresa alimentaria:LECHE CELTA S.L.U.', 'Leche_sin_lactosa_desnatada_1l.png', 'Sin Lactosa', 63),
(34, 'Arroz con leche sin lactosa 2x130g', 'Dhul', '1.23', 36, 'Arroz con leche sin lactosa. Postre lácteo', 'Arroz_con_leche_sin_lactosa_2x130g.png', 'Sin Lactosa', 64),
(35, 'Flan de huevo sin lactosa 2x110g', 'Dhul', '1.23', 33, 'Flan de huevo sin lactosa. Postre lácteo', 'Leche_semidesnatada_sin_lactosa_1l.png', 'Sin Lactosa', 65),
(36, 'Flan de vainilla sin lactosa 4x100g', 'Dhul', '1.23', 0, 'Flan sabor vainilla sin lactosa. Postre lácteo.', 'Flan_de_vainilla_sin_lactosa_4x100g.png', 'Sin Lactosa', 66),
(37, 'Leche Desnatada Sin Lactosa 1l', 'Carreofur', '0.75', 300, 'Denominación del alimento:Leche desnatada\r\nNombre del operador de la empresa alimentaria:Centros Comerciales Carrefour S.A', 'Leche_Desnatada_Sin_Lactosa_1lCarrefour.png', 'Sin Lactosa', 73),
(38, 'Leche entera sin lactosa 1l', 'Carrefour', '0.75', 262, ' - ', 'Leche_entera_sin_lactosa_1lCarrefour.png', 'Sin Lactosa', 74),
(39, 'Leche Semidesnatada Sin Lactosa 1l', 'Carrefour', '0.75', 210, '', 'Leche_Semidesnatada_Sin_Lactosa_1lCarrefour.png', 'Sin Lactosa', 75),
(40, 'Espirales sin gluten 500g', 'Carrefour', '1.35', 16, ' - ', 'Espirales_sin_gluten_500g.png', 'Sin Gluten', 76),
(41, 'Macarrones sin gluten 500g', 'Carrefour', '1.35', 33, ' - ', 'Macarrones_sin_gluten_500g.png', 'Sin Gluten', 77),
(42, 'Spaghetti sin gluten 500g', 'Carrefour', '1.35', 36, ' -', 'Spaghetti_sin_gluten_500g.png', 'Sin Gluten', 78),
(43, 'Cacahuetes tostados con miel - Sin Gluten 125g', 'Carrefour', '1.07', 18, 'Cacahuetes con miel fritos y salados', 'Cacahuetes_tostados_con_miel_-_Sin_Gluten_125g.png', 'Sin Gluten', 85),
(44, 'Cocktail de frutas exóticas desecadas - Sin Gluten 150g', 'Carrefour', '1.13', 20, '-', 'Cocktail_de_frutas_exoticas_desecadas_-_Sin_Gluten_150g.png', 'Sin Gluten', 86),
(45, 'Cortezas de cerdo bolsa - Sin Gluten 90g', 'Carrefour', '0.71', 33, 'Cortezas de cerdo fritas', 'Cortezas_de_cerdo_bolsa_-_Sin_Gluten_90g.png', 'Sin Gluten', 87),
(46, 'Pimentón dulce de la Vera - Sin Gluten - De Nuestra Tierra 90g', 'De Nuestra Tierra', '1.92', 25, 'Pimentón Dulce', 'Pimenton_dulce_de_la_Vera_-_Sin_Gluten_-_De_Nuestra_Tierra_90g.png', 'Sin Gluten', 88),
(47, 'Pimentón picante de la Vera - Sin Gluten - De Nuestra Tierra 90g', 'De Nuestra Tierra', '1.92', 29, 'Pimentón picante', 'Pimenton_picante_de_la_Vera_-_Sin_Gluten_-_De_Nuestra_Tierra_90g', 'Sin Gluten', 89),
(48, 'Tostadas de Maiz y Arroz Dietéticas Sin Gluten 250g', 'Gerble', '3.25', 10, ' -', 'Tostadas_de_Maiz_y_Arroz_Dieteticas_Sin_Gluten_250g.png', 'Sin Gluten', 90),
(49, 'Fideos - Sin Gluten 50g', 'Gallo', '1.60', 45, 'PASTA DE HARINA DE MAÍZ Y HARINA DE ARROZ', 'Fideos_-_Sin_Gluten_500g.png', 'Sin Gluten', 97),
(50, 'Harina sin gluten para múltiples usos 500g', 'Gallo', '1.60', 56, 'PREPARADO A BASE DE MAÍZ, ARROZ Y PATATA PARA COCINAR', 'Harina_sin_gluten_para_multiples_usos_500g.png', 'Sin Gluten', 98),
(51, 'Hélices de maíz con vegetales - Sin Gluten 500g', 'Gallo', '1.60', 33, 'PASTA DE HARINA DE MAÍZ Y HARINA DE ARROZ CON VEGETALES', 'Helices_de_maiz_con_vegetales_-_Sin_Gluten_500g.png', 'Sin Gluten', 99),
(52, 'Macarrones - Sin Gluten 500g', 'Gallo', '1.60', 125, 'PASTA DE HARINA DE MAÍZ Y HARINA DE ARROZ', 'Macarrones_-_Sin_Gluten_500g.png', 'Sin Gluten', 100),
(53, 'Tallarines sin gluten 500g', 'Gallo', '1.60', 37, 'PASTA DE HARINA DE MAÍZ Y HARINA DE ARROZ', 'Tallarines_sin_gluten_500g.png', 'Sin Gluten', 101),
(54, 'Tiburon sin gluten 500g', 'Gallo', '1.60', 58, 'PASTA DE HARINA DE MAÍZ Y HARINA DE ARROZ', 'Tiburon_sin_gluten_500g.png', 'Sin Gluten', 102),
(55, 'Tomate frito sin gluten 800g', 'Apis', '1.24', 99, ' -', 'Tomate_frito_sin_gluten_800g.png', 'Sin Gluten', 109),
(56, 'Tomate frito con aceite de oliva 500g', 'Helios', '1.45', 87, 'Tomate Frito Receta Artesana', 'Tomate_frito_con_aceite_de_oliva_500g.png', 'Sin Gluten', 110),
(57, 'Harina universal - Sin Gluten 1k', 'Schar', '3.70', 14, '-', 'Harina_universal_-_Sin_Gluten_1k.png', 'Sin Gluten', 111),
(58, 'Mix b preparado pan - Sin Gluten 1k', 'Schar', '3.89', 70, 'Preparado para pan sin gluten', 'Mix_b_preparado_pan_-_Sin_Gluten_1k.png', 'Sin Gluten', 112),
(59, 'Mix c dolci preparado galletas pasteles - Sin Gluten 1k', 'Schar', '4.00', 36, 'Preparado para pasteles y galletas sin gluten', 'Mix_c_dolci_preparado_galletas_pasteles_-_Sin_Gluten_1k.png', 'Sin Gluten', 113),
(60, 'Pasta anellini - Sin Gluten 250g', 'Schar', '2.09', 25, 'Pasta sin gluten', 'Pasta_anellini_-_Sin_Gluten_250g.png', 'Sin Gluten', 114),
(61, 'Cerveza Especial sin gluten 33cl', 'Ambar', '0.68', 70, ' -', 'Cerveza_Especial_sin_gluten_33cl.png', 'Sin Gluten', 121),
(62, 'Cerveza sin alcohol - Sin Gluten 33cl', 'Ambar', '0.81', 65, 'Cerveza sin alcohol 0.0%', 'Cerveza_sin_alcohol_-_Sin_Gluten_33cl.png', 'Sin Gluten', 122),
(63, 'Cerveza sin gluten 33cl', 'Daura', '0.68', 63, ' -', 'Cerveza_sin_gluten_33cl.png', 'Sin Gluten', 123),
(64, 'Cerveza sin gluten tercio 33cl', 'Daura', '0.95', 52, ' -', 'Cerveza_sin_gluten_tercio_33cl.png', 'Sin Gluten', 124),
(65, 'Cerveza Premium Especial sin gluten 33cl', 'San Miguel', '0.77', 120, 'CERVEZA ESPECIAL (SIN GLUTEN)', 'Cerveza_Premium_Especial_sin_gluten_33cl.png', 'Sin Gluten', 125),
(66, 'Cerveza marzen sin gluten 33cl', 'Daura Marzen', '0.95', 31, ' -', 'Cerveza_marzen_sin_gluten_33cl.png', 'Sin Gluten', 126),
(67, 'Mermelada de tomate - Sin Gluten 410g', 'Carrefour', '0.98', 63, 'Denominación del alimento: Mermelada Tomate', 'Mermelada_de_tomate_-_Sin_Gluten_410g.png', 'Sin Gluten', 133),
(68, 'Mermelada de albaricoque con fructosa - Sin Gluten 380g', 'Carrefour', '1.35', 45, 'Denominación del alimento: Preparado de albaricoque', 'Mermelada_de_albaricoque_con_fructosa_-_Sin_Gluten_380g.png', 'Sin Gluten', 134),
(69, 'Mermelada extra de arándano - Sin Gluten 410g', 'Carrefour', '1.66', 28, 'Denominación del alimento: Mermelada Arándano', 'Mermelada_extra_de_arandano_-_Sin_Gluten_410g.png', 'Sin Gluten', 135),
(70, 'Mermelada de ciruela con fructosa Diet - Sin Gluten 380g', 'Carrefour', '1.35', 32, 'Denominación del alimento: Ciruela con fructosa', 'Mermelada_de_ciruela_con_fructosa_Diet_-_Sin_Gluten_380g.png', 'Sin Gluten', 136),
(71, 'Mermelada de fresa con fructosa Diet - Sin Gluten 380g', 'Carrefour', '1.35', 33, 'Denominación del alimento: Preparado de fresa', 'Mermelada_de_fresa_con_fructosa_Diet_-_Sin_Gluten_380g.png', 'Sin Gluten', 137),
(72, 'Mermelada extra de manzana - Sin Gluten 410g', 'Carrefour', '1.66', 36, 'Denominación del alimento: Mermelada Manzana', 'Mermelada_extra_de_manzana_-_Sin_Gluten_410g.png', 'Sin Gluten', 138),
(73, 'Pistachos tostados salados ecológicos 125g', 'Carrefour', '2.95', 55, ' -', 'Pistachos_tostados_salados_ecologicos_125g.png', 'Bio', 145),
(74, 'Aceite de oliva virgen extra ecológico 500ml', 'Carrefour', '3.85', 33, 'La mejor forma de disfrutar de todas las propiedades del mejor aceite español, es con el aceite ecológico de oliva virgen extra de la marca Carrefour BIO.', 'Aceite_de_oliva_virgen_extra_ecologico_500ml.png', 'Bio', 146),
(75, 'Ajo molido 35g', 'Carrefour', '1.21', 15, 'Denominación del alimento: Ajo Molido', 'Ajo_molido_35g.png', 'Bio', 147),
(76, 'Albahaca 10g', 'Carrefour', '1.09', 26, 'Denominación del alimento: Albahaca', 'Albahaca_10g.png', 'Bio', 148),
(77, 'Canela molida 25g', 'Carrefour', '1.09', 19, 'Denominación del alimento: Canela Molida', 'Canela_molida_25g.png', 'Bio', 149),
(78, 'Cous-cous grano mediano ecológico 500g', 'Carrefour', '1.87', 14, 'Denominación de alimento: Cous Cous Ecológico de 500g', 'Cous-cous_grano_mediano_ecologico_500g.png', 'Bio', 150),
(79, 'Amaranto hinchado bio 125g', 'Ecocesta', '2.09', 14, 'Denominación del alimento: Amaranto hinchado\r\nCantidad neta del alimento: 125 Gramos', 'Amaranto_hinchado_bio_125g.jpg', 'Bio', 157),
(80, 'Arroz integral de cultivo ecológico 1k', 'Ecocesta', '4.70', 21, ' -', 'Arroz_integral_de_cultivo_ecologico_1k.jpg', 'Bio', 158),
(81, 'Arroz integral hinchado con ágave y coco 350g', 'Ecocesta', '4.20', 2, 'Denominación del alimento: Arroz integral hinchado con ágave y coco\r\nCantidad neta del alimento: 350 Gramos', 'Arroz_integral_hinchado_con_agave_y_coco_350g.jpg', 'Bio', 159),
(82, 'Centeno hinchado bio 125g', 'Ecocesta', '1.56', 64, 'Denominación del alimento: Centeno hinchado\r\nCantidad neta del alimento:125 Gramos', 'Centeno_hinchado_bio_125g.jpg', 'Bio', 160),
(83, 'Cous cous blanco bio 280g', 'Ecocesta', '2.80', 48, 'Denominación del alimento: Cous cous blanco\r\nCantidad neta del alimento:500 Gramos', 'Cous_cous_blanco_bio_280g.jpg', 'Bio', 161),
(84, 'Cous cous integral bio 500g', 'Ecocesta', '2.90', 41, 'Denominación del alimento: Cous cous integral\r\nCantidad neta del alimento:500 Gramos', 'Cous_cous_integral_bio_500g.jpg', 'Bio', 162),
(85, 'Copos de avena ecol&oacute;gica 500g', 'Carrefour', '1.77', 25, ' -', 'Copos_de_avena_ecologica_500g.jpg', 'Bio', 169),
(86, 'An&iacute;s verde 100g', 'Carrefour', '2.60', 32, 'Denominaci&oacute;n del alimento: An&iacutes Verde   \r\nCantidad neta del alimento: 100 Gramos', 'Anis_verde_100g.png', 'Bio', 170),
(87, 'Barra cereales chocolate 125g', 'Carrefour', '1.82', 78, 'Denominaci&oacute;n del alimento:Barritas de cereales con chocolate procedente de la agricultura ecol&oacute;gica.', 'Barra_cereales_chocolate_125g.png', 'Bio', 171),
(88, 'Barra cereales fresa 125g', 'Carrefour', '1.82', 69, ' -', 'Barra_cereales_fresa_125g.png', 'Bio', 172),
(89, 'Cafe molido natural 100% colombia 250g', 'Carrefour', '3.35', 38, 'Denominaci&oacute;n del alimento:Caf&eacute; molido de tueste natural', 'Cafe_molido_natural_100%_colombia_250g.png', 'Bio', 173),
(90, 'Cereales Corn Flakes 500g', 'Carrefour', '2.05', 120, 'Denominació&oacute;n del alimento:Copos de ma&iacute;z ecol&oacute;gicos sin az&uacute;cares añadidos', 'Cereales_Corn_Flakes_500g.png', 'Bio', 174),
(91, 'Cereales de fibra 450g', 'Ecocesta', '4.20', 74, 'Denominaci&oacute;n del alimento: Salvado completo \r\nCantidad neta del alimento: 450 Gramos', 'Cereales_de_fibra_450g.jpg', 'Bio', 181),
(92, 'Choco pops bio 375g', 'Ecocesta', '5.45', 38, 'Denominaci&oacute;n del alimento: Bolitas de cereales con cacao\r\nCantidad neta del alimento: 375 Gramos', 'Choco_pops_bio_375g.jpg', 'Bio', 182),
(93, 'Copos de 5 cereales bio 500g', 'Ecocesta', '2.10', 54, 'Denominaci&oacute;n del alimento: Copos de 5 cereales\r\nCantidad neta del alimento: 500 Gramos\r\n', 'Copos_de_5_cereales_bio_500g.jpg', 'Bio', 183),
(94, 'Copos de avena integrales bio 500g', 'Ecocesta', '2.09', 48, 'Denominaci&oacute;n del alimento: Copos de avena integrales\r\nCantidad neta del alimento:500 Gramos', 'Copos_de_avena_integrales_bio_500g.jpg', 'Bio', 184),
(95, 'Copos de maiz tostado bio 400g', 'Ecocesta', '3.19', 36, 'Denominaci&oacute;n del alimento: Copos de maíz tostado\r\nCantidad neta del alimento: 400 Gramos', 'Copos_de_maiz_tostado_bio_400g.jpg', 'Bio', 185),
(96, 'Crunchy frutas bio 375g', 'Ecocesta', '4.70', 12, 'Denominaci&oacute;n del alimento: Mezcla de copos \"crunchy\" con frutas deshidratadas\r\nCantidad neta del alimento: 375 Gramos\r\n', 'Crunchy_frutas_bio_375g.jpg', 'Bio', 186),
(97, 'Mermelada ecol&oacute;gica de albaricoque 350g', 'Helios', '2.29', 65, 'enominaci&oacute;n del alimento: Mermelada extra de albaricoque ecol&oacute;gica\r\nCantidad neta del alimento: 350 Gramos', 'Mermelada_ecologica_de_albaricoque_350.png', 'Bio', 193),
(98, 'Mermelada ecoll&oacute;gica de ciruela 350g', 'Helios', '2.29', 48, 'enominaci&oacute;n del alimento: Mermelada extra de ciruela ecol&oacute;gica\r\nCantidad neta del alimento: 350 ', 'Mermelada_ecologica_de_ciruela_350g.png', 'Bio', 194),
(99, 'Mermelada ecoll&oacute;gica de fresa 350g', 'Helios', '2.29', 49, 'enominaci&oacute;n del alimento: Mermelada extra de fresa ecol&oacute;gica\r\nCantidad neta del alimento: 350 ', 'Mermelada_ecologica_de_fresa.png', 'Bio', 195),
(100, 'Mermelada ecol&oacute;gica de naranja amarga 350g', 'Helios', '2.29', 36, 'enominaci&oacute;n del alimento: Mermelada extra de narnaja ecol&oacute;gica\r\nCantidad neta del alimento: 350 ', 'Mermelada_ecologica_de_naranja_amarga_350g.png', 'Bio', 196),
(101, 'Mermelada Ecol&oacutegica melocot&oacuten 350g', 'Helios', '2.29', 48, 'enominaci&oacute;n del alimento: Mermelada extra de melocot&oacute;ecol&oacute;gica\r\nCantidad neta del alimento: 350 ', 'Mermelada_ecologica_de_melocoton_350g.png', 'Bio', 197),
(102, 'Miel ecol&oacutegica de flores y lavanda silvestre 250', 'Granja San Francisco', '5.15', 5, ' -', 'Miel_ecol&ocautegica_de_flores_y_lavanda_silvestre_250.jpg', 'bio', 198),
(104, 'Barrita de coco bio 40g', 'Taste of Natura', '1.65', 0, 'Denominaci&oacute;n del alimento:Barrita ecol&oacute;gica a base de coco', 'Barrita_de_coco_bio_40g.png', 'Bio', 205),
(105, 'Barrita de granada bio 40g', 'Taste of Natura', '1.65', 69, 'Denominaci&oacute;n del alimento:Barrita ecol&oacute;gica a base de granada', 'Barrita_de_granada_bio_40g.png', 'Bio', 206),
(106, 'Barrita de manzana y canela bio 40g', 'Taste of Natura', '1.65', 59, 'Denominaci&oacute;n del alimento:Barrita ecol&oacute;gica a base de manzana y canela', 'Barrita_de_manzana_y_canela_bio_40g.png', 'Bio', 207),
(107, 'Barrita de nueces de brasil bio 40g', 'Taste of Natura', '1.65', 88, 'Denominaci&oacute;n del alimento:Barrita ecol&oacute;gica a base de frutos secos, semillas y nueces', 'Barrita_de_nueces_de_brasil_bio_40g.png', 'Bio', 208),
(108, 'Barrita Goji bio 40g', 'Taste of Natura', '1.65', 0, 'Denominaci&oacute;n del alimento:Barrita ecol&oacute;gica Goji', 'Barrita_Goji_bio_40g.png', 'Bio', 209),
(109, 'Barritas de almendras bio 40g', 'Taste of Natura', '1.65', 32, 'Denominaci&oacute;n del alimento:Barrita ecol&oacute;gica a base de frutos secos, semillas y cacahuetes', 'Barritas_de_almendras_bio_40g.png', 'Bio', 210);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
CREATE TABLE IF NOT EXISTS `ubicacion` (
  `idubicacion` int(10) NOT NULL AUTO_INCREMENT,
  `pasillo` int(10) NOT NULL,
  `modulo` int(10) NOT NULL,
  `altura` int(10) NOT NULL,
  `hueco` int(10) NOT NULL,
  PRIMARY KEY (`idubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`idubicacion`, `pasillo`, `modulo`, `altura`, `hueco`) VALUES
(1, 1, 2, 1, 1),
(2, 1, 2, 1, 2),
(3, 1, 2, 1, 3),
(4, 1, 2, 2, 1),
(5, 1, 2, 2, 2),
(6, 1, 2, 2, 3),
(13, 1, 4, 1, 1),
(14, 1, 4, 1, 2),
(15, 1, 4, 1, 3),
(16, 1, 4, 2, 1),
(17, 1, 4, 2, 2),
(18, 1, 4, 2, 3),
(25, 1, 6, 1, 1),
(26, 1, 6, 1, 2),
(27, 1, 6, 1, 3),
(28, 1, 6, 2, 1),
(29, 1, 6, 2, 2),
(30, 1, 6, 2, 3),
(37, 2, 1, 1, 1),
(38, 2, 1, 1, 2),
(39, 2, 1, 1, 3),
(40, 2, 1, 2, 1),
(41, 2, 1, 2, 2),
(42, 2, 1, 2, 3),
(49, 2, 2, 1, 1),
(50, 2, 2, 1, 2),
(51, 2, 2, 1, 3),
(52, 2, 2, 2, 1),
(53, 2, 2, 2, 2),
(54, 2, 2, 2, 3),
(61, 2, 3, 1, 1),
(62, 2, 3, 1, 2),
(63, 2, 3, 1, 3),
(64, 2, 3, 2, 1),
(65, 2, 3, 2, 2),
(66, 2, 3, 2, 3),
(73, 2, 4, 1, 1),
(74, 2, 4, 1, 2),
(75, 2, 4, 1, 3),
(76, 2, 4, 2, 1),
(77, 2, 4, 2, 2),
(78, 2, 4, 2, 3),
(85, 2, 5, 1, 1),
(86, 2, 5, 1, 2),
(87, 2, 5, 1, 3),
(88, 2, 5, 2, 1),
(89, 2, 5, 2, 2),
(90, 2, 5, 2, 3),
(97, 2, 6, 1, 1),
(98, 2, 6, 1, 2),
(99, 2, 6, 1, 3),
(100, 2, 6, 2, 1),
(101, 2, 6, 2, 2),
(102, 2, 6, 2, 3),
(109, 3, 1, 1, 1),
(110, 3, 1, 1, 2),
(111, 3, 1, 1, 3),
(112, 3, 1, 2, 1),
(113, 3, 1, 2, 2),
(114, 3, 1, 2, 3),
(121, 3, 2, 1, 1),
(122, 3, 2, 1, 2),
(123, 3, 2, 1, 3),
(124, 3, 2, 2, 1),
(125, 3, 2, 2, 2),
(126, 3, 2, 2, 3),
(133, 3, 3, 1, 1),
(134, 3, 3, 1, 2),
(135, 3, 3, 1, 3),
(136, 3, 3, 2, 1),
(137, 3, 3, 2, 2),
(138, 3, 3, 2, 3),
(145, 3, 4, 1, 1),
(146, 3, 4, 1, 2),
(147, 3, 4, 1, 3),
(148, 3, 4, 2, 1),
(149, 3, 4, 2, 2),
(150, 3, 4, 2, 3),
(157, 3, 5, 1, 1),
(158, 3, 5, 1, 2),
(159, 3, 5, 1, 3),
(160, 3, 5, 2, 1),
(161, 3, 5, 2, 2),
(162, 3, 5, 2, 3),
(169, 3, 6, 1, 1),
(170, 3, 6, 1, 2),
(171, 3, 6, 1, 3),
(172, 3, 6, 2, 1),
(173, 3, 6, 2, 2),
(174, 3, 6, 2, 3),
(181, 4, 1, 1, 1),
(182, 4, 1, 1, 2),
(183, 4, 1, 1, 3),
(184, 4, 1, 2, 1),
(185, 4, 1, 2, 2),
(186, 4, 1, 2, 3),
(193, 4, 2, 1, 1),
(194, 4, 2, 1, 2),
(195, 4, 2, 1, 3),
(196, 4, 2, 2, 1),
(197, 4, 2, 2, 2),
(198, 4, 2, 2, 3),
(205, 4, 3, 1, 1),
(206, 4, 3, 1, 2),
(207, 4, 3, 1, 3),
(208, 4, 3, 2, 1),
(209, 4, 3, 2, 2),
(210, 4, 3, 2, 3),
(211, 4, 3, 3, 1),
(212, 4, 3, 3, 2),
(213, 4, 3, 3, 3),
(214, 4, 3, 4, 1),
(215, 4, 3, 4, 2),
(216, 4, 3, 4, 3),
(217, 4, 4, 1, 1),
(218, 4, 4, 1, 2),
(219, 4, 4, 1, 3),
(220, 4, 4, 2, 1),
(221, 4, 4, 2, 2),
(222, 4, 4, 2, 3),
(223, 4, 4, 3, 1),
(224, 4, 4, 3, 2),
(225, 4, 4, 3, 3),
(226, 4, 4, 4, 1),
(227, 4, 4, 4, 2),
(228, 4, 4, 4, 3),
(229, 4, 5, 1, 1),
(230, 4, 5, 1, 2),
(231, 4, 5, 1, 3),
(232, 4, 5, 2, 1),
(233, 4, 5, 2, 2),
(234, 4, 5, 2, 3),
(235, 4, 5, 3, 1),
(236, 4, 5, 3, 2),
(237, 4, 5, 3, 3),
(238, 4, 5, 4, 1),
(239, 4, 5, 4, 2),
(240, 4, 5, 4, 3),
(241, 4, 6, 1, 1),
(242, 4, 6, 1, 2),
(243, 4, 6, 1, 3),
(244, 4, 6, 2, 1),
(245, 4, 6, 2, 2),
(246, 4, 6, 2, 3),
(247, 4, 6, 3, 1),
(248, 4, 6, 3, 2),
(249, 4, 6, 3, 3),
(250, 4, 6, 4, 1),
(251, 4, 6, 4, 2),
(252, 4, 6, 4, 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
