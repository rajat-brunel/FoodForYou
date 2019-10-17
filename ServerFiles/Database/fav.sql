-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 19, 2017 at 12:43 PM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food_for_you`
--

-- --------------------------------------------------------

--
-- Table structure for table `fav`
--

CREATE TABLE `fav` (
  `favo_id` int(11) NOT NULL,
  `email_fav` varchar(32) CHARACTER SET utf8 NOT NULL,
  `rest_fav` varchar(32) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fav`
--

INSERT INTO `fav` (`favo_id`, `email_fav`, `rest_fav`) VALUES
(15, '1534189@my.brunel.ac.uk', 'Pizza Express'),
(16, 'Guest', 'Happy Days'),
(17, 'Guest', 'Pizza Express'),
(18, 'ffvbbn@gfdd', 'Pizza Express'),
(19, 'Guest', 'Yumchi'),
(20, 'sharara.kabir@gmail.com', 'Pizza Express'),
(21, 'Guest', 'Micks'),
(22, '1534189@my.brunel.ac.uk', 'Nandos'),
(23, 'sharara.kabir@gmail.com', 'Creams'),
(25, 'sharara.kabir@gmail.com', 'Happy Days');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fav`
--
ALTER TABLE `fav`
  ADD PRIMARY KEY (`favo_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fav`
--
ALTER TABLE `fav`
  MODIFY `favo_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
