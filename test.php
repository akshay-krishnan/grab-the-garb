<?php
	// Account details
	$uname = "sushruthn96@gmail.com";
        $pword ="Chemistry12";
        $info ="1";
        $test="0";
        
	
	// Message details
        $from ="Sush";
	$selectednums="918762357332";
	
	$message = "hello";
        $message=urlencode($message);
	
        
	// Prepare data for POST request
	
        $data="uname=".$uname."&pword=".$pword."&message=".$message."&from=". $from."&selectednums=".$selectednums."&info=".$info."&test=".$test;
	// Send the POST request with cURL
	$ch = curl_init('https://www.txtlocal.in/sendsmspost.php');
	curl_setopt($ch, CURLOPT_POST, true);
        
	curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        echo "hello";
	$response = curl_exec($ch);
        echo "hello";
	curl_close($ch);
	echo "hello";
	// Process your response here
	echo $response;
        echo "hello"
?>