-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Mar 28 Janvier 2020 à 12:04
-- Version du serveur :  10.1.38-MariaDB-0+deb9u1
-- Version de PHP :  7.0.33-0+deb9u6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `biblio`
--

CREATE TABLE `biblio` (
  `id` int(11) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `autPrenom` varchar(25) NOT NULL,
  `autNom` varchar(25) NOT NULL,
  `presentation` varchar(100) NOT NULL,
  `parution` int(11) NOT NULL,
  `colonne` int(11) NOT NULL,
  `rangee` int(11) NOT NULL,
  `imgUrl` tinytext NOT NULL,
  `emprunt` tinyint(1) NOT NULL,
  `acquis` varchar(25) NOT NULL,
  `nomAcquis` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `biblio`
--

INSERT INTO `biblio` (`id`, `titre`, `autPrenom`, `autNom`, `presentation`, `parution`, `colonne`, `rangee`, `imgUrl`, `emprunt`, `acquis`, `nomAcquis`) VALUES
(1, 'Ready Player One', 'Ernest', 'Cline', '3 clés, 3 portes et de la réalité virtuelle.', 2013, 1, 1, '', 1, 'moi', 'MeeM'),
(2, 'De la Terre à la Lune', 'Jules', 'Vernes', 'Des américains tentent de tirer sur la Lune au canon.', 1865, 1, 2, '', 0, 'Moi', 'MeeM');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `biblio`
--
ALTER TABLE `biblio`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `biblio`
--
ALTER TABLE `biblio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
