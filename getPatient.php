<?php
//function dataRetrieve($pid)
$servername = "localhost";
$username = "root";
$password = "";
$dbName = "health";

$conn = new mysqli($servername, $username, $password, $dbName);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 


$pid = $_GET['pid'];
$db_result = mysqli_query($conn,"SELECT * FROM patientsrecord WHERE pid=$pid");

$result = array();

while($row = mysqli_fetch_array($db_result))
{
	
	array_push($result,
	array("pid"=>$row[0],
		"name"=>$row[1],
		"mobile"=>$row[2],
		"age"=>$row[3])
		);
}

header('Content-Type: application/json');
echo json_encode($result);

mysqli_close($conn);

?>