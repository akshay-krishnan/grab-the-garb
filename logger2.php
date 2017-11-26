<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbName = "health";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbName);
// Check connection
if ($conn->connect_error) 
{
    die("Connection failed: " . $conn->connect_error);
} 






$sql = ("INSERT INTO stats (pid,hr,lbp,hbp,temp)
VALUES ('".$_GET["id"]."','".$_GET["hb"]."' , '".$_GET["lbp"]."' , '".$_GET["hbp"]."' , '".$_GET["temp"]."')");   


if ($conn->query($sql) == TRUE)
	{
		echo "New record created successfully";
	} 
else 
	{
		echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();

?>
