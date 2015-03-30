<?php
 
/*
 * Following code will get single product details
 * A product is identified by product id (pid)
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// check for post data
if (isset($_GET["id"])) {
    $id = $_GET['id'];
    $title = $_GET['title'];
    $content = $_GET['content'];
    $likes = $_GET['likes'];
    $comments = $_GET['comments'];
    $author = $_GET['author'];
    $location = $_GET['location'];
    $time = $_GET[''];
 
    // get a product from products table
    $result = mysql_query("INSERT INTO poster (`id`,`title`,`content`,`likes`,`comments`,`author`,`location`, `time`) VALUES 				(". $id . "," . $title . "," . $content . "," . $likes . "," . $comment . "," . $author . "," . 				$location . "," . $time . ");");
 
    if (empty($result)) {
        
      
        // no product found
        //$response["success"] = 0;
        $response["message"] = "Cannot Insert";
 
        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    //$response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    //echoing JSON response
    echo json_encode($response);
}
?>
