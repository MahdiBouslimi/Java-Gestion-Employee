-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 11 Janvier 2021 à 21:29
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `employer`
--

-- --------------------------------------------------------

--
-- Structure de la table `employerr`
--

CREATE TABLE IF NOT EXISTS `employerr` (
  `reference` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `tel_fixe` varchar(20) NOT NULL,
  `nmobile` varchar(20) NOT NULL,
  `resp_hirar` varchar(50) DEFAULT NULL,
  `service` varchar(50) DEFAULT NULL,
  `sos_pal` varchar(50) NOT NULL,
  PRIMARY KEY (`reference`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employerr`
--

INSERT INTO `employerr` (`reference`, `nom`, `tel_fixe`, `nmobile`, `resp_hirar`, `service`, `sos_pal`) VALUES
('meh', 'mahdi', '21385365', '21385365', 'polytech', 'informatique', 'infor');

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `login` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `login`
--

INSERT INTO `login` (`login`, `pwd`) VALUES
('admin', 'admin');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
