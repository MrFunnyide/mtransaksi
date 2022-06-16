-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 16 Jun 2022 pada 23.44
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `M-Transaksi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(11) NOT NULL,
  `nama_admin` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `no_telp` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `password`, `no_telp`) VALUES
('111', 'ajii', '827ccb0eea8a706c4c34a16891f84e7b', '89618095798'),
('123', 'Aji Bayu Permadi', '827ccb0eea8a706c4c34a16891f84e7b', '89618095798'),
('12345Aji', 'bayyu', '827ccb0eea8a706c4c34a16891f84e7b', '089716890845'),
('12345bay', 'bayyu', '827ccb0eea8a706c4c34a16891f84e7b', '089716890845'),
('12345bayu', 'bayyu', '827ccb0eea8a706c4c34a16891f84e7b', '089716890845'),
('123Aji', 'Aji Bayu Permadi', '827ccb0eea8a706c4c34a16891f84e7b', '89618095798');

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kode_brg` int(11) NOT NULL,
  `nama_brg` varchar(200) NOT NULL,
  `stok_brg` int(100) NOT NULL,
  `harga_brg` int(64) NOT NULL,
  `id_admin` varchar(11) NOT NULL,
  `img_url` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kode_brg`, `nama_brg`, `stok_brg`, `harga_brg`, `id_admin`, `img_url`) VALUES
(1, 'Keyboard Gaming', 5, 500000, '111', 'https://static.bmdstatic.com/gk/production/48a4445c1806775689a7ecbce35c1ee7.jpg'),
(2, 'HeadSet Gaming', 10, 230000, '111', 'https://carisinyal.com/wp-content/uploads/2017/09/Razer-BlackShark-V2_.webp'),
(3, 'MousePad', 5, 100000, '111', 'https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//95/MTA-7583324/sades_sades_mousepad_gaming_rind_full06_o0qzkh4b.jpg'),
(4, 'Mouse Gaming', 10, 500000, '111', 'https://ngelag.com/wp-content/uploads/2016/02/Dragonwar-Thor-G9-15-Mouse-Gaming-Murah-dan-Berkualitas-Bagus.jpg'),
(6, 'usb', 10, 80000, '111', 'https://www.westerndigital.com/content/dam/store/en-us/assets/products/usb-flash-drives/cruzer-blade-usb-2-0/gallery/cruzer-blade-usb-2-0-angle.png.thumb.1280.1280.png');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_brg`),
  ADD KEY `id_admin` (`id_admin`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `kode_brg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
