<?php
session_start();
 
// Removing session data
if(isset($_SESSION["email"])){
    echo $_SESSION["email"];
    unset($_SESSION["lastname"]);
    unset($_SESSION["password"]);
    session_destroy();
}
?>