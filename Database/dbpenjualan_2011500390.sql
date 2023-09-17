-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Bulan Mei 2023 pada 05.20
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpenjualan_2011500390`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang_2011500390`
--

CREATE TABLE `barang_2011500390` (
  `KdBrg` varchar(6) NOT NULL,
  `NmBrg` varchar(50) NOT NULL,
  `Satuan` varchar(10) NOT NULL,
  `HargaBrg` int(6) NOT NULL,
  `Stok` int(3) NOT NULL,
  `KdKategori` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `barang_2011500390`
--

INSERT INTO `barang_2011500390` (`KdBrg`, `NmBrg`, `Satuan`, `HargaBrg`, `Stok`, `KdKategori`) VALUES
('B102', 'Lenovo', 'PCS', 5000000, 6, '1'),
('B103', 'Asus', 'PCS', 50000000, 15, '1'),
('B201', 'Razer', 'PCS', 500000, 5, '2'),
('B301', 'Dragon', 'PCS', 1200000, 10, '3'),
('B302', 'Asus', 'PCS', 10000, 0, '3'),
('B401', 'Airpods', 'PCS', 1000000, 95, '4'),
('B501', 'Samsung', 'DUS', 3000000, 9, '5'),
('B502', 'Iphone', 'DUS', 12000000, 9, '5');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buktipesan_2011500390`
--

CREATE TABLE `buktipesan_2011500390` (
  `NoPesan` varchar(255) NOT NULL,
  `TglPesan` date NOT NULL,
  `KdPlg` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `buktipesan_2011500390`
--

INSERT INTO `buktipesan_2011500390` (`NoPesan`, `TglPesan`, `KdPlg`) VALUES
('BP00001', '2023-05-30', '1'),
('BP000010', '2023-05-31', '2'),
('BP000011', '2023-05-31', '1'),
('BP000012', '2023-05-31', '2'),
('BP000013', '2023-05-31', '2'),
('BP00002', '2023-05-30', '1'),
('BP00003', '2023-05-30', '2'),
('BP00004', '2023-05-30', '2'),
('BP00005', '2023-05-30', '1'),
('BP00006', '2023-05-30', '1'),
('BP00007', '2023-05-30', '2'),
('BP00008', '2023-05-30', '1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detil_pesan_2011500390`
--

CREATE TABLE `detil_pesan_2011500390` (
  `NoPesan` varchar(255) NOT NULL,
  `KdBrg` varchar(6) NOT NULL,
  `HrgPesan` int(6) NOT NULL,
  `JmlPesan` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `detil_pesan_2011500390`
--

INSERT INTO `detil_pesan_2011500390` (`NoPesan`, `KdBrg`, `HrgPesan`, `JmlPesan`) VALUES
('BP00001', 'B401', 1000000, 32),
('BP000011', 'B401', 1000000, 1),
('BP000012', 'B301', 1200000, 1),
('BP000013', 'B301', 1200000, 1),
('BP00002', 'B102', 5000000, 1),
('BP00002', 'B302', 10000, 1),
('BP00002', 'B401', 1000000, 2),
('BP00003', 'B102', 5000000, 2),
('BP00003', 'B302', 10000, 2),
('BP00004', 'B302', 10000, 2),
('BP00005', 'B502', 12000000, 2),
('BP00006', 'B501', 3000000, 1),
('BP00006', 'B502', 12000000, 1),
('BP00007', 'B301', 1200000, 1),
('BP00007', 'B401', 1000000, 1),
('BP00008', 'B401', 1000000, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori_2011500390`
--

CREATE TABLE `kategori_2011500390` (
  `KdKategori` varchar(3) NOT NULL,
  `NmKategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kategori_2011500390`
--

INSERT INTO `kategori_2011500390` (`KdKategori`, `NmKategori`) VALUES
('1', 'Laptop'),
('2', 'Mouse'),
('3', 'Keyboard'),
('4', 'Earphone'),
('5', 'Phone');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan_2011500390`
--

CREATE TABLE `pelanggan_2011500390` (
  `KdPlg` varchar(6) NOT NULL,
  `NmPlg` varchar(50) DEFAULT NULL,
  `AlamatPlg` varchar(50) DEFAULT NULL,
  `TelpPlg` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan_2011500390`
--

INSERT INTO `pelanggan_2011500390` (`KdPlg`, `NmPlg`, `AlamatPlg`, `TelpPlg`) VALUES
('1', 'Januwa Putra', 'Jakarta', '089768'),
('2', 'Risky', 'Jakarta', '0897969');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas_2011500390`
--

CREATE TABLE `petugas_2011500390` (
  `KdPetugas` varchar(3) NOT NULL,
  `NmPetugas` varchar(50) NOT NULL,
  `AlamatPetugas` varchar(50) NOT NULL,
  `TelpPetugas` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `petugas_2011500390`
--

INSERT INTO `petugas_2011500390` (`KdPetugas`, `NmPetugas`, `AlamatPetugas`, `TelpPetugas`) VALUES
('1', 'januwa', 'jakarta\n', '0876789'),
('2', 'risky', 'jakarta', '08878'),
('3', 'Udin', 'Jakarta', '08987697'),
('4', 'Tony', 'Palembang', '097687079'),
('5', 'Steve', 'Bogor', '064802-86-29-42'),
('6', 'Mark Zuck', 'Surabaya', '079769680606'),
('7', 'ok', 'guvu', '89707'),
('8', 'mark', 'vuv', '09970');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ukuran_2011500390`
--

CREATE TABLE `ukuran_2011500390` (
  `Kdukuran` varchar(2) NOT NULL,
  `Ukuran` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `ukuran_2011500390`
--

INSERT INTO `ukuran_2011500390` (`Kdukuran`, `Ukuran`) VALUES
('1', '1111'),
('2', '11213'),
('3', '2342');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang_2011500390`
--
ALTER TABLE `barang_2011500390`
  ADD PRIMARY KEY (`KdBrg`);

--
-- Indeks untuk tabel `buktipesan_2011500390`
--
ALTER TABLE `buktipesan_2011500390`
  ADD PRIMARY KEY (`NoPesan`);

--
-- Indeks untuk tabel `detil_pesan_2011500390`
--
ALTER TABLE `detil_pesan_2011500390`
  ADD PRIMARY KEY (`NoPesan`,`KdBrg`);

--
-- Indeks untuk tabel `kategori_2011500390`
--
ALTER TABLE `kategori_2011500390`
  ADD PRIMARY KEY (`KdKategori`);

--
-- Indeks untuk tabel `pelanggan_2011500390`
--
ALTER TABLE `pelanggan_2011500390`
  ADD PRIMARY KEY (`KdPlg`);

--
-- Indeks untuk tabel `petugas_2011500390`
--
ALTER TABLE `petugas_2011500390`
  ADD PRIMARY KEY (`KdPetugas`);

--
-- Indeks untuk tabel `ukuran_2011500390`
--
ALTER TABLE `ukuran_2011500390`
  ADD PRIMARY KEY (`Kdukuran`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
