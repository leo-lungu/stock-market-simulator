<?php
include "connection.php";    

    if ($_SERVER['REQUEST_METHOD'] == 'POST'){
        $title = $_POST['title'];    
            $bodytext = $_POST['comment'];   
            $date = date('Y-m-d');
            $time = date('h:i:s'); 
            $sql = "INSERT INTO POSTS (title, bodytext, date, time) VALUES ('$title', '$bodytext', '$date', '$time')";
        if ($conn->query($sql) === TRUE) { 
            echo "done";
            } else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }
}
    $conn->close();
?>