<?php 
include "connection.php";
    
    if ($_SERVER['REQUEST_METHOD'] == 'POST'){
        $email = $_POST['email'];    
        $password = $_POST['password'];
        $sql = "SELECT * FROM users WHERE email = '$email' AND password = '$password'";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
          while($row = $result->fetch_assoc()) {
            $_SESSION['email'] = $email;
            $_SESSION['password'] = $password;
            header('Location: addpost.html');
          }
        } else {
            echo "<script>
            alert('Wrong username/password');
            window.location.href='login.html';
            </script>";
        }
    }    
?>