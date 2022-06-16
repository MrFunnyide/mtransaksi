<?php
$host = "localhost";
$user = "root";
$pass = "";
$db = "M-Transaksi";

$koneksi = mysqli_connect($host, $user, $pass, $db) or die("Database MYSQL TIdak terhubung");

$response = array();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
     # code...
     $kode_brg = $_POST["kode_brg"];

     $perintah = "DELETE FROM barang WHERE kode_brg = '$kode_brg'";
     $eksekusi = mysqli_query($koneksi, $perintah);
     $cek = mysqli_affected_rows($koneksi);

     if ($cek > 0 ) {
          # code...
          $response["kode"] = 1;
          $response["pesan"] = "Data Berhasil Di Hapus";
     } else {
          $response["kode"] = 0;
          $response["pesan"] = "Gagal Menghapus Data";
     }
} else {
     $response["kode"] = 0;
     $response["pesan"] = "Tidak ada data yang di post";
}

echo json_encode($response);
mysqli_close($koneksi);
?>