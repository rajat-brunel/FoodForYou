-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 16, 2017 at 12:56 PM
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
-- Table structure for table `rest_loca`
--

CREATE TABLE `rest_loca` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `latitude` int(32) NOT NULL,
  `longitude` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `rest_loca`
--

INSERT INTO `rest_loca` (`id`, `name`, `latitude`, `longitude`) VALUES
(1, 'Subway', 52, 0),
(2, 'Jacks Fish and Chips', 52, 0),
(3, 'Nandos', 52, 0),
(4, 'Chiquito', 52, 0),
(5, 'Zeera', 52, 0),
(6, 'Happy Days', 52, 0),
(7, 'Creams', 52, 0),
(8, 'Sukanya Restaurant', 52, 0),
(9, 'Yumchi', 52, 0),
(10, 'Pizza Express', 52, 0),
(11, 'Micks', 52, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rest_loca`
--
ALTER TABLE `rest_loca`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rest_loca`
--
ALTER TABLE `rest_loca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
