<?php
include "connection.php";

if ($_POST) {
     # Data
     $id_admin = $_POST['id_admin'] ?? '';
     $password = $_POST['password'] ?? '';

     $response = []; // simpan data

     // cek id di databse
     $userQuery = $connection->prepare("SELECT * FROM admin WHERE id_admin = ?");
     $userQuery->execute(array($id_admin));
     $query = $userQuery->fetch();

     if ($userQuery->rowCount() == 0) {
          # code...
          $response['status'] = false;
          $response['message'] = "Username tidak ditemukan";
     } else {
          // ambil password
          $passwordDb = $query['password'];

          // cek password
          if (strcmp(md5($password), $passwordDb) === 0) {
               # code...
               $response['status'] = true;
               $response['message'] = "Login berhasil";
               $response['data'] = [
                    'id_admin' => $query['id_admin'],
                    'nama_admin' => $query['nama_admin'],
                    'no_telp' => $query['no_telp']
               ];
          } else {
               $response['status'] = false;
               $response['message'] = "Password salah";
          }
     }

     // jadikan data jadi json 
     $json = json_encode($response, JSON_PRETTY_PRINT);

     // print
     echo $json;
}
?>
