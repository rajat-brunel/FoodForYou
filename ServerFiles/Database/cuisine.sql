-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 19, 2017 at 12:42 PM
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
-- Table structure for table `test_1`
--

CREATE TABLE `test_1` (
  `filter_id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `post_code` varchar(32) NOT NULL,
  `img_res` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `test_1`
--

INSERT INTO `test_1` (`filter_id`, `name`, `post_code`, `img_res`) VALUES
(1, 'american', 'UB8 1LD', 'http://178.62.122.19/img/options/american.png'),
(2, 'chineese', 'UB10 0NS', 'http://178.62.122.19/img/options/chinese.png'),
(3, 'chicken', 'UB8 1LB', 'http://178.62.122.19/img/options/chicken.png'),
(4, 'Fish and chips', 'UB10 0AD', 'http://178.62.122.19/img/options/fish-and-chips.png'),
(5, 'Mexican', 'UB8 1GE', 'http://178.62.122.19/img/options/mexican.png'),
(6, 'Indian', 'UB10 9DA', 'http://178.62.122.19/img/options/indian.png'),
(8, 'Thai', 'UB9 5ET', 'http://178.62.122.19/img/options/thai.png'),
(9, 'Italian', 'UB8 1LD', 'http://178.62.122.19/img/options/italian%202.png'),
(10, 'Kebab', 'UB8 3AA', 'http://178.62.122.19/img/options/kebab.png'),
(11, 'Desserts', 'UB8 1QT', 'http://178.62.122.19/img/options/desserts.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `test_1`
--
ALTER TABLE `test_1`
  ADD PRIMARY KEY (`filter_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `test_1`
--
ALTER TABLE `test_1`
  MODIFY `filter_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
