-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 23 Mei 2019 pada 16.49
-- Versi Server: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `shodaqoh`
--

CREATE TABLE `shodaqoh` (
  `id` int(11) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Nominal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `shodaqoh`
--

INSERT INTO `shodaqoh` (`id`, `Nama`, `Nominal`) VALUES
(1, 'asf', 67),
(2, 'asdf', 45),
(4, 'saf', 214),
(5, '8765', 124);

-- --------------------------------------------------------

--
-- Struktur dari tabel `zakatfitrah`
--

CREATE TABLE `zakatfitrah` (
  `id` int(100) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `JmlAnggota` int(11) NOT NULL,
  `Nominal` int(11) NOT NULL,
  `Beras` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `zakatfitrah`
--

INSERT INTO `zakatfitrah` (`id`, `Nama`, `JmlAnggota`, `Nominal`, `Beras`) VALUES
(1, 'asdasd', 2, 20000, 0),
(4, 'weewff', 2, 0, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `shodaqoh`
--
ALTER TABLE `shodaqoh`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zakatfitrah`
--
ALTER TABLE `zakatfitrah`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `shodaqoh`
--
ALTER TABLE `shodaqoh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `zakatfitrah`
--
ALTER TABLE `zakatfitrah`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
