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
$time= $_GET['time'];

$dbresult = mysqli_query($conn,"SELECT * FROM stats WHERE pid=$pid order by timestamp desc LIMIT $time");


$result = array();

while($row = mysqli_fetch_array($dbresult))
{
	
	array_push($result,
	array("pid"=>$row[1],
		"id"=>$row[0],
		"hr"=>$row[2],
		"lbp"=>$row[4],
		"hbp"=>$row[5],
		"temp"=>$row[3],
		"timestamp"=>$row[6]
	)
	);
}
header('Content-Type: application/json');
echo json_encode($result);

mysqli_close($conn);

?>