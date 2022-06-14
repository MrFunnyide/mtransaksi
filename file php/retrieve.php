<?php
$host = "localhost";
$user = "root";
$pass = "";
$db = "M-Transaksi";

$koneksi = mysqli_connect($host, $user, $pass, $db) or die("Database MYSQL TIdak terhubung");

// retrieve data
$perintah = "SELECT *  FROM barang";
$eksekusi = mysqli_query($koneksi, $perintah);
$cek = mysqli_affected_rows($koneksi);

if ($cek > 0 ) {
     $response['kode'] = 1;
     $response['pesan'] = "Data Tersedia";
     $response['data'] = array();

     while ($ambil = mysqli_fetch_object($eksekusi)) {
          # code...
          $F["kode_brg"] = $ambil->kode_brg;
          $F["nama_brg"] = $ambil->nama_brg;
          $F["stok_brg"] = $ambil->stok_brg;
          $F["harga_brg"] = $ambil->harga_brg;
          $F["id_admin"] = $ambil->id_admin;

          array_push($response['data'], $F);

     }
} else {
     $response['kode'] = 0;
     $response['pesan'] = "Data tidak tersedia";
}

echo json_encode($response);
mysqli_close($koneksi);
?>