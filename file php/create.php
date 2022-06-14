<?php
$host = "localhost";
$user = "root";
$pass = "";
$db = "M-Transaksi";

$koneksi = mysqli_connect($host, $user, $pass, $db) or die("Database MYSQL TIdak terhubung");

$response = array();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
     # code...
     $nama_brg = $_POST["nama_brg"];
     $stok_brg = $_POST["stok_brg"];
     $harga_brg = $_POST["harga_brg"];
     $id_admin = $_POST["id_admin"];

     $perintah = "INSERT INTO barang (nama_brg, stok_brg, harga_brg, id_admin) VALUES('$nama_brg','$stok_brg','$harga_brg','$id_admin')";
     $eksekusi = mysqli_query($koneksi, $perintah);
     $cek = mysqli_affected_rows($koneksi);

     if ($cek > 0 ) {
          # code...
          $response["kode"] = 1;
          $response["pesan"] = "Data Berhasil Di Simpan";
     } else {
          $response["kode"] = 0;
          $response["pesan"] = "Gagal Menyimpan Data";
     }
} else {
     $response["kode"] = 0;
     $response["pesan"] = "Tidak ada data yang di masukkan";
}

echo json_encode($response);
mysqli_close($koneksi);
?>