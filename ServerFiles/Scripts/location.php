<?php
    $con = mysqli_connect("localhost", "root", "Group@12", "food_for_you");
    
    $rest = $_POST["rest"];

    $statement = mysqli_prepare($con, "SELECT * FROM `rest_loca` WHERE name= '$rest'");
	mysqli_stmt_bind_param($statement,"sff", $name, $latitude, $longitude);
	mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $id, $name, $latitude, $longitude);
	
	$response['locat'] = array();
    $response["error"] = false;  
	
	while(mysqli_stmt_fetch($statement)){
         
		$row_array['name'] = $name;
		$row_array['latitude'] = $latitude;
		$row_array['longitude'] = $longitude;
		array_push($response['locat'],$row_array);
    }
	
	if(count($response['locat'])<1){
			$response["error"] = true;
    }
    echo json_encode($response);
    
  
?>