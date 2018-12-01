-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 01-12-2018 a las 16:38:43
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `qilicua_v1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banquete`
--

CREATE TABLE `banquete` (
  `BAQUETE_PK` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `BORRADO` varchar(1) COLLATE utf8_spanish_ci NOT NULL,
  `FECHA_ALTA` datetime NOT NULL,
  `FECHA_BAJA` datetime NOT NULL,
  `USUARIO_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_tipo_plato`
--

CREATE TABLE `cat_tipo_plato` (
  `TIPO_PLATO_PK` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `FECHA_ALTA` datetime NOT NULL,
  `FECHA_BAJA` datetime DEFAULT NULL,
  `BORRADO` varchar(1) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'N',
  `USUARIO_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coctel`
--

CREATE TABLE `coctel` (
  `COCTEL_PK` int(11) NOT NULL,
  `NOMBRE` int(50) NOT NULL,
  `BORRADO` varchar(1) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'N',
  `FECHA_ALTA` datetime NOT NULL,
  `FECHA_BAJA` datetime NOT NULL,
  `USUARIO_FK` int(11) NOT NULL,
  `COMENSALES` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

CREATE TABLE `evento` (
  `EVENTO_PK` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `BORRADO` varchar(1) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'N',
  `FECHA_ALTA` date NOT NULL,
  `FECHA_BAJA` date DEFAULT NULL,
  `USUARIO_FK` int(11) DEFAULT NULL,
  `COMENSALES` int(11) NOT NULL,
  `OBSERVACIONES` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `ENCARGADO` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `RECENA_FK` int(11) DEFAULT NULL,
  `COCTEL_FK` int(11) DEFAULT NULL,
  `BANQUETE_FK` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `evento`
--

INSERT INTO `evento` (`EVENTO_PK`, `NOMBRE`, `BORRADO`, `FECHA_ALTA`, `FECHA_BAJA`, `USUARIO_FK`, `COMENSALES`, `OBSERVACIONES`, `ENCARGADO`, `RECENA_FK`, `COCTEL_FK`, `BANQUETE_FK`) VALUES
(3, 'Boda Laura y Alberto', 'N', '2017-10-04', '2018-01-01', 1, 67, 'Boda al aire libre', 'Juanjo Gutierrez', NULL, NULL, NULL),
(4, 'Boda Ana y Luis', 'N', '2018-01-20', NULL, 1, 123, '', 'Jose Enrique Poveda', NULL, NULL, NULL),
(5, 'Bodas de oro Marcelino y Paqui', 'N', '2018-03-08', '2018-03-23', 1, 0, '', 'Luis Castro', NULL, NULL, NULL),
(6, 'Boda Jaime y María', 'N', '2018-04-20', NULL, NULL, 123, '', 'Jose Enrique Poveda', NULL, NULL, NULL),
(7, 'Catering DELOITTE', 'N', '2018-07-08', '2018-03-23', NULL, 0, '', 'Luis Castro', NULL, NULL, NULL),
(8, 'Cena fin de año NEORIS', 'N', '2018-04-20', NULL, NULL, 123, '', 'Luis Castro', NULL, NULL, NULL),
(9, 'Boda Teresa y Nacho', 'N', '2018-07-08', '2018-02-19', NULL, 0, '', 'Luis Castro', NULL, NULL, NULL),
(10, 'Boda Adriana y Victor', 'N', '2018-04-20', NULL, NULL, 123, '', 'Jose Enrique Poveda', NULL, NULL, NULL),
(11, 'Boda Bea y Taysir', 'N', '2018-05-03', '2018-03-23', NULL, 0, 'Boda de ensueño', 'Luis Castro', NULL, NULL, NULL),
(12, 'Boda Ramsés y Tuvilla', 'N', '2018-04-20', NULL, NULL, 123, 'Boda romantica si o si', 'Jose Enrique Poveda', NULL, NULL, NULL),
(13, 'Celebración TGK', 'N', '2018-10-08', '2018-03-23', NULL, 0, '', 'Luis Castro', NULL, NULL, NULL),
(14, 'Boda Luna y Javi', 'N', '2018-04-20', NULL, NULL, 123, '', 'Jose Enrique Poveda', NULL, NULL, NULL),
(15, 'Boda Ana y Jenny', 'N', '2018-07-08', '2018-03-23', NULL, 0, '', 'Luis Castro', NULL, NULL, NULL),
(16, 'Borja y Nerea', 'N', '2018-04-20', NULL, NULL, 123, '', 'Jose Enrique Poveda', NULL, NULL, NULL),
(17, 'Catering FLUOX', 'N', '2017-01-09', '2018-03-23', NULL, 0, '', 'Luis Castro', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredientes`
--

CREATE TABLE `ingredientes` (
  `INGREDIENTES_PK` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `BORRADO` varchar(1) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'N',
  `FECHA_ALTA` datetime NOT NULL,
  `FECHA_BAJA` datetime DEFAULT NULL,
  `USUARIO_FK` int(10) NOT NULL,
  `ALERGENOS_FK` int(10) DEFAULT NULL,
  `NUTRIENTES_FK` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla de ingredientes';

--
-- Volcado de datos para la tabla `ingredientes`
--

INSERT INTO `ingredientes` (`INGREDIENTES_PK`, `NOMBRE`, `BORRADO`, `FECHA_ALTA`, `FECHA_BAJA`, `USUARIO_FK`, `ALERGENOS_FK`, `NUTRIENTES_FK`) VALUES
(2, 'TOMATE', 'N', '2018-11-17 00:00:00', NULL, 1, NULL, NULL),
(3, 'QUESO', 'N', '2018-11-17 00:00:00', NULL, 1, NULL, NULL),
(4, 'HUEVO', 'N', '2018-11-17 00:00:00', NULL, 1, NULL, NULL),
(5, 'ATUN', 'N', '2018-11-17 00:00:00', NULL, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platos`
--

CREATE TABLE `platos` (
  `PLATOS_PK` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `BORRADO` varchar(1) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'N',
  `FECHA_ALTA` datetime NOT NULL,
  `FECHA_BAJA` datetime DEFAULT NULL,
  `USUARIO_FK` int(11) NOT NULL,
  `TIPO_PLATO_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `platos`
--

INSERT INTO `platos` (`PLATOS_PK`, `NOMBRE`, `BORRADO`, `FECHA_ALTA`, `FECHA_BAJA`, `USUARIO_FK`, `TIPO_PLATO_FK`) VALUES
(1, 'SALMOREJO', 'N', '2018-11-17 00:00:00', NULL, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puestos`
--

CREATE TABLE `puestos` (
  `PUESTO_PK` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `BORRADO` varchar(1) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'N',
  `FECHA_ALTA` datetime NOT NULL,
  `FECHA_BAJA` datetime NOT NULL,
  `USUARIO_FK` int(11) NOT NULL,
  `TIPO_PUESTO_FK` int(11) NOT NULL,
  `COMENSALES` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recena`
--

CREATE TABLE `recena` (
  `RECENA_PK` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `BORRADO` varchar(1) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'N',
  `FECHA_ALTA` datetime NOT NULL,
  `FECHA_BAJA` datetime NOT NULL,
  `USUARIO_FK` int(11) NOT NULL,
  `COMENSALES` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relacion_banquete_plat`
--

CREATE TABLE `relacion_banquete_plat` (
  `BANQUETE_PLAT_PK` int(11) NOT NULL,
  `BANQUETE_FK` int(11) NOT NULL,
  `PLATOS_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relacion_coctel_plat`
--

CREATE TABLE `relacion_coctel_plat` (
  `COCTEL_PLAT_PK` int(11) NOT NULL,
  `COCTEL_FK` int(11) NOT NULL,
  `PLATOS_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relacion_platos_ingredientes`
--

CREATE TABLE `relacion_platos_ingredientes` (
  `PLAT_ING_PK` int(11) NOT NULL,
  `INGREDIENTES_FK` int(11) NOT NULL,
  `PLATOS_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `relacion_platos_ingredientes`
--

INSERT INTO `relacion_platos_ingredientes` (`PLAT_ING_PK`, `INGREDIENTES_FK`, `PLATOS_FK`) VALUES
(5, 2, 1),
(6, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relacion_puestos_plat`
--

CREATE TABLE `relacion_puestos_plat` (
  `PUESTOS_PLAT_PK` int(11) NOT NULL,
  `PUESTOS_FK` int(11) NOT NULL,
  `PLATOS_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relacion_recena_puestos`
--

CREATE TABLE `relacion_recena_puestos` (
  `RECENA_PUESTOS_PK` int(11) NOT NULL,
  `RECENA_FK` int(11) NOT NULL,
  `PUESTOS_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Users`
--

CREATE TABLE `Users` (
  `uid` int(20) NOT NULL,
  `uname` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `Users`
--

INSERT INTO `Users` (`uid`, `uname`, `password`) VALUES
(1, 'quilicua', 'quili01');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `banquete`
--
ALTER TABLE `banquete`
  ADD PRIMARY KEY (`BAQUETE_PK`);

--
-- Indices de la tabla `cat_tipo_plato`
--
ALTER TABLE `cat_tipo_plato`
  ADD PRIMARY KEY (`TIPO_PLATO_PK`);

--
-- Indices de la tabla `coctel`
--
ALTER TABLE `coctel`
  ADD PRIMARY KEY (`COCTEL_PK`);

--
-- Indices de la tabla `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`EVENTO_PK`);

--
-- Indices de la tabla `ingredientes`
--
ALTER TABLE `ingredientes`
  ADD PRIMARY KEY (`INGREDIENTES_PK`);

--
-- Indices de la tabla `platos`
--
ALTER TABLE `platos`
  ADD PRIMARY KEY (`PLATOS_PK`);

--
-- Indices de la tabla `puestos`
--
ALTER TABLE `puestos`
  ADD PRIMARY KEY (`PUESTO_PK`);

--
-- Indices de la tabla `recena`
--
ALTER TABLE `recena`
  ADD PRIMARY KEY (`RECENA_PK`);

--
-- Indices de la tabla `relacion_banquete_plat`
--
ALTER TABLE `relacion_banquete_plat`
  ADD PRIMARY KEY (`BANQUETE_PLAT_PK`);

--
-- Indices de la tabla `relacion_coctel_plat`
--
ALTER TABLE `relacion_coctel_plat`
  ADD PRIMARY KEY (`COCTEL_PLAT_PK`);

--
-- Indices de la tabla `relacion_platos_ingredientes`
--
ALTER TABLE `relacion_platos_ingredientes`
  ADD PRIMARY KEY (`PLAT_ING_PK`),
  ADD UNIQUE KEY `INGREDIENTES_FK` (`INGREDIENTES_FK`,`PLATOS_FK`),
  ADD KEY `PLATOS_FK` (`PLATOS_FK`);

--
-- Indices de la tabla `relacion_puestos_plat`
--
ALTER TABLE `relacion_puestos_plat`
  ADD PRIMARY KEY (`PUESTOS_PLAT_PK`);

--
-- Indices de la tabla `relacion_recena_puestos`
--
ALTER TABLE `relacion_recena_puestos`
  ADD PRIMARY KEY (`RECENA_PUESTOS_PK`);

--
-- Indices de la tabla `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `uname` (`uname`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `banquete`
--
ALTER TABLE `banquete`
  MODIFY `BAQUETE_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cat_tipo_plato`
--
ALTER TABLE `cat_tipo_plato`
  MODIFY `TIPO_PLATO_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `coctel`
--
ALTER TABLE `coctel`
  MODIFY `COCTEL_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `evento`
--
ALTER TABLE `evento`
  MODIFY `EVENTO_PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `ingredientes`
--
ALTER TABLE `ingredientes`
  MODIFY `INGREDIENTES_PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `platos`
--
ALTER TABLE `platos`
  MODIFY `PLATOS_PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `puestos`
--
ALTER TABLE `puestos`
  MODIFY `PUESTO_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recena`
--
ALTER TABLE `recena`
  MODIFY `RECENA_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `relacion_banquete_plat`
--
ALTER TABLE `relacion_banquete_plat`
  MODIFY `BANQUETE_PLAT_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `relacion_coctel_plat`
--
ALTER TABLE `relacion_coctel_plat`
  MODIFY `COCTEL_PLAT_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `relacion_platos_ingredientes`
--
ALTER TABLE `relacion_platos_ingredientes`
  MODIFY `PLAT_ING_PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `relacion_puestos_plat`
--
ALTER TABLE `relacion_puestos_plat`
  MODIFY `PUESTOS_PLAT_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `relacion_recena_puestos`
--
ALTER TABLE `relacion_recena_puestos`
  MODIFY `RECENA_PUESTOS_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Users`
--
ALTER TABLE `Users`
  MODIFY `uid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `relacion_platos_ingredientes`
--
ALTER TABLE `relacion_platos_ingredientes`
  ADD CONSTRAINT `relacion_platos_ingredientes_ibfk_1` FOREIGN KEY (`PLATOS_FK`) REFERENCES `platos` (`PLATOS_PK`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `relacion_platos_ingredientes_ibfk_2` FOREIGN KEY (`INGREDIENTES_FK`) REFERENCES `ingredientes` (`INGREDIENTES_PK`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
