<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbName = "health";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbName);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 


$pid=   $_POST["patientid"];
$hr =   $_POST["temperature"];
$temp = $_POST["heartrate"];
$lbp =  $_POST["lbloodpressure"];
$hbp=   $_POST["hbloodpressure"];



$sql = ("INSERT INTO stats (pid,hr,lbp,hbp,temp)
VALUES ($pid, $hr,$lbp,$hbp,$temp)");


if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();

?>
