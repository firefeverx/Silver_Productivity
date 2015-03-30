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
    $content = $_GET['content'];
    $likes = $_GET['likes'];
     $questionId = $_GET["qid"];
 
    // get a product from products table

    $query = "INSERT INTO  subcomments (`id`,`content`,`likes`) VALUES
 				(". $id . ",\"" . $content . "\"," . $likes . ");";
    $result = mysql_query($query);

//    echo $query;
    
    

    
	if (!$result) {
        
      
		// no product found
		//$response["success"] = 0;
		$response["message"] = "Cannot Insert";
	 
		// echo no users JSON
		echo json_encode($response);
	}else{
		$result2 = mysql_query("INSERT INTO  postercomments (`posterid`,`commentid`) VALUES
 				(". $questionId . "," . $id . ");");

		    $result3 = mysql_query ("SELECT * FROM poster WHERE id =" . $questionId . ";");

		    while ( $row3 = mysql_fetch_array($result3)){
		       $new_comments  =  $row3[4] + 1;
		       $result4 = mysql_query ("UPDATE poster SET comments = ". $new_comments . ";");
		    }
        }
          
} else {
    // required field is missing
    //$response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    //echoing JSON response
    echo json_encode($response);
}
?>
