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
 
    // get a product from products table
    $result = mysql_query("SELECT * FROM postercomments WHERE posterid = $id");

    
    while ($row = mysql_fetch_array($result)){
	$commentId  = $row[1];
        $result2 = mysql_query("SELECT * FROM subcomments WHERE id = $commentId");
        $row2 = mysql_fetch_array($result2);
	$row_array["poster"]["id"] = $row2["id"];
	$row_array["poster"]["likes"] = $row2["likes"];
        $row_array["poster"]["content"] = $row2["content"];

	 array_push($response, $row_array);
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
