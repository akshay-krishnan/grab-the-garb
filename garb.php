<?php


$servername = "localhost";
$username = "root";
$password = "";
$dbName = "tricon";

	$conn = new mysqli($servername, $username, $password, $dbName);
	// Check connection
	if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
	
	}
	
	
	$stmt = $conn->prepare("SELECT Name, Latitude, Longitude,Time, Garbage FROM garbage;");
       $stmt->execute();
        $stmt->bind_result($Name, $Latitude, $Longitude,$Time, $Garbage);
        $product = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		$temp['Name'] = $Name; 
		$temp['Latitude'] = $Latitude; 
		$temp['Longitude'] = $Longitude; 
		$temp['Time'] = $Time; 
		$temp['Garbage'] = $Garbage; 
		
		array_push($product, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($product);


		
mysqli_close($conn);
?>