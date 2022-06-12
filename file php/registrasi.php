<?php

include 'connection.php';

if($_POST) {
     // post data
     $id_admin = filter_input(INPUT_POST, 'id_admin', FILTER_SANITIZE_STRING);
     $nama_admin = filter_input(INPUT_POST, 'nama_admin', FILTER_SANITIZE_STRING);
     $password = filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING);
     $no_telp = filter_input(INPUT_POST, 'no_telp', FILTER_SANITIZE_STRING);

     $response = []; // simpan data

      // cek id di databse
     $userQuery = $connection->prepare("SELECT * FROM admin WHERE id_admin = ?");
     $userQuery->execute(array($id_admin));

     // cek id apa kah ada atau tidak
     if ($userQuery->rowCount() != 0) {
          # code...
          $response['status'] = false;
          $response['message'] = "id sudah ada";
     } else {
          $insertAccount = 'INSERT INTO admin (id_admin, nama_admin, password, no_telp) VALUES (:id_admin, :nama_admin, :password, :no_telp)';
          $statment = $connection->prepare($insertAccount);

          try {
               // eksekusi statment db 
               $statment->execute([
                    ':id_admin' => $id_admin,
                    ':nama_admin' => $nama_admin,
                    ':password' => md5($password),
                    ':no_telp' => $no_telp
               ]);
               // beri response
               $response['status'] = true;
               $response['message'] = 'Berhasil mendaftarkan admin';
               $response['data'] = [
                    'id_admin' => $id_admin,
                    'nama_admin' => $nama_admin,
                    'no_telp' => $no_telp
               ];
          } catch (Exception $e) {
               die($e->getMessage());
          }
     }
// jadikan data jadi json
$json = json_encode($response, JSON_PRETTY_PRINT);
echo $json;

}
?>