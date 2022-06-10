<?php

$connection = null;

try {
     // config
     $host = "localhost";
     $username = "root";
     $password = "";
     $dbname = "M-Transaksi";

     // connect
     $database = "mysql:dbname=$dbname;host=$host";
     $connection = new PDO($database, $username, $password);
     $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

     // melihat berhasil login atau tidak 
     // if ($connection) {
     //      # code...
     //      echo "koneksi berhasil";
     // } else {
     //      # code...
     //      echo "koneksi gagal";
     // }
} catch (PDOException $e) {
     echo "Error !! " . $e->getMessage();
     die;
}
?>