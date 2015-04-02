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
    $result = mysql_query("SELECT subcomments.id, subcomments.likes, subcomments.content FROM subcomments INNER JOIN postercomments  ON subcomments.id = postercomments.posterid");

    
    while ($row = mysql_fetch_array($result, MYSQL_ASSOC)){
	//$commentId  = $row[1];
//        $result2 = mysql_query("SELECT * FROM subcomments WHERE id = $commentId");
//        $row2 = mysql_fetch_array($result2m, MYSQL_ASSOC);
	$row_array["poster"]["id"] = $row["id"];
	$row_array["poster"]["likes"] = $row["likes"];
        $row_array["poster"]["content"] = $row["content"];

	 array_push($response, $row_array);

    }
 
}

 

    echo json_encode($response);

?>
