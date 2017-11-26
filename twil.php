<?php
// Required if your environment does not handle autoloading
//require __DIR__ . '/vendor/autoload.php';

// Use the REST API Client to make requests to the Twilio REST API
use Twilio\Rest\Client;

// Your Account SID and Auth Token from twilio.com/console
$sid = 'ACc70aa9a9c2f4fd1a86897555a483eb9d';
$token = 'ed97f110854345ca52b5495b39969472';
$client = new Client($sid, $token);

// Use the client to do fun stuff like send text messages!
$client->messages->create(
    // the number you'd like to send the message to
    '+918762357332',
    array(
        // A Twilio phone number you purchased at twilio.com/console
        'from' => '+12698046084',
        // the body of the text message you'd like to send
        'body' => 'Hey Jenny! Good luck on the bar exam!'
    )
);