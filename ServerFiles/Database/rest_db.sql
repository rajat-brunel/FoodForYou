-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 14, 2017 at 03:17 PM
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
-- Table structure for table `rest_db`
--

CREATE TABLE `rest_db` (
  `res_id` int(11) NOT NULL,
  `res_name` varchar(128) NOT NULL,
  `res_logo` varchar(128) NOT NULL,
  `res_type` varchar(128) NOT NULL,
  `res_post` varchar(128) NOT NULL,
  `res_menu` varchar(128) NOT NULL,
  `res_bck_img` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rest_db`
--

INSERT INTO `rest_db` (`res_id`, `res_name`, `res_logo`, `res_type`, `res_post`, `res_menu`, `res_bck_img`) VALUES
(1, 'Subway', 'http://178.62.122.19/img/logo/subway.jpg', 'American', 'UB8 1LD', 'http://www.subway.com/en-gb/menunutrition/menu', 'http://178.62.122.19/img/bg/subway.jpg'),
(2, 'Jacks Fish and Chips', 'http://178.62.122.19/img/logo/Jack.png', 'Fish and Chips', 'UB10 0AD', 'https://jacksfishandchips.co.uk/our_menu.php?categoryId=97979#collapse310308', 'http://178.62.122.19/img/bg/fish_n_chips.jpg'),
(3, 'Nandos', 'http://178.62.122.19/img/logo/nandos.jpg', 'Chicken', 'UB8 1LB', 'http://178.62.122.19/img/menu/nandos.pdf', 'http://178.62.122.19/img/bg/nandos.jpg'),
(4, 'Chiquito', 'http://178.62.122.19/img/logo/chiquito.jpg', 'Mexican', 'UB8 1GE', 'http://178.62.122.19/img/menu/chiquito.pdf', 'http://178.62.122.19/img/bg/chiquito.jpg'),
(5, 'Zeera', 'http://178.62.122.19/img/logo/Zeera.png', 'Indian', 'UB10 9DA', 'http://178.62.122.19/img/menu/Zeera.pdf', 'http://178.62.122.19/img/bg/zeera.jpg'),
(6, 'Happy Days', 'http://178.62.122.19/img/logo/happy%20Days.png', 'Desserts', 'UB8 1JZ', 'http://178.62.122.19/img/menu/happy-days.jpg', 'http://178.62.122.19/img/bg/happy_days.jpg'),
(7, 'Creams', 'http://178.62.122.19/img/logo/creams.png', 'Desserts', 'UB8 1QT', 'http://creamscafe.com/menu.php', 'http://178.62.122.19/img/bg/creams.jpg'),
(8, 'Sukanya Restaurant', 'http://178.62.122.19/img/logo/sukanya.png', 'Thai', 'UB9 5ET', 'http://www.sukanyathai.co.uk/sukanya-menu.pdf ', 'http://178.62.122.19/img/bg/thai.jpg'),
(9, 'Yumchi', 'http://178.62.122.19/img/logo/yumchi.jpg', 'Chineese', 'UB10 0NS', 'https://www.zomato.com/london/yumchi-hayes/menu#tabtop', 'http://178.62.122.19/img/bg/yumchi.jpg'),
(10, 'Pizza Express', 'http://178.62.122.19/img/logo/pizza_express.png', 'Italian', 'UB8 1LD', 'http://178.62.122.19/img/menu/pizza_exp.pdf', 'http://178.62.122.19/img/bg/pizza-express.jpg'),
(11, 'Micks', 'http://178.62.122.19/img/logo/micks.png', 'Kebab', 'UB8 3AA', 'http://www.mickskebabhouse.co.uk/uxbridge/menu/collection.html', 'http://178.62.122.19/img/bg/micks.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rest_db`
--
ALTER TABLE `rest_db`
  ADD PRIMARY KEY (`res_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rest_db`
--
ALTER TABLE `rest_db`
  MODIFY `res_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
