<?php


$servername = "localhost";
$username = "root";
$password = "";
$dbName = "health";

	$conn = new mysqli($servername, $username, $password, $dbName);
	// Check connection
	if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
	
	}
	
	
	$dbresult1 = mysqli_query($conn,"SELECT * FROM patientsrecord");
	$result1 = array();

		while($row = mysqli_fetch_array($dbresult1))
		{
	
			array_push($result1,
			array("pid"=>$row[0],
			"name"=>$row[1]
			)
			);
		}

header('Content-Type: application/json');
echo json_encode($result1);

mysqli_close($conn);
?>