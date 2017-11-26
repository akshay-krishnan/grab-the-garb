<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbName = "health";
//$displayMessage= "Added successfully";
// Create connection
$conn = new mysqli($servername, $username, $password, $dbName);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 


$name= $_GET['name'];
$mobile = $_GET['mobile'];
$age = $_GET['age'];
//echo $name;

//echo $mobile;
//echo $age;

$sql = ("INSERT INTO patientsRecord (name,mobile,age)
VALUES ('$name','$mobile',$age)");

$result = new StdClass();
if ($conn->query($sql) === TRUE) {
     "New patient added successfully";
	 
	$result->status = 'success';	
} else {
	$result->status = 'error';    
}

echo json_encode($result);

$conn->close();

?>
