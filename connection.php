<?php
    $servername = "localhost:3306";
    $username = "root";
    $password = "root";
    $dbname = "bloggers";

    session_start();

    // Creates connection
    $conn = new mysqli($servername, $username, $password, $dbname);
    // Checks connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
?>