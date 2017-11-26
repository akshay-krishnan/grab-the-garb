<?php
    $con=mysqli_connect("localhost","root","","health");
    // Check connection
    if (mysqli_connect_errno())
      {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
      }

    $result = mysqli_query($con,"SELECT * FROM data order by timestamp desc LIMIT 5");

    while($row = mysqli_fetch_array($result))
      {
      echo $row['id'] . " " . $row['hr']. " ". $row['bp']. " ". $row['temp']; 
      echo "<br />";
      }

    mysqli_close($con);
    ?>