-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2021 at 05:09 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moviedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` int(12) NOT NULL,
  `title` varchar(250) NOT NULL,
  `details` text NOT NULL,
  `favorite` enum('Yes','No','','') DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `title`, `details`, `favorite`) VALUES
(1, 'Flame of Eugene', 'The series was adapted into a 42-episode anime television series by Pierrot, broadcast on Fuji TV.', 'Yes'),
(2, 'Tom and Bugs bunny', 'Tom and Jerry is an American animated media franchise and series of comedy short films.', 'No'),
(3, 'Ghost of Recca', 'YuYu Hakusho is a Japanese manga series written and illustrated.', 'No'),
(4, 'Malaala mo kaya', 'From March 14, 2020, the production of the program\'s new episodes were suspended.', 'Yes'),
(5, '24 Oras', '24 Oras (pronounced as bente kwatro oras / transl. 24 Hours) is a Philippine television news broadcasting show.', 'No'),
(6, 'Automatic Movie title', 'Automatic details added', 'Yes'),
(7, 'More Added title', 'More details automatic', 'No'),
(8, 'Ang TV na', 'Woww!!', 'Yes'),
(9, 'The Lion King', 'Come and see new detail', 'Yes'),
(10, 'Automatic Movie title', 'What did you add?', 'No'),
(11, 'The Lion King', 'Automatic details added', 'Yes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
