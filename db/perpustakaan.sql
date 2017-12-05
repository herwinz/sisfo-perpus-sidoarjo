-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 02, 2014 at 11:53 
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_buku`
--

CREATE TABLE IF NOT EXISTS `tb_buku` (
  `id_buku` char(4) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `isbn` varchar(100) NOT NULL,
  `pengarang` varchar(100) NOT NULL,
  `penerbit` varchar(100) NOT NULL,
  `tahun_buku` year(4) NOT NULL,
  PRIMARY KEY (`id_buku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_buku`
--

INSERT INTO `tb_buku` (`id_buku`, `judul_buku`, `isbn`, `pengarang`, `penerbit`, `tahun_buku`) VALUES
('B001', 'Buku Pintar PHP MySQLaaaahh', '97979431433', 'Andrea Adelheid', 'MediaKIta', 2012),
('B002', 'Struktur Data dan Pemrograman dengan Pascal', '9797314464', 'Kusrini Iskandar', 'Andi', 2004),
('B003', 'Belajar Pemrograman dengan Bahasa C++ dan Java', '9791153078', 'M Shalahuddin', 'Informatika', 2007),
('B004', 'Kitab Suci Jaringan Komputer dan Koneksi Internet', '9798771664', 'Hasnul Arifin', 'MediaKom', 2002),
('B005', 'Tangkas Biologi SMP', '9798767655342', 'Adi Gunawan', 'Kartika', 2001),
('B006', 'Go! Blog', '9791167176', 'Assep Purna Mulyanto', 'Oase Media', 2008),
('B007', 'Program Linear 2', '977367814', 'Ucha', 'Chacha', 2012),
('B008', 'guru terbaiksss', '97967524', 'jamaikkah', 'airlungguhf', 2014),
('B009', 'guru tercantik', '9712783', 'nether', 'barata', 2016),
('B010', 'guru terunyu', '971278323', 'hawkeye', 'cucok', 2020);

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_peminjaman`
--

CREATE TABLE IF NOT EXISTS `tb_detail_peminjaman` (
  `id_detail_peminjaman` char(4) NOT NULL,
  `id_buku` varchar(100) NOT NULL,
  `id_peminjaman` varchar(100) NOT NULL,
  PRIMARY KEY (`id_detail_peminjaman`),
  KEY `fk_id_buku` (`id_buku`),
  KEY `fk_id_peminjaman` (`id_peminjaman`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detail_peminjaman`
--

INSERT INTO `tb_detail_peminjaman` (`id_detail_peminjaman`, `id_buku`, `id_peminjaman`) VALUES
('D001', 'B002', 'J001'),
('D002', 'B003', 'J001'),
('D003', 'B004', 'J002'),
('D004', 'B003', 'J002'),
('D005', 'B001', 'J005'),
('D006', 'B001', 'J006'),
('D008', 'B001', 'J006'),
('D009', 'B002', 'J007'),
('D010', 'B001', 'J001'),
('D011', 'B007', 'J007'),
('D012', 'B001', 'J001');

-- --------------------------------------------------------

--
-- Table structure for table `tb_karyawan`
--

CREATE TABLE IF NOT EXISTS `tb_karyawan` (
  `id_karyawan` char(4) NOT NULL,
  `nama_karyawan` varchar(100) NOT NULL,
  `alamat_karyawan` varchar(100) NOT NULL,
  `hp_karyawan` varchar(100) NOT NULL,
  PRIMARY KEY (`id_karyawan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_karyawan`
--

INSERT INTO `tb_karyawan` (`id_karyawan`, `nama_karyawan`, `alamat_karyawan`, `hp_karyawan`) VALUES
('K001', 'Herwindra Berlian', 'Anusapati Street Gedangan', '081939115544'),
('K002', 'Putu Ika OKtiyari ', 'Taman', '089765654543'),
('K003', 'Putri Ariasih', 'Sukodono', '087123234345');

-- --------------------------------------------------------

--
-- Table structure for table `tb_member`
--

CREATE TABLE IF NOT EXISTS `tb_member` (
  `id_member` char(4) NOT NULL,
  `nama_member` varchar(100) NOT NULL,
  `alamat_member` varchar(100) NOT NULL,
  `hp_member` varchar(100) NOT NULL,
  PRIMARY KEY (`id_member`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_member`
--

INSERT INTO `tb_member` (`id_member`, `nama_member`, `alamat_member`, `hp_member`) VALUES
('M001', 'Evi Windariya', 'Candi', '089786453241'),
('M002', 'Rima Sintia Agustin', 'Porong', '087675345213'),
('M003', 'Sukma Prativa', 'Waru', '086754565555'),
('M004', 'Dian Sri Lestari', 'Sidoarjo', '081337567890'),
('M005', 'sri wulan', 'Taman', '081337567890');

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman`
--

CREATE TABLE IF NOT EXISTS `tb_peminjaman` (
  `id_peminjaman` char(4) NOT NULL,
  `id_member` char(4) DEFAULT NULL,
  `id_karyawan` char(4) DEFAULT NULL,
  `jumlah_buku` int(11) DEFAULT NULL,
  `tanggal_peminjaman` date DEFAULT NULL,
  `tanggal_pengembalian` date DEFAULT NULL,
  `tanggal_deadline_pengembalian` date DEFAULT NULL,
  PRIMARY KEY (`id_peminjaman`),
  KEY `fk_id_member` (`id_member`),
  KEY `fk_id_karyawan` (`id_karyawan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_peminjaman`
--

INSERT INTO `tb_peminjaman` (`id_peminjaman`, `id_member`, `id_karyawan`, `jumlah_buku`, `tanggal_peminjaman`, `tanggal_pengembalian`, `tanggal_deadline_pengembalian`) VALUES
('J001', 'M001', 'K002', 10, '2012-05-10', '2014-01-08', '2012-05-17'),
('J002', 'M002', 'K001', 2, '2012-10-12', '2012-10-15', '2010-10-24'),
('J003', 'M003', 'K002', 2, '2012-12-11', '2012-12-15', '2012-12-20'),
('J004', 'M003', 'K003', 2, '2012-10-13', '2012-10-15', '2012-10-20'),
('J005', 'M001', 'K001', 1, '2012-09-12', '2014-01-08', '2012-09-19'),
('J006', 'M002', 'K001', 2, '2012-10-13', '2012-10-15', '2012-10-20'),
('J007', 'M001', 'K003', 1, '2010-10-12', '2014-01-08', '2010-10-16');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_detail_peminjaman`
--
ALTER TABLE `tb_detail_peminjaman`
  ADD CONSTRAINT `FK_tb_detail_peminjaman_with_tb_buku` FOREIGN KEY (`id_buku`) REFERENCES `tb_buku` (`id_buku`),
  ADD CONSTRAINT `FK_tb_detail_peminjaman_with_tb_peminjaman` FOREIGN KEY (`id_peminjaman`) REFERENCES `tb_peminjaman` (`id_peminjaman`);

--
-- Constraints for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  ADD CONSTRAINT `FK_tb_peminjaman_with_tb_karyawan` FOREIGN KEY (`id_karyawan`) REFERENCES `tb_karyawan` (`id_karyawan`),
  ADD CONSTRAINT `FK_tb_peminjaman_with_tb_member` FOREIGN KEY (`id_member`) REFERENCES `tb_member` (`id_member`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
